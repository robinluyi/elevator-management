package cn.iocoder.yudao.module.insurance.service.order;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.iocoder.yudao.module.insurance.controller.admin.order.vo.*;
import cn.iocoder.yudao.module.insurance.dal.dataobject.order.InsuranceOrderDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.iocoder.yudao.module.insurance.convert.order.InsuranceOrderConvert;
import cn.iocoder.yudao.module.insurance.dal.mysql.order.InsuranceOrderMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.insurance.enums.ErrorCodeConstants.*;

/**
 * 保单 Service 实现类
 *
 * @author 德尔开发
 */
@Service
@Validated
public class InsuranceOrderServiceImpl implements InsuranceOrderService {

    @Resource
    private InsuranceOrderMapper orderMapper;

    @Override
    public Long createOrder(InsuranceOrderCreateReqVO createReqVO) {
        // 插入
        InsuranceOrderDO order = InsuranceOrderConvert.INSTANCE.convert(createReqVO);
        orderMapper.insert(order);
        // 返回
        return order.getId();
    }

    @Override
    public void updateOrder(InsuranceOrderUpdateReqVO updateReqVO) {
        // 校验存在
        validateOrderExists(updateReqVO.getId());
        // 更新
        InsuranceOrderDO updateObj = InsuranceOrderConvert.INSTANCE.convert(updateReqVO);
        orderMapper.updateById(updateObj);
    }

    @Override
    public void deleteOrder(Long id) {
        // 校验存在
        validateOrderExists(id);
        // 删除
        orderMapper.deleteById(id);
    }

    private void validateOrderExists(Long id) {
        if (orderMapper.selectById(id) == null) {
            throw exception(ORDER_NOT_EXISTS);
        }
    }

    @Override
    public InsuranceOrderDO getOrder(Long id) {
        return orderMapper.selectById(id);
    }

    @Override
    public List<InsuranceOrderDO> getOrderList(Collection<Long> ids) {
        return orderMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<InsuranceOrderDO> getOrderPage(InsuranceOrderPageReqVO pageReqVO) {
        return orderMapper.selectPage(pageReqVO);
    }

    @Override
    public List<InsuranceOrderDO> getOrderList(InsuranceOrderExportReqVO exportReqVO) {
        return orderMapper.selectList(exportReqVO);
    }

}
