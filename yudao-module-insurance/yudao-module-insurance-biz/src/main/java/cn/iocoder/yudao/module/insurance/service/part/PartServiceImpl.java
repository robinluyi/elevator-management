package cn.iocoder.yudao.module.insurance.service.part;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.iocoder.yudao.module.insurance.controller.admin.part.vo.*;
import cn.iocoder.yudao.module.insurance.dal.dataobject.part.PartDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.iocoder.yudao.module.insurance.convert.part.PartConvert;
import cn.iocoder.yudao.module.insurance.dal.mysql.part.PartMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.insurance.enums.ErrorCodeConstants.*;

/**
 * 报修零件子表 Service 实现类
 *
 * @author 德尔开发
 */
@Service
@Validated
public class PartServiceImpl implements PartService {

    @Resource
    private PartMapper partMapper;

    @Override
    public Long createPart(PartCreateReqVO createReqVO) {
        // 插入
        PartDO part = PartConvert.INSTANCE.convert(createReqVO);
        partMapper.insert(part);
        // 返回
        return part.getId();
    }

    @Override
    public void updatePart(PartUpdateReqVO updateReqVO) {
        // 校验存在
        validatePartExists(updateReqVO.getId());
        // 更新
        PartDO updateObj = PartConvert.INSTANCE.convert(updateReqVO);
        partMapper.updateById(updateObj);
    }

    @Override
    public void deletePart(Long id) {
        // 校验存在
        validatePartExists(id);
        // 删除
        partMapper.deleteById(id);
    }

    private void validatePartExists(Long id) {
        if (partMapper.selectById(id) == null) {
            throw exception(PART_NOT_EXISTS);
        }
    }

    @Override
    public PartDO getPart(Long id) {
        return partMapper.selectById(id);
    }

    @Override
    public List<PartDO> getPartList(Collection<Long> ids) {
        return partMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<PartDO> getPartPage(PartPageReqVO pageReqVO) {
        return partMapper.selectPage(pageReqVO);
    }

    @Override
    public List<PartDO> getPartList(PartExportReqVO exportReqVO) {
        return partMapper.selectList(exportReqVO);
    }

}
