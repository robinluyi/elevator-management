package cn.iocoder.yudao.module.insurance.service.faultinfo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;

import cn.iocoder.yudao.module.insurance.controller.admin.faultinfo.vo.*;
import cn.iocoder.yudao.module.insurance.dal.dataobject.faultinfo.FaultinfoDO;
import cn.iocoder.yudao.module.insurance.dal.mysql.faultinfo.FaultinfoMapper;
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
 * {@link FaultinfoServiceImpl} 的单元测试类
 *
 * @author 德尔开发
 */
@Import(FaultinfoServiceImpl.class)
public class FaultinfoServiceImplTest extends BaseDbUnitTest {

    @Resource
    private FaultinfoServiceImpl faultinfoService;

    @Resource
    private FaultinfoMapper faultinfoMapper;

    @Test
    public void testCreateFaultinfo_success() {
        // 准备参数
        FaultinfoCreateReqVO reqVO = randomPojo(FaultinfoCreateReqVO.class);

        // 调用
        Long faultinfoId = faultinfoService.createFaultinfo(reqVO);
        // 断言
        assertNotNull(faultinfoId);
        // 校验记录的属性是否正确
        FaultinfoDO faultinfo = faultinfoMapper.selectById(faultinfoId);
        assertPojoEquals(reqVO, faultinfo);
    }

    @Test
    public void testUpdateFaultinfo_success() {
        // mock 数据
        FaultinfoDO dbFaultinfo = randomPojo(FaultinfoDO.class);
        faultinfoMapper.insert(dbFaultinfo);// @Sql: 先插入出一条存在的数据
        // 准备参数
        FaultinfoUpdateReqVO reqVO = randomPojo(FaultinfoUpdateReqVO.class, o -> {
            o.setId(dbFaultinfo.getId()); // 设置更新的 ID
        });

        // 调用
        faultinfoService.updateFaultinfo(reqVO);
        // 校验是否更新正确
        FaultinfoDO faultinfo = faultinfoMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, faultinfo);
    }

    @Test
    public void testUpdateFaultinfo_notExists() {
        // 准备参数
        FaultinfoUpdateReqVO reqVO = randomPojo(FaultinfoUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> faultinfoService.updateFaultinfo(reqVO), FAULTINFO_NOT_EXISTS);
    }

    @Test
    public void testDeleteFaultinfo_success() {
        // mock 数据
        FaultinfoDO dbFaultinfo = randomPojo(FaultinfoDO.class);
        faultinfoMapper.insert(dbFaultinfo);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbFaultinfo.getId();

        // 调用
        faultinfoService.deleteFaultinfo(id);
       // 校验数据不存在了
       assertNull(faultinfoMapper.selectById(id));
    }

    @Test
    public void testDeleteFaultinfo_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> faultinfoService.deleteFaultinfo(id), FAULTINFO_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetFaultinfoPage() {
       // mock 数据
       FaultinfoDO dbFaultinfo = randomPojo(FaultinfoDO.class, o -> { // 等会查询到
           o.setReparationId(null);
           o.setCreateTime(null);
       });
       faultinfoMapper.insert(dbFaultinfo);
       // 测试 reparationId 不匹配
       faultinfoMapper.insert(cloneIgnoreId(dbFaultinfo, o -> o.setReparationId(null)));
       // 测试 createTime 不匹配
       faultinfoMapper.insert(cloneIgnoreId(dbFaultinfo, o -> o.setCreateTime(null)));
       // 准备参数
       FaultinfoPageReqVO reqVO = new FaultinfoPageReqVO();
       reqVO.setReparationId(null);
       reqVO.setCreateTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));

       // 调用
       PageResult<FaultinfoDO> pageResult = faultinfoService.getFaultinfoPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbFaultinfo, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetFaultinfoList() {
       // mock 数据
       FaultinfoDO dbFaultinfo = randomPojo(FaultinfoDO.class, o -> { // 等会查询到
           o.setReparationId(null);
           o.setCreateTime(null);
       });
       faultinfoMapper.insert(dbFaultinfo);
       // 测试 reparationId 不匹配
       faultinfoMapper.insert(cloneIgnoreId(dbFaultinfo, o -> o.setReparationId(null)));
       // 测试 createTime 不匹配
       faultinfoMapper.insert(cloneIgnoreId(dbFaultinfo, o -> o.setCreateTime(null)));
       // 准备参数
       FaultinfoExportReqVO reqVO = new FaultinfoExportReqVO();
       reqVO.setReparationId(null);
       reqVO.setCreateTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));

       // 调用
       List<FaultinfoDO> list = faultinfoService.getFaultinfoList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbFaultinfo, list.get(0));
    }

}
