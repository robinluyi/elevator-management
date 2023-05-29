package cn.iocoder.yudao.module.insurance.service.reparationpart;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.insurance.enums.ErrorCodeConstants.REPARATION_NOT_EXISTS;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import cn.iocoder.yudao.module.bpm.api.task.BpmProcessInstanceApi;
import cn.iocoder.yudao.module.bpm.api.task.dto.BpmProcessInstanceCreateReqDTO;
import cn.iocoder.yudao.module.insurance.controller.admin.faultinfo.vo.FaultinfoPageReqVO;
import cn.iocoder.yudao.module.insurance.controller.admin.faultinfo.vo.FaultinfoRespVO;
import cn.iocoder.yudao.module.insurance.convert.faultinfo.FaultinfoConvert;
import cn.iocoder.yudao.module.insurance.dal.dataobject.faultinfo.FaultinfoDO;
import cn.iocoder.yudao.module.insurance.service.faultinfo.FaultinfoService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.insurance.controller.admin.part.vo.PartPageReqVO;
import cn.iocoder.yudao.module.insurance.controller.admin.part.vo.PartRespVO;
import cn.iocoder.yudao.module.insurance.controller.admin.reparation.vo.ReparationRespVO;
import cn.iocoder.yudao.module.insurance.controller.admin.reparationpart.vo.ReparationPartCreateReqVO;
import cn.iocoder.yudao.module.insurance.controller.admin.reparationpart.vo.ReparationPartPageReqVO;
import cn.iocoder.yudao.module.insurance.controller.admin.reparationpart.vo.ReparationPartRespVO;
import cn.iocoder.yudao.module.insurance.controller.admin.reparationpart.vo.ReparationPartUpdateReqVO;
import cn.iocoder.yudao.module.insurance.convert.part.PartConvert;
import cn.iocoder.yudao.module.insurance.convert.reparation.ReparationConvert;
import cn.iocoder.yudao.module.insurance.dal.dataobject.part.PartDO;
import cn.iocoder.yudao.module.insurance.dal.dataobject.reparation.ReparationDO;
import cn.iocoder.yudao.module.insurance.dal.mysql.faultinfo.FaultinfoMapper;
import cn.iocoder.yudao.module.insurance.dal.mysql.part.PartMapper;
import cn.iocoder.yudao.module.insurance.dal.mysql.reparation.ReparationMapper;
import cn.iocoder.yudao.module.insurance.service.part.PartService;
import cn.iocoder.yudao.module.insurance.service.reparation.ReparationService;

/**
 * 电梯报修申请 Service 实现类
 *
 * @author 德尔开发
 */
@Service
@Validated
public class ReparationPartServiceImpl implements ReparationPartService {
    /**
     * OA 请假对应的流程定义 KEY
     */
    public static final String PROCESS_KEY = "Insurance_reporting_proc_test";

    @Resource
    private ReparationMapper reparationMapper;

    @Resource
    private PartMapper partMapper;

    @Resource
    private FaultinfoMapper faultinfoMapper;

    @Resource
    private ReparationService reparationService;

    @Resource
    private FaultinfoService faultinfoService;

    @Resource
    private PartService partService;
    @Resource
    private BpmProcessInstanceApi processInstanceApi;


