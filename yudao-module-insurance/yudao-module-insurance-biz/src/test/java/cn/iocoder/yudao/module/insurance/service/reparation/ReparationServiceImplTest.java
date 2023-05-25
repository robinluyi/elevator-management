package cn.iocoder.yudao.module.insurance.service.reparation;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;

import cn.iocoder.yudao.module.insurance.controller.admin.reparation.vo.*;
import cn.iocoder.yudao.module.insurance.dal.dataobject.reparation.ReparationDO;
import cn.iocoder.yudao.module.insurance.dal.mysql.reparation.ReparationMapper;
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
 * {@link ReparationServiceImpl} 的单元测试类
 *
 * @author 德尔开发
 */
@Import(ReparationServiceImpl.class)
public class ReparationServiceImplTest extends BaseDbUnitTest {

    @Resource
    private ReparationServiceImpl reparationService;

    @Resource
    private ReparationMapper reparationMapper;

    @Test
    public void testCreateReparation_success() {
        // 准备参数
        ReparationCreateReqVO reqVO = randomPojo(ReparationCreateReqVO.class);

        // 调用
        Long reparationId = reparationService.createReparation(reqVO);
        // 断言
        assertNotNull(reparationId);
        // 校验记录的属性是否正确
        ReparationDO reparation = reparationMapper.selectById(reparationId);
        assertPojoEquals(reqVO, reparation);
    }

