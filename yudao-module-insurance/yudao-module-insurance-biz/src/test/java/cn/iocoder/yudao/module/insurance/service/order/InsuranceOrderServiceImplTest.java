package cn.iocoder.yudao.module.insurance.service.order;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;

import cn.iocoder.yudao.module.insurance.controller.admin.order.vo.*;
import cn.iocoder.yudao.module.insurance.dal.dataobject.order.InsuranceOrderDO;
import cn.iocoder.yudao.module.insurance.dal.mysql.order.InsuranceOrderMapper;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import javax.annotation.Resource;
import org.springframework.context.annotation.Import;
import java.util.*;
import java.time.LocalDateTime;

import static cn.hutool.core.util.RandomUtil.*;
import static cn.iocoder.yudao.module.insurance.enums.ErrorCodeConstants.*;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.*;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.*;
import static cn.iocoder.yudao.framework.common.util.date.LocalDateTimeUtils.*;
import static cn.iocoder.yudao.framework.common.util.object.ObjectUtils.*;
import static cn.iocoder.yudao.framework.common.util.date.DateUtils.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * {@link InsuranceOrderServiceImpl} 的单元测试类
 *
 * @author 德尔开发
 */
@Import(InsuranceOrderServiceImpl.class)
public class InsuranceOrderServiceImplTest extends BaseDbUnitTest {

    @Resource
    private InsuranceOrderServiceImpl orderService;

    @Resource
    private InsuranceOrderMapper orderMapper;

    @Test
    public void testCreateOrder_success() {
        // 准备参数
        InsuranceOrderCreateReqVO reqVO = randomPojo(InsuranceOrderCreateReqVO.class);

        // 调用
        Long orderId = orderService.createOrder(reqVO);
        // 断言
        assertNotNull(orderId);
        // 校验记录的属性是否正确
        InsuranceOrderDO order = orderMapper.selectById(orderId);
        assertPojoEquals(reqVO, order);
    }