    @Override
    public Long createReparationPart(Long userId, ReparationPartCreateReqVO createReqVO) {
        // 插入 OA 请假单
        createReqVO.setUserId(userId);
        Long total = createReqVO.getTotalPrice();
        Long endusageDeptManagerId = createReqVO.getEndusageDeptManagerId();

        Long reparationId = reparationService.createReparation(createReqVO);
        List<PartDO> partDOList = PartConvert.INSTANCE.convertList3(createReqVO.getParts());
        partDOList.forEach(partDO -> {
            partDO.setReparationId(reparationId);
            partDO.setCreator(String.valueOf(userId));
        });
        partMapper.insertBatch(partDOList);
        List<FaultinfoDO> faultinfoDOList = FaultinfoConvert.INSTANCE.convertList03(createReqVO.getFaults());
        faultinfoDOList.forEach(faultinfoDO -> {
            faultinfoDO.setReparationId(reparationId);
            faultinfoDO.setCreator(String.valueOf(userId));
        });
        faultinfoMapper.insertBatch(faultinfoDOList);
        // 发起 BPM 流程
        Map<String, Object> processInstanceVariables = new HashMap<>();
        processInstanceVariables.put("path", 1);
        processInstanceVariables.put("total", total);
        processInstanceVariables.put("endusage_dept_manager_id", endusageDeptManagerId);
        String processInstanceId = processInstanceApi.createProcessInstance(userId,
                new BpmProcessInstanceCreateReqDTO().setProcessDefinitionKey(PROCESS_KEY)
                        .setVariables(processInstanceVariables).setBusinessKey(String.valueOf(reparationId)));

        // 将工作流的编号，更新到 OA 请假单中
        reparationMapper.updateById(new ReparationDO().setId(reparationId).setProcessInstanceId(processInstanceId));
        partDOList.forEach(partDO -> {
            partDO.setProcessInstanceId(processInstanceId);
        });
        faultinfoDOList.forEach(faultinfoDO -> {
            faultinfoDO.setProcessInstanceId(processInstanceId);
        });
        partMapper.updateBatch(partDOList,partDOList.size());
        faultinfoMapper.updateBatch(faultinfoDOList,faultinfoDOList.size());
        return reparationId;
    }

    @Override
    public void updateReparationPart(ReparationPartUpdateReqVO updateReqVO) {
        // 校验存在
//        validateReparationExists(updateReqVO.getId());
//        // 更新
//        ReparationDO updateObj = ReparationConvert.INSTANCE.convert(updateReqVO);
//        reparationMapper.updateById(updateObj);
    }

   // @Override
   // public void deleteReparation(Long id) {
//        // 校验存在
//        validateReparationExists(id);
//        // 删除
//        reparationMapper.deleteById(id);
   // }

    private void validateReparationPartExists(Long id) {
        if (reparationMapper.selectById(id) == null) {
            throw exception(REPARATION_NOT_EXISTS);
        }
    }

    @Override
    public ReparationPartRespVO getReparationPart(Long id) {
        ReparationDO reparation = reparationService.getReparation(id);
        ReparationRespVO reparationRespVO = ReparationConvert.INSTANCE.convert(reparation);
        ReparationPartRespVO reparationPartRespVO = ReparationConvert.INSTANCE.convert2(reparationRespVO);

        PartPageReqVO partPageReqVO = new PartPageReqVO().setReparationId(reparation.getId());
        partPageReqVO.setPageNo(1).setPageSize(10000);
        PageResult<PartDO> partPage = partService.getPartPage(partPageReqVO);
        List<PartRespVO> partRespVOS = PartConvert.INSTANCE.convertList(partPage.getList());
        reparationPartRespVO.setParts(partRespVOS);

        FaultinfoPageReqVO faultinfoPageReqVO = new FaultinfoPageReqVO().setReparationId(reparation.getId());
        faultinfoPageReqVO.setPageNo(1).setPageSize(10000);
        PageResult<FaultinfoDO> faultinfoPage = faultinfoService.getFaultinfoPage(faultinfoPageReqVO);
        List<FaultinfoRespVO> faultinfoRespVOList = FaultinfoConvert.INSTANCE.convertList(faultinfoPage.getList());
        reparationPartRespVO.setFaults(faultinfoRespVOList);

        List<FaultinfoDO> reparaion_id = faultinfoMapper.selectList("reparation_id", String.valueOf(35));



        return reparationPartRespVO;
    }

    @Override
    public List<ReparationPartRespVO> getReparationPartList(Collection<Long> ids) {
        //return reparationMapper.selectBatchIds(ids);
        return null;
    }

    @Override
    public PageResult<ReparationPartRespVO> getReparationPartPage(Long id,ReparationPartPageReqVO pageReqVO) {
        //return reparationMapper.selectPage(pageReqVO);
        return null;
    }



}