    @Test
    public void testUpdateReparation_success() {
        // mock 数据
        ReparationDO dbReparation = randomPojo(ReparationDO.class);
        reparationMapper.insert(dbReparation);// @Sql: 先插入出一条存在的数据
        // 准备参数
        ReparationUpdateReqVO reqVO = randomPojo(ReparationUpdateReqVO.class, o -> {
            o.setId(dbReparation.getId()); // 设置更新的 ID
        });

        // 调用
        reparationService.updateReparation(reqVO);
        // 校验是否更新正确
        ReparationDO reparation = reparationMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, reparation);
    }

    @Test
    public void testUpdateReparation_notExists() {
        // 准备参数
        ReparationUpdateReqVO reqVO = randomPojo(ReparationUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> reparationService.updateReparation(reqVO), REPARATION_NOT_EXISTS);
    }

    @Test
    public void testDeleteReparation_success() {
        // mock 数据
        ReparationDO dbReparation = randomPojo(ReparationDO.class);
        reparationMapper.insert(dbReparation);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbReparation.getId();

        // 调用
        reparationService.deleteReparation(id);
       // 校验数据不存在了
       assertNull(reparationMapper.selectById(id));
    }

    @Test
    public void testDeleteReparation_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> reparationService.deleteReparation(id), REPARATION_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetReparationPage() {
       // mock 数据
       ReparationDO dbReparation = randomPojo(ReparationDO.class, o -> { // 等会查询到
           o.setUserId(null);
           o.setUserDeptId(null);
           o.setUserNickname(null);
           o.setUserMobile(null);
           o.setEndusageDeptId(null);
           o.setEndusageDeptName(null);
           o.setEndusageDeptManagerId(null);
           o.setElevtrId(null);
           o.setElevtrNumber(null);
           o.setMaintainDeptId(null);
           o.setMaintainDeptName(null);
           o.setRegistrationId(null);
           o.setProcessInstanceId(null);
           o.setCreateTime(null);
           o.setTotalPrice(null);
       });
       reparationMapper.insert(dbReparation);
       // 测试 userId 不匹配
       reparationMapper.insert(cloneIgnoreId(dbReparation, o -> o.setUserId(null)));
       // 测试 userDeptId 不匹配
       reparationMapper.insert(cloneIgnoreId(dbReparation, o -> o.setUserDeptId(null)));
       // 测试 userNickname 不匹配
       reparationMapper.insert(cloneIgnoreId(dbReparation, o -> o.setUserNickname(null)));
       // 测试 userMobile 不匹配
       reparationMapper.insert(cloneIgnoreId(dbReparation, o -> o.setUserMobile(null)));
       // 测试 endusageDeptId 不匹配
       reparationMapper.insert(cloneIgnoreId(dbReparation, o -> o.setEndusageDeptId(null)));
       // 测试 endusageDeptName 不匹配
       reparationMapper.insert(cloneIgnoreId(dbReparation, o -> o.setEndusageDeptName(null)));
       // 测试 endusageDeptManagerId 不匹配
       reparationMapper.insert(cloneIgnoreId(dbReparation, o -> o.setEndusageDeptManagerId(null)));
       // 测试 elevtrId 不匹配
       reparationMapper.insert(cloneIgnoreId(dbReparation, o -> o.setElevtrId(null)));
       // 测试 elevtrNumber 不匹配
       reparationMapper.insert(cloneIgnoreId(dbReparation, o -> o.setElevtrNumber(null)));
       // 测试 maintainDeptId 不匹配
       reparationMapper.insert(cloneIgnoreId(dbReparation, o -> o.setMaintainDeptId(null)));
       // 测试 maintainDeptName 不匹配
       reparationMapper.insert(cloneIgnoreId(dbReparation, o -> o.setMaintainDeptName(null)));
       // 测试 registrationId 不匹配
       reparationMapper.insert(cloneIgnoreId(dbReparation, o -> o.setRegistrationId(null)));
       // 测试 processInstanceId 不匹配
       reparationMapper.insert(cloneIgnoreId(dbReparation, o -> o.setProcessInstanceId(null)));
       // 测试 createTime 不匹配
       reparationMapper.insert(cloneIgnoreId(dbReparation, o -> o.setCreateTime(null)));
       // 测试 totalPrice 不匹配
       reparationMapper.insert(cloneIgnoreId(dbReparation, o -> o.setTotalPrice(null)));
       // 准备参数
       ReparationPageReqVO reqVO = new ReparationPageReqVO();
       reqVO.setUserId(null);
       reqVO.setUserDeptId(null);
       reqVO.setUserNickname(null);
       reqVO.setUserMobile(null);
       reqVO.setEndusageDeptId(null);
       reqVO.setEndusageDeptName(null);
       reqVO.setEndusageDeptManagerId(null);
       reqVO.setElevtrId(null);
       reqVO.setElevtrNumber(null);
       reqVO.setMaintainDeptId(null);
       reqVO.setMaintainDeptName(null);
       reqVO.setRegistrationId(null);
       reqVO.setProcessInstanceId(null);
       reqVO.setCreateTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));
       reqVO.setTotalPrice(null);

       // 调用
       PageResult<ReparationDO> pageResult = reparationService.getReparationPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbReparation, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetReparationList() {
       // mock 数据
       ReparationDO dbReparation = randomPojo(ReparationDO.class, o -> { // 等会查询到
           o.setUserId(null);
           o.setUserDeptId(null);
           o.setUserNickname(null);
           o.setUserMobile(null);
           o.setEndusageDeptId(null);
           o.setEndusageDeptName(null);
           o.setEndusageDeptManagerId(null);
           o.setElevtrId(null);
           o.setElevtrNumber(null);
           o.setMaintainDeptId(null);
           o.setMaintainDeptName(null);
           o.setRegistrationId(null);
           o.setProcessInstanceId(null);
           o.setCreateTime(null);
           o.setTotalPrice(null);
       });
       reparationMapper.insert(dbReparation);
       // 测试 userId 不匹配
       reparationMapper.insert(cloneIgnoreId(dbReparation, o -> o.setUserId(null)));
       // 测试 userDeptId 不匹配
       reparationMapper.insert(cloneIgnoreId(dbReparation, o -> o.setUserDeptId(null)));
       // 测试 userNickname 不匹配
       reparationMapper.insert(cloneIgnoreId(dbReparation, o -> o.setUserNickname(null)));
       // 测试 userMobile 不匹配
       reparationMapper.insert(cloneIgnoreId(dbReparation, o -> o.setUserMobile(null)));
       // 测试 endusageDeptId 不匹配
       reparationMapper.insert(cloneIgnoreId(dbReparation, o -> o.setEndusageDeptId(null)));
       // 测试 endusageDeptName 不匹配
       reparationMapper.insert(cloneIgnoreId(dbReparation, o -> o.setEndusageDeptName(null)));
       // 测试 endusageDeptManagerId 不匹配
       reparationMapper.insert(cloneIgnoreId(dbReparation, o -> o.setEndusageDeptManagerId(null)));
       // 测试 elevtrId 不匹配
       reparationMapper.insert(cloneIgnoreId(dbReparation, o -> o.setElevtrId(null)));
       // 测试 elevtrNumber 不匹配
       reparationMapper.insert(cloneIgnoreId(dbReparation, o -> o.setElevtrNumber(null)));
       // 测试 maintainDeptId 不匹配
       reparationMapper.insert(cloneIgnoreId(dbReparation, o -> o.setMaintainDeptId(null)));
       // 测试 maintainDeptName 不匹配
       reparationMapper.insert(cloneIgnoreId(dbReparation, o -> o.setMaintainDeptName(null)));
       // 测试 registrationId 不匹配
       reparationMapper.insert(cloneIgnoreId(dbReparation, o -> o.setRegistrationId(null)));
       // 测试 processInstanceId 不匹配
       reparationMapper.insert(cloneIgnoreId(dbReparation, o -> o.setProcessInstanceId(null)));
       // 测试 createTime 不匹配
       reparationMapper.insert(cloneIgnoreId(dbReparation, o -> o.setCreateTime(null)));
       // 测试 totalPrice 不匹配
       reparationMapper.insert(cloneIgnoreId(dbReparation, o -> o.setTotalPrice(null)));
       // 准备参数
       ReparationExportReqVO reqVO = new ReparationExportReqVO();
       reqVO.setUserId(null);
       reqVO.setUserDeptId(null);
       reqVO.setUserNickname(null);
       reqVO.setUserMobile(null);
       reqVO.setEndusageDeptId(null);
       reqVO.setEndusageDeptName(null);
       reqVO.setEndusageDeptManagerId(null);
       reqVO.setElevtrId(null);
       reqVO.setElevtrNumber(null);
       reqVO.setMaintainDeptId(null);
       reqVO.setMaintainDeptName(null);
       reqVO.setRegistrationId(null);
       reqVO.setProcessInstanceId(null);
       reqVO.setCreateTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));
       reqVO.setTotalPrice(null);

       // 调用
       List<ReparationDO> list = reparationService.getReparationList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbReparation, list.get(0));
    }

}
