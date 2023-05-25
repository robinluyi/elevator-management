package cn.iocoder.yudao.module.insurance.dal.mysql.part;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.insurance.dal.dataobject.part.PartDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.insurance.controller.admin.part.vo.*;

/**
 * 报修零件子表 Mapper
 *
 * @author 德尔开发
 */
@Mapper
public interface PartMapper extends BaseMapperX<PartDO> {

    default PageResult<PartDO> selectPage(PartPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<PartDO>()
                .eqIfPresent(PartDO::getReparationId, reqVO.getReparationId())
                .likeIfPresent(PartDO::getPartName, reqVO.getPartName())
                .eqIfPresent(PartDO::getPartUnitId, reqVO.getPartUnitId())
                .betweenIfPresent(PartDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(PartDO::getId));
    }

    default List<PartDO> selectList(PartExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<PartDO>()
                .eqIfPresent(PartDO::getReparationId, reqVO.getReparationId())
                .likeIfPresent(PartDO::getPartName, reqVO.getPartName())
                .eqIfPresent(PartDO::getPartUnitId, reqVO.getPartUnitId())
                .betweenIfPresent(PartDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(PartDO::getId));
    }

}
