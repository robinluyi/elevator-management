package cn.iocoder.yudao.module.insurance.convert.faultinfo;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.iocoder.yudao.module.insurance.controller.admin.faultinfo.vo.*;
import cn.iocoder.yudao.module.insurance.dal.dataobject.faultinfo.FaultinfoDO;

/**
 * 故障信息子表 Convert
 *
 * @author 德尔开发
 */
@Mapper
public interface FaultinfoConvert {

    FaultinfoConvert INSTANCE = Mappers.getMapper(FaultinfoConvert.class);

    FaultinfoDO convert(FaultinfoCreateReqVO bean);

    FaultinfoDO convert(FaultinfoUpdateReqVO bean);

    FaultinfoRespVO convert(FaultinfoDO bean);

    List<FaultinfoRespVO> convertList(List<FaultinfoDO> list);

    PageResult<FaultinfoRespVO> convertPage(PageResult<FaultinfoDO> page);

    List<FaultinfoExcelVO> convertList02(List<FaultinfoDO> list);

}
