package cn.iocoder.yudao.module.insurance.service.reparationpart;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.insurance.enums.ErrorCodeConstants.REPARATION_NOT_EXISTS;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.bpm.api.task.BpmProcessInstanceApi;
import cn.iocoder.yudao.module.bpm.api.task.dto.BpmProcessInstanceCreateReqDTO;
import cn.iocoder.yudao.module.bpm.controller.admin.task.vo.task.BpmTaskApproveReqVO;
import cn.iocoder.yudao.module.bpm.controller.admin.task.vo.task.BpmTaskRespVO;
import cn.iocoder.yudao.module.bpm.service.task.BpmTaskService;
import cn.iocoder.yudao.module.insurance.controller.admin.faultinfo.vo.FaultinfoPageReqVO;
import cn.iocoder.yudao.module.insurance.controller.admin.faultinfo.vo.FaultinfoRespVO;
import cn.iocoder.yudao.module.insurance.controller.admin.part.vo.PartExportReqVO;
import cn.iocoder.yudao.module.insurance.controller.admin.part.vo.PartPageReqVO;
import cn.iocoder.yudao.module.insurance.controller.admin.part.vo.PartRespVO;
import cn.iocoder.yudao.module.insurance.controller.admin.part.vo.PartUpdateReqVO;
import cn.iocoder.yudao.module.insurance.controller.admin.reparation.vo.ReparationRespVO;
import cn.iocoder.yudao.module.insurance.controller.admin.reparationpart.vo.CreatorPageReqVO;
import cn.iocoder.yudao.module.insurance.controller.admin.reparationpart.vo.EndUsagePageReqVO;
import cn.iocoder.yudao.module.insurance.controller.admin.reparationpart.vo.InsurancePageReqVO;
import cn.iocoder.yudao.module.insurance.controller.admin.reparationpart.vo.ReparationPartCreateReqVO;
import cn.iocoder.yudao.module.insurance.controller.admin.reparationpart.vo.ReparationPartPageReqVO;
import cn.iocoder.yudao.module.insurance.controller.admin.reparationpart.vo.ReparationPartRespVO;
import cn.iocoder.yudao.module.insurance.controller.admin.reparationpart.vo.ReparationPartUpdateReqVO;
import cn.iocoder.yudao.module.insurance.convert.faultinfo.FaultinfoConvert;
import cn.iocoder.yudao.module.insurance.convert.part.PartConvert;
import cn.iocoder.yudao.module.insurance.convert.reparation.ReparationConvert;
import cn.iocoder.yudao.module.insurance.dal.dataobject.faultinfo.FaultinfoDO;
import cn.iocoder.yudao.module.insurance.dal.dataobject.part.PartDO;
import cn.iocoder.yudao.module.insurance.dal.dataobject.reparation.ReparationDO;
import cn.iocoder.yudao.module.insurance.dal.mysql.faultinfo.FaultinfoMapper;
import cn.iocoder.yudao.module.insurance.dal.mysql.part.PartMapper;
import cn.iocoder.yudao.module.insurance.dal.mysql.reparation.ReparationMapper;
import cn.iocoder.yudao.module.insurance.service.faultinfo.FaultinfoService;
import cn.iocoder.yudao.module.insurance.service.part.PartService;
import cn.iocoder.yudao.module.insurance.service.reparation.ReparationService;
import cn.iocoder.yudao.module.system.api.dept.DeptApi;
import cn.iocoder.yudao.module.system.api.dept.dto.DeptRespDTO;
import cn.iocoder.yudao.module.system.api.user.AdminUserApi;
import cn.iocoder.yudao.module.system.api.user.dto.AdminUserRespDTO;

/**
 * 电梯报修申请 Service 实现类
 *
 * @author 德尔开发
 */
@Service
@Validated
public class ReparationPartServiceImpl implements ReparationPartService {


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
    @Resource
    private DeptApi deptApi;

