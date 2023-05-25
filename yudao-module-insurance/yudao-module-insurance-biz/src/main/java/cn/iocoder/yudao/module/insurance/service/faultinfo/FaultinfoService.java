package cn.iocoder.yudao.module.insurance.service.faultinfo;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.insurance.controller.admin.faultinfo.vo.*;
import cn.iocoder.yudao.module.insurance.dal.dataobject.faultinfo.FaultinfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 故障信息子表 Service 接口
 *
 * @author 德尔开发
 */
public interface FaultinfoService {

    /**
     * 创建故障信息子表
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createFaultinfo(@Valid FaultinfoCreateReqVO createReqVO);

    /**
     * 更新故障信息子表
     *
     * @param updateReqVO 更新信息
     */
    void updateFaultinfo(@Valid FaultinfoUpdateReqVO updateReqVO);

    /**
     * 删除故障信息子表
     *
     * @param id 编号
     */
    void deleteFaultinfo(Long id);

    /**
     * 获得故障信息子表
     *
     * @param id 编号
     * @return 故障信息子表
     */
    FaultinfoDO getFaultinfo(Long id);

    /**
     * 获得故障信息子表列表
     *
     * @param ids 编号
     * @return 故障信息子表列表
     */
    List<FaultinfoDO> getFaultinfoList(Collection<Long> ids);

    /**
     * 获得故障信息子表分页
     *
     * @param pageReqVO 分页查询
     * @return 故障信息子表分页
     */
    PageResult<FaultinfoDO> getFaultinfoPage(FaultinfoPageReqVO pageReqVO);

    /**
     * 获得故障信息子表列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 故障信息子表列表
     */
    List<FaultinfoDO> getFaultinfoList(FaultinfoExportReqVO exportReqVO);

}
