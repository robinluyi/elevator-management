package cn.iocoder.yudao.module.insurance.dal.mysql.order;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.insurance.dal.dataobject.order.InsuranceOrderDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.insurance.controller.admin.order.vo.*;

/**
 * 保单 Mapper
 *
 * @author 德尔开发
 */
@Mapper
public interface InsuranceOrderMapper extends BaseMapperX<InsuranceOrderDO> {

    default PageResult<InsuranceOrderDO> selectPage(InsuranceOrderPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<InsuranceOrderDO>()
                .eqIfPresent(InsuranceOrderDO::getOrderId, reqVO.getOrderId())
                .eqIfPresent(InsuranceOrderDO::getInsrType, reqVO.getInsrType())
                .likeIfPresent(InsuranceOrderDO::getProjectName, reqVO.getProjectName())
                .eqIfPresent(InsuranceOrderDO::getProvincial, reqVO.getProvincial())
                .eqIfPresent(InsuranceOrderDO::getCity, reqVO.getCity())
                .eqIfPresent(InsuranceOrderDO::getDistrict, reqVO.getDistrict())
                .eqIfPresent(InsuranceOrderDO::getStreet, reqVO.getStreet())
                .likeIfPresent(InsuranceOrderDO::getInsuredUsername, reqVO.getInsuredUsername())
                .betweenIfPresent(InsuranceOrderDO::getInsrStartTime, reqVO.getInsrStartTime())
                .betweenIfPresent(InsuranceOrderDO::getInsrEndTime, reqVO.getInsrEndTime())
                .eqIfPresent(InsuranceOrderDO::getTotal, reqVO.getTotal())
                .eqIfPresent(InsuranceOrderDO::getTotalStraight, reqVO.getTotalStraight())
                .eqIfPresent(InsuranceOrderDO::getTotalEscalator, reqVO.getTotalEscalator())
                .likeIfPresent(InsuranceOrderDO::getOrganizationName, reqVO.getOrganizationName())
                .eqIfPresent(InsuranceOrderDO::getComments, reqVO.getComments())
                .eqIfPresent(InsuranceOrderDO::getHasPart, reqVO.getHasPart())
                .betweenIfPresent(InsuranceOrderDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(InsuranceOrderDO::getId));
    }

    default List<InsuranceOrderDO> selectList(InsuranceOrderExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<InsuranceOrderDO>()
                .eqIfPresent(InsuranceOrderDO::getOrderId, reqVO.getOrderId())
                .eqIfPresent(InsuranceOrderDO::getInsrType, reqVO.getInsrType())
                .likeIfPresent(InsuranceOrderDO::getProjectName, reqVO.getProjectName())
                .eqIfPresent(InsuranceOrderDO::getProvincial, reqVO.getProvincial())
                .eqIfPresent(InsuranceOrderDO::getCity, reqVO.getCity())
                .eqIfPresent(InsuranceOrderDO::getDistrict, reqVO.getDistrict())
                .eqIfPresent(InsuranceOrderDO::getStreet, reqVO.getStreet())
                .likeIfPresent(InsuranceOrderDO::getInsuredUsername, reqVO.getInsuredUsername())
                .betweenIfPresent(InsuranceOrderDO::getInsrStartTime, reqVO.getInsrStartTime())
                .betweenIfPresent(InsuranceOrderDO::getInsrEndTime, reqVO.getInsrEndTime())
                .eqIfPresent(InsuranceOrderDO::getTotal, reqVO.getTotal())
                .eqIfPresent(InsuranceOrderDO::getTotalStraight, reqVO.getTotalStraight())
                .eqIfPresent(InsuranceOrderDO::getTotalEscalator, reqVO.getTotalEscalator())
                .likeIfPresent(InsuranceOrderDO::getOrganizationName, reqVO.getOrganizationName())
                .eqIfPresent(InsuranceOrderDO::getComments, reqVO.getComments())
                .eqIfPresent(InsuranceOrderDO::getHasPart, reqVO.getHasPart())
                .betweenIfPresent(InsuranceOrderDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(InsuranceOrderDO::getId));
    }

}