    @Resource
    private AdminUserApi adminUserApi;
    @Resource
    private BpmTaskService bpmTaskService;

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
    public Long updateReparationPart(Long loginUserId,ReparationPartUpdateReqVO updateReqVO) {
        String taskName = UPDATE_FORM_TASK_NAME;
        return updateReparationPartOnStep(loginUserId, updateReqVO,taskName);
    }
    @Override
    public Long submitUpdatedReparationPart(Long loginUserId, ReparationPartUpdateReqVO updateReqVO) {
        String taskName = UPDATE_FORM_TASK_NAME;
        return submitReparationPartOnStep(loginUserId, updateReqVO, taskName);
    }
    @Override
    public Long endusageConfirmReparationPart(Long loginUserId,ReparationPartUpdateReqVO updateReqVO) {
        String taskName = ENDUSAGE_CONFIRM_FORM_TASK_NAME;
        return updateReparationPartOnStep(loginUserId, updateReqVO,taskName);
    }

    @Override
    public Long submitEndusageConfirmReparationPart(Long loginUserId, ReparationPartUpdateReqVO updateReqVO) {
        String taskName = ENDUSAGE_CONFIRM_FORM_TASK_NAME;
        return submitReparationPartOnStep(loginUserId, updateReqVO, taskName);
    }
    @Override
    public Long postrepairConfirmReparationPart(Long loginUserId, ReparationPartUpdateReqVO updateReqVO) {
        String taskName = POST_REPAIR_CONFIRM_TASK_NAME;
        return updateReparationPartOnStep(loginUserId, updateReqVO,taskName);
    }

    @Override
    public Long submitPostrepairReparationPart(Long loginUserId, ReparationPartUpdateReqVO updateReqVO) {
        String taskName = POST_REPAIR_CONFIRM_TASK_NAME;
        return submitReparationPartOnStep(loginUserId, updateReqVO, taskName);
    }

    @Override
    public PageResult<ReparationRespVO> getReparationPartPage4Insurance(Long loginUserId, InsurancePageReqVO pageVO) {
        PageResult<ReparationDO> reparationDOPageResult = reparationMapper.selectPage4Insurance(pageVO);
        PageResult<ReparationRespVO> reparationRespVOPageResult = ReparationConvert.INSTANCE.convertPage(reparationDOPageResult);
        return reparationRespVOPageResult;
    }

    @Override
    public PageResult<ReparationRespVO> getReparationPartPage4Endusage(Long loginUserId, EndUsagePageReqVO pageVO) {
        AdminUserRespDTO user = adminUserApi.getUser(loginUserId);
        DeptRespDTO endusageDept = deptApi.getDept(user.getDeptId());
        pageVO.setEndusageDeptId(endusageDept.getId());
        PageResult<ReparationDO> reparationDOPageResult = reparationMapper.selectPage4Endusage(pageVO);
        PageResult<ReparationRespVO> reparationRespVOPageResult = ReparationConvert.INSTANCE.convertPage(reparationDOPageResult);
        reparationRespVOPageResult.getList().stream().forEach(respvo -> {
            respvo.setTotalPrice(0L);
        });
        return reparationRespVOPageResult;
    }

    @Override
    public PageResult<ReparationRespVO> getReparationPartPage4Creator(Long loginUserId, CreatorPageReqVO pageVO) {
        pageVO.setUserId(loginUserId);

        PageResult<ReparationDO> reparationDOPageResult = reparationMapper.selectPage4Creator(pageVO);
        PageResult<ReparationRespVO> reparationRespVOPageResult = ReparationConvert.INSTANCE.convertPage(reparationDOPageResult);
        return reparationRespVOPageResult;
    }