    @Test
    public void testUpdateOrder_success() {
        // mock 数据
        InsuranceOrderDO dbOrder = randomPojo(InsuranceOrderDO.class);
        orderMapper.insert(dbOrder);// @Sql: 先插入出一条存在的数据
        // 准备参数
        InsuranceOrderUpdateReqVO reqVO = randomPojo(InsuranceOrderUpdateReqVO.class, o -> {
            o.setId(dbOrder.getId()); // 设置更新的 ID
        });

        // 调用
        orderService.updateOrder(reqVO);
        // 校验是否更新正确
        InsuranceOrderDO order = orderMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, order);
    }

    @Test
    public void testUpdateOrder_notExists() {
        // 准备参数
        InsuranceOrderUpdateReqVO reqVO = randomPojo(InsuranceOrderUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> orderService.updateOrder(reqVO), ORDER_NOT_EXISTS);
    }

    @Test
    public void testDeleteOrder_success() {
        // mock 数据
        InsuranceOrderDO dbOrder = randomPojo(InsuranceOrderDO.class);
        orderMapper.insert(dbOrder);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbOrder.getId();

        // 调用
        orderService.deleteOrder(id);
       // 校验数据不存在了
       assertNull(orderMapper.selectById(id));
    }

    @Test
    public void testDeleteOrder_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> orderService.deleteOrder(id), ORDER_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetOrderPage() {
       // mock 数据
       InsuranceOrderDO dbOrder = randomPojo(InsuranceOrderDO.class, o -> { // 等会查询到
           o.setOrderId(null);
           o.setInsrType(null);
           o.setProjectName(null);
           o.setProvincial(null);
           o.setCity(null);
           o.setDistrict(null);
           o.setStreet(null);
           o.setInsuredUsername(null);
           o.setInsrStartTime(null);
           o.setInsrEndTime(null);
           o.setTotal(null);
           o.setTotalStraight(null);
           o.setTotalEscalator(null);
           o.setOrganizationName(null);
           o.setComments(null);
           o.setHasPart(null);
           o.setCreateTime(null);
       });
       orderMapper.insert(dbOrder);
       // 测试 orderId 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setOrderId(null)));
       // 测试 insrType 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setInsrType(null)));
       // 测试 projectName 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setProjectName(null)));
       // 测试 provincial 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setProvincial(null)));
       // 测试 city 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setCity(null)));
       // 测试 district 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setDistrict(null)));
       // 测试 street 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setStreet(null)));
       // 测试 insuredUsername 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setInsuredUsername(null)));
       // 测试 insrStartTime 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setInsrStartTime(null)));
       // 测试 insrEndTime 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setInsrEndTime(null)));
       // 测试 total 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setTotal(null)));
       // 测试 totalStraight 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setTotalStraight(null)));
       // 测试 totalEscalator 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setTotalEscalator(null)));
       // 测试 organizationName 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setOrganizationName(null)));
       // 测试 comments 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setComments(null)));
       // 测试 hasPart 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setHasPart(null)));
       // 测试 createTime 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setCreateTime(null)));
       // 准备参数
       InsuranceOrderPageReqVO reqVO = new InsuranceOrderPageReqVO();
       reqVO.setOrderId(null);
       reqVO.setInsrType(null);
       reqVO.setProjectName(null);
       reqVO.setProvincial(null);
       reqVO.setCity(null);
       reqVO.setDistrict(null);
       reqVO.setStreet(null);
       reqVO.setInsuredUsername(null);
       reqVO.setInsrStartTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));
       reqVO.setInsrEndTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));
       reqVO.setTotal(null);
       reqVO.setTotalStraight(null);
       reqVO.setTotalEscalator(null);
       reqVO.setOrganizationName(null);
       reqVO.setComments(null);
       reqVO.setHasPart(null);
       reqVO.setCreateTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));

       // 调用
       PageResult<InsuranceOrderDO> pageResult = orderService.getOrderPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbOrder, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetOrderList() {
       // mock 数据
       InsuranceOrderDO dbOrder = randomPojo(InsuranceOrderDO.class, o -> { // 等会查询到
           o.setOrderId(null);
           o.setInsrType(null);
           o.setProjectName(null);
           o.setProvincial(null);
           o.setCity(null);
           o.setDistrict(null);
           o.setStreet(null);
           o.setInsuredUsername(null);
           o.setInsrStartTime(null);
           o.setInsrEndTime(null);
           o.setTotal(null);
           o.setTotalStraight(null);
           o.setTotalEscalator(null);
           o.setOrganizationName(null);
           o.setComments(null);
           o.setHasPart(null);
           o.setCreateTime(null);
       });
       orderMapper.insert(dbOrder);
       // 测试 orderId 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setOrderId(null)));
       // 测试 insrType 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setInsrType(null)));
       // 测试 projectName 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setProjectName(null)));
       // 测试 provincial 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setProvincial(null)));
       // 测试 city 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setCity(null)));
       // 测试 district 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setDistrict(null)));
       // 测试 street 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setStreet(null)));
       // 测试 insuredUsername 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setInsuredUsername(null)));
       // 测试 insrStartTime 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setInsrStartTime(null)));
       // 测试 insrEndTime 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setInsrEndTime(null)));
       // 测试 total 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setTotal(null)));
       // 测试 totalStraight 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setTotalStraight(null)));
       // 测试 totalEscalator 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setTotalEscalator(null)));
       // 测试 organizationName 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setOrganizationName(null)));
       // 测试 comments 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setComments(null)));
       // 测试 hasPart 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setHasPart(null)));
       // 测试 createTime 不匹配
       orderMapper.insert(cloneIgnoreId(dbOrder, o -> o.setCreateTime(null)));
       // 准备参数
       InsuranceOrderExportReqVO reqVO = new InsuranceOrderExportReqVO();
       reqVO.setOrderId(null);
       reqVO.setInsrType(null);
       reqVO.setProjectName(null);
       reqVO.setProvincial(null);
       reqVO.setCity(null);
       reqVO.setDistrict(null);
       reqVO.setStreet(null);
       reqVO.setInsuredUsername(null);
       reqVO.setInsrStartTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));
       reqVO.setInsrEndTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));
       reqVO.setTotal(null);
       reqVO.setTotalStraight(null);
       reqVO.setTotalEscalator(null);
       reqVO.setOrganizationName(null);
       reqVO.setComments(null);
       reqVO.setHasPart(null);
       reqVO.setCreateTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));

       // 调用
       List<InsuranceOrderDO> list = orderService.getOrderList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbOrder, list.get(0));
    }

}
