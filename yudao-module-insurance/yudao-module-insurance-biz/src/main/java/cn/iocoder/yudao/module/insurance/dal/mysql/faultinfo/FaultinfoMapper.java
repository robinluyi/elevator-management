package cn.iocoder.yudao.module.insurance.dal.mysql.faultinfo;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.insurance.dal.dataobject.faultinfo.FaultinfoDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.insurance.controller.admin.faultinfo.vo.*;

/**
 * 故障信息子表 Mapper
 *
 * @author 德尔开发
 */
@Mapper
public interface FaultinfoMapper extends BaseMapperX<FaultinfoDO> {

    default PageResult<FaultinfoDO> selectPage(FaultinfoPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<FaultinfoDO>()
                .eqIfPresent(FaultinfoDO::getReparationId, reqVO.getReparationId())
                .betweenIfPresent(FaultinfoDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(FaultinfoDO::getId));
    }

    default List<FaultinfoDO> selectList(FaultinfoExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<FaultinfoDO>()
                .eqIfPresent(FaultinfoDO::getReparationId, reqVO.getReparationId())
                .betweenIfPresent(FaultinfoDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(FaultinfoDO::getId));
    }

}
