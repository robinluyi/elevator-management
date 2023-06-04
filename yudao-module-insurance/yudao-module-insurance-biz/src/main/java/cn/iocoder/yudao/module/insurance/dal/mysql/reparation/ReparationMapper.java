package cn.iocoder.yudao.module.insurance.dal.mysql.reparation;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.bpm.dal.dataobject.oa.BpmOALeaveDO;
import cn.iocoder.yudao.module.insurance.controller.admin.reparationpart.vo.CreatorPageReqVO;
import cn.iocoder.yudao.module.insurance.controller.admin.reparationpart.vo.EndUsagePageReqVO;
import cn.iocoder.yudao.module.insurance.controller.admin.reparationpart.vo.InsurancePageReqVO;
import cn.iocoder.yudao.module.insurance.dal.dataobject.reparation.ReparationDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.insurance.controller.admin.reparation.vo.*;

/**
 * 电梯报修申请 Mapper
 *
 * @author 德尔开发
 */
@Mapper
public interface ReparationMapper extends BaseMapperX<ReparationDO> {

    default PageResult<ReparationDO> selectPage(ReparationPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ReparationDO>()
                .eqIfPresent(ReparationDO::getUserId, reqVO.getUserId())
                .eqIfPresent(ReparationDO::getUserDeptId, reqVO.getUserDeptId())
                .likeIfPresent(ReparationDO::getUserNickname, reqVO.getUserNickname())
                .eqIfPresent(ReparationDO::getUserMobile, reqVO.getUserMobile())
                .eqIfPresent(ReparationDO::getEndusageDeptId, reqVO.getEndusageDeptId())
                .likeIfPresent(ReparationDO::getEndusageDeptName, reqVO.getEndusageDeptName())
                .eqIfPresent(ReparationDO::getEndusageDeptManagerId, reqVO.getEndusageDeptManagerId())
                .eqIfPresent(ReparationDO::getElevtrId, reqVO.getElevtrId())
                .eqIfPresent(ReparationDO::getElevtrNumber, reqVO.getElevtrNumber())
                .eqIfPresent(ReparationDO::getMaintainDeptId, reqVO.getMaintainDeptId())
                .likeIfPresent(ReparationDO::getMaintainDeptName, reqVO.getMaintainDeptName())
                .eqIfPresent(ReparationDO::getRegistrationId, reqVO.getRegistrationId())
                .eqIfPresent(ReparationDO::getProcessInstanceId, reqVO.getProcessInstanceId())
                .betweenIfPresent(ReparationDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(ReparationDO::getTotalPrice, reqVO.getTotalPrice())
                .orderByDesc(ReparationDO::getId));
    }

    default List<ReparationDO> selectList(ReparationExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<ReparationDO>()
                .eqIfPresent(ReparationDO::getUserId, reqVO.getUserId())
                .eqIfPresent(ReparationDO::getUserDeptId, reqVO.getUserDeptId())
                .likeIfPresent(ReparationDO::getUserNickname, reqVO.getUserNickname())
                .eqIfPresent(ReparationDO::getUserMobile, reqVO.getUserMobile())
                .eqIfPresent(ReparationDO::getEndusageDeptId, reqVO.getEndusageDeptId())
                .likeIfPresent(ReparationDO::getEndusageDeptName, reqVO.getEndusageDeptName())
                .eqIfPresent(ReparationDO::getEndusageDeptManagerId, reqVO.getEndusageDeptManagerId())
                .eqIfPresent(ReparationDO::getElevtrId, reqVO.getElevtrId())
                .eqIfPresent(ReparationDO::getElevtrNumber, reqVO.getElevtrNumber())
                .eqIfPresent(ReparationDO::getMaintainDeptId, reqVO.getMaintainDeptId())
                .likeIfPresent(ReparationDO::getMaintainDeptName, reqVO.getMaintainDeptName())
                .eqIfPresent(ReparationDO::getRegistrationId, reqVO.getRegistrationId())
                .eqIfPresent(ReparationDO::getProcessInstanceId, reqVO.getProcessInstanceId())
                .betweenIfPresent(ReparationDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(ReparationDO::getTotalPrice, reqVO.getTotalPrice())
                .orderByDesc(ReparationDO::getId));
    }

    default PageResult<ReparationDO> selectPage4Creator(CreatorPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ReparationDO>()
                .eqIfPresent(ReparationDO::getUserId, reqVO.getUserId())
                .betweenIfPresent(ReparationDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(ReparationDO::getResult, reqVO.getResult())
                .orderByDesc(ReparationDO::getId));
    }

    default PageResult<ReparationDO> selectPage4Endusage(EndUsagePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ReparationDO>()
                .eqIfPresent(ReparationDO::getEndusageDeptId, reqVO.getEndusageDeptId())
                .betweenIfPresent(ReparationDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(ReparationDO::getId));
    }

    default PageResult<ReparationDO> selectPage4Insurance(InsurancePageReqVO reqVO){
        return selectPage(reqVO, new LambdaQueryWrapperX<ReparationDO>()
                .eqIfPresent(ReparationDO::getUserId, reqVO.getUserId())
                .eqIfPresent(ReparationDO::getUserDeptId, reqVO.getUserDeptId())
                .likeIfPresent(ReparationDO::getUserNickname, reqVO.getUserNickname())
                .eqIfPresent(ReparationDO::getUserMobile, reqVO.getUserMobile())
                .eqIfPresent(ReparationDO::getEndusageDeptId, reqVO.getEndusageDeptId())
                .likeIfPresent(ReparationDO::getEndusageDeptName, reqVO.getEndusageDeptName())
                .eqIfPresent(ReparationDO::getEndusageDeptManagerId, reqVO.getEndusageDeptManagerId())
                .eqIfPresent(ReparationDO::getElevtrId, reqVO.getElevtrId())
                .eqIfPresent(ReparationDO::getElevtrNumber, reqVO.getElevtrNumber())
                .eqIfPresent(ReparationDO::getMaintainDeptId, reqVO.getMaintainDeptId())
                .likeIfPresent(ReparationDO::getMaintainDeptName, reqVO.getMaintainDeptName())
                .eqIfPresent(ReparationDO::getRegistrationId, reqVO.getRegistrationId())
                .eqIfPresent(ReparationDO::getProcessInstanceId, reqVO.getProcessInstanceId())
                .betweenIfPresent(ReparationDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(ReparationDO::getTotalPrice, reqVO.getTotalPrice())
                .orderByDesc(ReparationDO::getId));
    }
}
