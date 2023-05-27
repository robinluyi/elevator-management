package cn.iocoder.yudao.module.insurance.service.reparation;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.iocoder.yudao.module.insurance.controller.admin.reparation.vo.*;
import cn.iocoder.yudao.module.insurance.dal.dataobject.reparation.ReparationDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.iocoder.yudao.module.insurance.convert.reparation.ReparationConvert;
import cn.iocoder.yudao.module.insurance.dal.mysql.reparation.ReparationMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.insurance.enums.ErrorCodeConstants.*;

/**
 * 电梯报修申请 Service 实现类
 *
 * @author 德尔开发
 */
@Service
@Validated
public class ReparationServiceImpl implements ReparationService {
    /**
     * OA 请假对应的流程定义 KEY
     */
    public static final String PROCESS_KEY = "Insurance_reporting_proc_test";

    @Resource
    private ReparationMapper reparationMapper;

    @Override
    public Long createReparation(ReparationCreateReqVO createReqVO) {
        // 插入
        ReparationDO reparation = ReparationConvert.INSTANCE.convert(createReqVO);
        reparationMapper.insert(reparation);
        // 返回
        return reparation.getId();
    }

    @Override
    public void updateReparation(ReparationUpdateReqVO updateReqVO) {
        // 校验存在
        validateReparationExists(updateReqVO.getId());
        // 更新
        ReparationDO updateObj = ReparationConvert.INSTANCE.convert(updateReqVO);
        reparationMapper.updateById(updateObj);
    }

    @Override
    public void deleteReparation(Long id) {
        // 校验存在
        validateReparationExists(id);
        // 删除
        reparationMapper.deleteById(id);
    }

    private void validateReparationExists(Long id) {
        if (reparationMapper.selectById(id) == null) {
            throw exception(REPARATION_NOT_EXISTS);
        }
    }

    @Override
    public ReparationDO getReparation(Long id) {
        return reparationMapper.selectById(id);
    }

    @Override
    public List<ReparationDO> getReparationList(Collection<Long> ids) {
        return reparationMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<ReparationDO> getReparationPage(ReparationPageReqVO pageReqVO) {
        return reparationMapper.selectPage(pageReqVO);
    }

    @Override
    public List<ReparationDO> getReparationList(ReparationExportReqVO exportReqVO) {
        return reparationMapper.selectList(exportReqVO);
    }

}
