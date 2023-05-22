package cn.iocoder.yudao.module.insurance.service.order;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.insurance.controller.admin.order.vo.*;
import cn.iocoder.yudao.module.insurance.dal.dataobject.order.InsuranceOrderDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 保单 Service 接口
 *
 * @author 德尔开发
 */
public interface InsuranceOrderService {

    /**
     * 创建保单
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createOrder(@Valid InsuranceOrderCreateReqVO createReqVO);

    /**
     * 更新保单
     *
     * @param updateReqVO 更新信息
     */
    void updateOrder(@Valid InsuranceOrderUpdateReqVO updateReqVO);

    /**
     * 删除保单
     *
     * @param id 编号
     */
    void deleteOrder(Long id);

    /**
     * 获得保单
     *
     * @param id 编号
     * @return 保单
     */
    InsuranceOrderDO getOrder(Long id);

    /**
     * 获得保单列表
     *
     * @param ids 编号
     * @return 保单列表
     */
    List<InsuranceOrderDO> getOrderList(Collection<Long> ids);

    /**
     * 获得保单分页
     *
     * @param pageReqVO 分页查询
     * @return 保单分页
     */
    PageResult<InsuranceOrderDO> getOrderPage(InsuranceOrderPageReqVO pageReqVO);

    /**
     * 获得保单列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 保单列表
     */
    List<InsuranceOrderDO> getOrderList(InsuranceOrderExportReqVO exportReqVO);

}
