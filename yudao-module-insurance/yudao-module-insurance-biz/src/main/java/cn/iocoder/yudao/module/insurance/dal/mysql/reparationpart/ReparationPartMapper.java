package cn.iocoder.yudao.module.insurance.dal.mysql.reparationpart;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.insurance.controller.admin.reparation.vo.ReparationExportReqVO;
import cn.iocoder.yudao.module.insurance.controller.admin.reparation.vo.ReparationPageReqVO;
import cn.iocoder.yudao.module.insurance.controller.admin.reparationpart.vo.ReparationPartPageReqVO;
import cn.iocoder.yudao.module.insurance.dal.dataobject.reparation.ReparationDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 电梯报修申请 Mapper
 *
 * @author 德尔开发
 */
@Mapper
public interface ReparationPartMapper extends BaseMapperX<ReparationDO> {
    // do not call this
}
