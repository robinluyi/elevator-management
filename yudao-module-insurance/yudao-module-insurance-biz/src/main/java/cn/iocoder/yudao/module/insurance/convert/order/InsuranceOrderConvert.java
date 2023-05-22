package cn.iocoder.yudao.module.insurance.convert.order;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.iocoder.yudao.module.insurance.controller.admin.order.vo.*;
import cn.iocoder.yudao.module.insurance.dal.dataobject.order.InsuranceOrderDO;

/**
 * 保单 Convert
 *
 * @author 德尔开发
 */
@Mapper
public interface InsuranceOrderConvert {

    InsuranceOrderConvert INSTANCE = Mappers.getMapper(InsuranceOrderConvert.class);

    InsuranceOrderDO convert(InsuranceOrderCreateReqVO bean);

    InsuranceOrderDO convert(InsuranceOrderUpdateReqVO bean);

    InsuranceOrderRespVO convert(InsuranceOrderDO bean);

    List<InsuranceOrderRespVO> convertList(List<InsuranceOrderDO> list);

    PageResult<InsuranceOrderRespVO> convertPage(PageResult<InsuranceOrderDO> page);

    List<InsuranceOrderExcelVO> convertList02(List<InsuranceOrderDO> list);

}