    private Long updateReparationPartOnStep(Long loginUserId, ReparationPartUpdateReqVO updateReqVO , String taskName) {
        List<BpmTaskRespVO> taskRespVOList = bpmTaskService.getTaskListByProcessInstanceId(updateReqVO.getProcessInstanceId());
        String taskId = taskRespVOList.stream()
                .filter(vo -> taskName.equals(vo.getName()))
                .map(vo -> vo.getId())
                .findFirst().get();
        bpmTaskService.checkTask(loginUserId, taskId);

        Long reparationId = updateReqVO.getId();
        validateReparationPartExists(reparationId);
        ReparationDO updatedReparationDo = ReparationConvert.INSTANCE.convertUpdate(updateReqVO);
        reparationMapper.updateById(updatedReparationDo);

        // parts:
        List<PartDO> existingPartDOS = partMapper.selectList(new PartExportReqVO().setReparationId(reparationId));
        List<PartUpdateReqVO> partsReqVo = updateReqVO.getParts();
        Set<Long> existingPartIDS = existingPartDOS.stream()
                .map(PartDO::getId)
                .collect(Collectors.toSet());
        Set<Long> newPartIDs = partsReqVo.stream()
                .filter(vo -> vo.getId() != 0)
                .map(PartUpdateReqVO::getId)
                .collect(Collectors.toSet());
        //update part
        partsReqVo.stream().filter(vo -> existingPartIDS.contains(vo.getId()))
                .map(PartConvert.INSTANCE::convert)
                .forEach(partMapper::updateById);
        //insert new part
        partsReqVo.stream().filter(vo -> !existingPartIDS.contains(vo.getId()))
                .map(PartConvert.INSTANCE::convert)
                .map(partDO -> {
                    partDO.setId(null);
                    partDO.setReparationId(reparationId);
                    return partDO;
                })
                .forEach(partMapper::insert);
        //delete removed part
        existingPartIDS.stream().filter(id -> !newPartIDs.contains(id))
                .forEach(partMapper::deleteById);

        return reparationId;
    }



    private Long submitReparationPartOnStep(Long loginUserId, ReparationPartUpdateReqVO updateReqVO, String taskName) {
        Long reparationId = updateReparationPart(loginUserId, updateReqVO);
        BpmTaskApproveReqVO bpmTaskApproveReqVO = new BpmTaskApproveReqVO();
        bpmTaskApproveReqVO.setId("taskId");//taskId;
        List<BpmTaskRespVO> taskRespVOList = bpmTaskService.getTaskListByProcessInstanceId(updateReqVO.getProcessInstanceId());
        String taskId = taskRespVOList.stream()
                .filter(vo -> taskName.equals(vo.getName()))
                .map(vo -> vo.getId())
                .findFirst().get();
        BpmTaskApproveReqVO taskApproveReq =new BpmTaskApproveReqVO() ;
        taskApproveReq.setId(taskId);
        taskApproveReq.setPath("1");
        taskApproveReq.setReason("补充材料");
        bpmTaskService.approveTask(loginUserId,taskApproveReq);
        return reparationId;
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
        partRespVOS.sort(Comparator.comparing(PartRespVO::getId));
        reparationPartRespVO.setParts(partRespVOS);

        FaultinfoPageReqVO faultinfoPageReqVO = new FaultinfoPageReqVO().setReparationId(reparation.getId());
        faultinfoPageReqVO.setPageNo(1).setPageSize(10000);
        PageResult<FaultinfoDO> faultinfoPage = faultinfoService.getFaultinfoPage(faultinfoPageReqVO);
        List<FaultinfoRespVO> faultinfoRespVOList = FaultinfoConvert.INSTANCE.convertList(faultinfoPage.getList());
        reparationPartRespVO.setFaults(faultinfoRespVOList);



        reparationPartRespVO.setUserDeptName( deptApi.getDept(reparation.getUserDeptId()).getName());
        AdminUserRespDTO endusageManager = adminUserApi.getUser(reparationPartRespVO.getEndusageDeptManagerId());
        reparationPartRespVO.setEndusageDeptManagerName(endusageManager.getNickname());
        reparationPartRespVO.setEndusageDeptManagerPhone(endusageManager.getMobile());

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

    @Override
    public void updateReparationPart(Long id, Integer result) {
        validateReparationPartExists(id);
        reparationMapper.updateById(new ReparationDO().setId(id).setResult(result));
    }




}
