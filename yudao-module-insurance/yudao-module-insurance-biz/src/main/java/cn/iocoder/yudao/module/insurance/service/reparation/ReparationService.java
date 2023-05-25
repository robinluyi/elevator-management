package cn.iocoder.yudao.module.insurance.service.reparation;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.insurance.controller.admin.reparation.vo.*;
import cn.iocoder.yudao.module.insurance.dal.dataobject.reparation.ReparationDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 电梯报修申请 Service 接口
 *
 * @author 德尔开发
 */
public interface ReparationService {

    /**
     * 创建电梯报修申请
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createReparation(@Valid ReparationCreateReqVO createReqVO);

    /**
     * 更新电梯报修申请
     *
     * @param updateReqVO 更新信息
     */
    void updateReparation(@Valid ReparationUpdateReqVO updateReqVO);

    /**
     * 删除电梯报修申请
     *
     * @param id 编号
     */
    void deleteReparation(Long id);

    /**
     * 获得电梯报修申请
     *
     * @param id 编号
     * @return 电梯报修申请
     */
    ReparationDO getReparation(Long id);

    /**
     * 获得电梯报修申请列表
     *
     * @param ids 编号
     * @return 电梯报修申请列表
     */
    List<ReparationDO> getReparationList(Collection<Long> ids);

    /**
     * 获得电梯报修申请分页
     *
     * @param pageReqVO 分页查询
     * @return 电梯报修申请分页
     */
    PageResult<ReparationDO> getReparationPage(ReparationPageReqVO pageReqVO);

    /**
     * 获得电梯报修申请列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 电梯报修申请列表
     */
    List<ReparationDO> getReparationList(ReparationExportReqVO exportReqVO);

}
