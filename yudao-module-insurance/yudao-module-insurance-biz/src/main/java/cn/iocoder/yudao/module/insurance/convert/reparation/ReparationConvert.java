package cn.iocoder.yudao.module.insurance.convert.reparation;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.iocoder.yudao.module.insurance.controller.admin.reparationpart.vo.ReparationPartRespVO;
import cn.iocoder.yudao.module.insurance.controller.admin.reparationpart.vo.ReparationPartUpdateReqVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.iocoder.yudao.module.insurance.controller.admin.reparation.vo.*;
import cn.iocoder.yudao.module.insurance.dal.dataobject.reparation.ReparationDO;

/**
 * 电梯报修申请 Convert
 *
 * @author 德尔开发
 */
@Mapper
public interface ReparationConvert {

    ReparationConvert INSTANCE = Mappers.getMapper(ReparationConvert.class);

    ReparationDO convert(ReparationCreateReqVO bean);

    ReparationDO convert(ReparationUpdateReqVO bean);

    ReparationRespVO convert(ReparationDO bean);

    List<ReparationRespVO> convertList(List<ReparationDO> list);

    PageResult<ReparationRespVO> convertPage(PageResult<ReparationDO> page);

    List<ReparationExcelVO> convertList02(List<ReparationDO> list);

    ReparationPartRespVO convert2(ReparationRespVO reparationRespVO);

    default ReparationDO convertUpdate(ReparationPartUpdateReqVO updateReqVO){
        if ( updateReqVO == null ) {
            return null;
        }

        ReparationDO.ReparationDOBuilder reparationDO = ReparationDO.builder();

        reparationDO.id( updateReqVO.getId() );
        reparationDO.userId( updateReqVO.getUserId() );
        reparationDO.userDeptId( updateReqVO.getUserDeptId() );
        reparationDO.userNickname( updateReqVO.getUserNickname() );
        reparationDO.userMobile( updateReqVO.getUserMobile() );
        reparationDO.endusageDeptId( updateReqVO.getEndusageDeptId() );
        reparationDO.endusageDeptName( updateReqVO.getEndusageDeptName() );
        reparationDO.endusageDeptManagerId( updateReqVO.getEndusageDeptManagerId() );
        reparationDO.elevtrId( updateReqVO.getElevtrId() );
        reparationDO.elevtrNumber( updateReqVO.getElevtrNumber() );
        reparationDO.maintainDeptId( updateReqVO.getMaintainDeptId() );
        reparationDO.maintainDeptName( updateReqVO.getMaintainDeptName() );
        reparationDO.registrationId( updateReqVO.getRegistrationId() );
        reparationDO.processInstanceId( updateReqVO.getProcessInstanceId() );
        reparationDO.totalPrice( updateReqVO.getTotalPrice() );
        reparationDO.result( updateReqVO.getResult() );
        reparationDO.userConfirmPic( updateReqVO.getUserConfirmPic() );
        reparationDO.endusageConfirmPic( updateReqVO.getEndusageConfirmPic() );
        return reparationDO.build();
    }

}
