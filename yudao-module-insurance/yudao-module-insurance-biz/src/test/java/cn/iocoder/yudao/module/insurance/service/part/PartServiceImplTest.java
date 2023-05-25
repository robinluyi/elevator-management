package cn.iocoder.yudao.module.insurance.service.part;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;

import cn.iocoder.yudao.module.insurance.controller.admin.part.vo.*;
import cn.iocoder.yudao.module.insurance.dal.dataobject.part.PartDO;
import cn.iocoder.yudao.module.insurance.dal.mysql.part.PartMapper;
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
 * {@link PartServiceImpl} 的单元测试类
 *
 * @author 德尔开发
 */
@Import(PartServiceImpl.class)
public class PartServiceImplTest extends BaseDbUnitTest {

    @Resource
    private PartServiceImpl partService;

    @Resource
    private PartMapper partMapper;

    @Test
    public void testCreatePart_success() {
        // 准备参数
        PartCreateReqVO reqVO = randomPojo(PartCreateReqVO.class);

        // 调用
        Long partId = partService.createPart(reqVO);
        // 断言
        assertNotNull(partId);
        // 校验记录的属性是否正确
        PartDO part = partMapper.selectById(partId);
        assertPojoEquals(reqVO, part);
    }

    @Test
    public void testUpdatePart_success() {
        // mock 数据
        PartDO dbPart = randomPojo(PartDO.class);
        partMapper.insert(dbPart);// @Sql: 先插入出一条存在的数据
        // 准备参数
        PartUpdateReqVO reqVO = randomPojo(PartUpdateReqVO.class, o -> {
            o.setId(dbPart.getId()); // 设置更新的 ID
        });

        // 调用
        partService.updatePart(reqVO);
        // 校验是否更新正确
        PartDO part = partMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, part);
    }

    @Test
    public void testUpdatePart_notExists() {
        // 准备参数
        PartUpdateReqVO reqVO = randomPojo(PartUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> partService.updatePart(reqVO), PART_NOT_EXISTS);
    }

    @Test
    public void testDeletePart_success() {
        // mock 数据
        PartDO dbPart = randomPojo(PartDO.class);
        partMapper.insert(dbPart);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbPart.getId();

        // 调用
        partService.deletePart(id);
       // 校验数据不存在了
       assertNull(partMapper.selectById(id));
    }

    @Test
    public void testDeletePart_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> partService.deletePart(id), PART_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetPartPage() {
       // mock 数据
       PartDO dbPart = randomPojo(PartDO.class, o -> { // 等会查询到
           o.setReparationId(null);
           o.setPartName(null);
           o.setPartUnitId(null);
           o.setCreateTime(null);
       });
       partMapper.insert(dbPart);
       // 测试 reparationId 不匹配
       partMapper.insert(cloneIgnoreId(dbPart, o -> o.setReparationId(null)));
       // 测试 partName 不匹配
       partMapper.insert(cloneIgnoreId(dbPart, o -> o.setPartName(null)));
       // 测试 partUnitId 不匹配
       partMapper.insert(cloneIgnoreId(dbPart, o -> o.setPartUnitId(null)));
       // 测试 createTime 不匹配
       partMapper.insert(cloneIgnoreId(dbPart, o -> o.setCreateTime(null)));
       // 准备参数
       PartPageReqVO reqVO = new PartPageReqVO();
       reqVO.setReparationId(null);
       reqVO.setPartName(null);
       reqVO.setPartUnitId(null);
       reqVO.setCreateTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));

       // 调用
       PageResult<PartDO> pageResult = partService.getPartPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbPart, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetPartList() {
       // mock 数据
       PartDO dbPart = randomPojo(PartDO.class, o -> { // 等会查询到
           o.setReparationId(null);
           o.setPartName(null);
           o.setPartUnitId(null);
           o.setCreateTime(null);
       });
       partMapper.insert(dbPart);
       // 测试 reparationId 不匹配
       partMapper.insert(cloneIgnoreId(dbPart, o -> o.setReparationId(null)));
       // 测试 partName 不匹配
       partMapper.insert(cloneIgnoreId(dbPart, o -> o.setPartName(null)));
       // 测试 partUnitId 不匹配
       partMapper.insert(cloneIgnoreId(dbPart, o -> o.setPartUnitId(null)));
       // 测试 createTime 不匹配
       partMapper.insert(cloneIgnoreId(dbPart, o -> o.setCreateTime(null)));
       // 准备参数
       PartExportReqVO reqVO = new PartExportReqVO();
       reqVO.setReparationId(null);
       reqVO.setPartName(null);
       reqVO.setPartUnitId(null);
       reqVO.setCreateTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));

       // 调用
       List<PartDO> list = partService.getPartList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbPart, list.get(0));
    }

}
