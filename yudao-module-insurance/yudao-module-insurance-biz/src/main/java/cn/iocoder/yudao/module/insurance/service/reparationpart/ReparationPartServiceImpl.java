package cn.iocoder.yudao.module.insurance.service.reparationpart;

import cn.hutool.core.date.LocalDateTimeUtil;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.insurance.controller.admin.part.vo.PartPageReqVO;
import cn.iocoder.yudao.module.insurance.controller.admin.part.vo.PartRespVO;
import cn.iocoder.yudao.module.insurance.controller.admin.reparation.vo.*;
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
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.insurance.enums.ErrorCodeConstants.REPARATION_NOT_EXISTS;

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
    private PartService partService;


    @Override
    public Long createReparationPart(Long userId, ReparationPartCreateReqVO createReqVO) {
          createReqVO.setUserId(userId);
          Long total = createReqVO.getTotalPrice();
          Long reparationId = reparationService.create(createReqVO);
         
          List<PartDO> partDOList = PartConvert.INSTANCE.convertList3(createReqVO.getParts());


          partDOList.forEach(partDO -> {
                partDO.setReparationId(reparationId);
                partDO.setUserId(userId);
                
          });
          

// 插入 OA 请假单
//        long day = LocalDateTimeUtil.between(createReqVO.getStartTime(), createReqVO.getEndTime()).toDays();
//        BpmOALeaveDO leave = BpmOALeaveConvert.INSTANCE.convert(createReqVO).setUserId(userId).setDay(day)
//                .setResult(BpmProcessInstanceResultEnum.PROCESS.getResult());
//        leaveMapper.insert(leave);
//
//        // 发起 BPM 流程
//        Map<String, Object> processInstanceVariables = new HashMap<>();
//        processInstanceVariables.put("day", day);
//        processInstanceVariables.put("path", 1);
//        processInstanceVariables.put("total", 10000);
//        processInstanceVariables.put("endusage_dept_manager_id", 133L);
//        String processInstanceId = processInstanceApi.createProcessInstance(userId,
//                new BpmProcessInstanceCreateReqDTO().setProcessDefinitionKey(PROCESS_KEY)
//                        .setVariables(processInstanceVariables).setBusinessKey(String.valueOf(leave.getId())));
//
//        // 将工作流的编号，更新到 OA 请假单中
//        leaveMapper.updateById(new BpmOALeaveDO().setId(leave.getId()).setProcessInstanceId(processInstanceId));
//        return leave.getId();
        return null;
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
        PartPageReqVO pageReqVO = new PartPageReqVO().setReparationId(reparation.getId());
        pageReqVO.setPageNo(1).setPageSize(10000);
        PageResult<PartDO> partPage = partService.getPartPage(pageReqVO);
        List<PartRespVO> partRespVOS = PartConvert.INSTANCE.convertList(partPage.getList());
        ReparationPartRespVO reparationPartRespVO = ReparationConvert.INSTANCE.convert2(reparationRespVO);
        reparationPartRespVO.setParts(partRespVOS);

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
