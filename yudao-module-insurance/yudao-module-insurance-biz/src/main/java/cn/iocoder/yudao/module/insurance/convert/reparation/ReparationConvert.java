package cn.iocoder.yudao.module.insurance.convert.reparation;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

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

}
