package cn.iocoder.yudao.module.insurance.convert.part;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.iocoder.yudao.module.insurance.controller.admin.part.vo.*;
import cn.iocoder.yudao.module.insurance.dal.dataobject.part.PartDO;

/**
 * 报修零件子表 Convert
 *
 * @author 德尔开发
 */
@Mapper
public interface PartConvert {

    PartConvert INSTANCE = Mappers.getMapper(PartConvert.class);

    PartDO convert(PartCreateReqVO bean);

    PartDO convert(PartUpdateReqVO bean);

    PartRespVO convert(PartDO bean);

    List<PartRespVO> convertList(List<PartDO> list);

    PageResult<PartRespVO> convertPage(PageResult<PartDO> page);

    List<PartExcelVO> convertList02(List<PartDO> list);

    List<PartDO> convertList3(List<PartCreateReqVO> parts);
}
