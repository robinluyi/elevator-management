package cn.iocoder.yudao.module.insurance.service.part;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.insurance.controller.admin.part.vo.*;
import cn.iocoder.yudao.module.insurance.dal.dataobject.part.PartDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 报修零件子表 Service 接口
 *
 * @author 德尔开发
 */
public interface PartService {

    /**
     * 创建报修零件子表
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createPart(@Valid PartCreateReqVO createReqVO);

    /**
     * 更新报修零件子表
     *
     * @param updateReqVO 更新信息
     */
    void updatePart(@Valid PartUpdateReqVO updateReqVO);

    /**
     * 删除报修零件子表
     *
     * @param id 编号
     */
    void deletePart(Long id);

    /**
     * 获得报修零件子表
     *
     * @param id 编号
     * @return 报修零件子表
     */
    PartDO getPart(Long id);

    /**
     * 获得报修零件子表列表
     *
     * @param ids 编号
     * @return 报修零件子表列表
     */
    List<PartDO> getPartList(Collection<Long> ids);

    /**
     * 获得报修零件子表分页
     *
     * @param pageReqVO 分页查询
     * @return 报修零件子表分页
     */
    PageResult<PartDO> getPartPage(PartPageReqVO pageReqVO);

    /**
     * 获得报修零件子表列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 报修零件子表列表
     */
    List<PartDO> getPartList(PartExportReqVO exportReqVO);

}
