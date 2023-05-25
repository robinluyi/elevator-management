package cn.iocoder.yudao.module.insurance.service.faultinfo;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.iocoder.yudao.module.insurance.controller.admin.faultinfo.vo.*;
import cn.iocoder.yudao.module.insurance.dal.dataobject.faultinfo.FaultinfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.iocoder.yudao.module.insurance.convert.faultinfo.FaultinfoConvert;
import cn.iocoder.yudao.module.insurance.dal.mysql.faultinfo.FaultinfoMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.insurance.enums.ErrorCodeConstants.*;

/**
 * 故障信息子表 Service 实现类
 *
 * @author 德尔开发
 */
@Service
@Validated
public class FaultinfoServiceImpl implements FaultinfoService {

    @Resource
    private FaultinfoMapper faultinfoMapper;

    @Override
    public Long createFaultinfo(FaultinfoCreateReqVO createReqVO) {
        // 插入
        FaultinfoDO faultinfo = FaultinfoConvert.INSTANCE.convert(createReqVO);
        faultinfoMapper.insert(faultinfo);
        // 返回
        return faultinfo.getId();
    }

    @Override
    public void updateFaultinfo(FaultinfoUpdateReqVO updateReqVO) {
        // 校验存在
        validateFaultinfoExists(updateReqVO.getId());
        // 更新
        FaultinfoDO updateObj = FaultinfoConvert.INSTANCE.convert(updateReqVO);
        faultinfoMapper.updateById(updateObj);
    }

    @Override
    public void deleteFaultinfo(Long id) {
        // 校验存在
        validateFaultinfoExists(id);
        // 删除
        faultinfoMapper.deleteById(id);
    }

    private void validateFaultinfoExists(Long id) {
        if (faultinfoMapper.selectById(id) == null) {
            throw exception(FAULTINFO_NOT_EXISTS);
        }
    }

    @Override
    public FaultinfoDO getFaultinfo(Long id) {
        return faultinfoMapper.selectById(id);
    }

    @Override
    public List<FaultinfoDO> getFaultinfoList(Collection<Long> ids) {
        return faultinfoMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<FaultinfoDO> getFaultinfoPage(FaultinfoPageReqVO pageReqVO) {
        return faultinfoMapper.selectPage(pageReqVO);
    }

    @Override
    public List<FaultinfoDO> getFaultinfoList(FaultinfoExportReqVO exportReqVO) {
        return faultinfoMapper.selectList(exportReqVO);
    }

}
