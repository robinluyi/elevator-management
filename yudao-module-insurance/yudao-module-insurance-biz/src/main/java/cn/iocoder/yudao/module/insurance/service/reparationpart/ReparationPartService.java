package cn.iocoder.yudao.module.insurance.service.reparationpart;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.insurance.controller.admin.reparationpart.vo.ReparationPartCreateReqVO;
import cn.iocoder.yudao.module.insurance.controller.admin.reparationpart.vo.ReparationPartPageReqVO;
import cn.iocoder.yudao.module.insurance.controller.admin.reparationpart.vo.ReparationPartRespVO;
import cn.iocoder.yudao.module.insurance.controller.admin.reparationpart.vo.ReparationPartUpdateReqVO;


import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

/**
 * 电梯报修申请 Service 接口
 *
 * @author 德尔开发
 */
public interface ReparationPartService {

    /**
     * 创建电梯报修申请
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createReparationPart(Long id, @Valid ReparationPartCreateReqVO createReqVO);

    /**
     * 更新电梯报修申请
     *
     * @param updateReqVO 更新信息
     */
    void updateReparationPart(@Valid ReparationPartUpdateReqVO updateReqVO);

    /**
     * 删除电梯报修申请
     *
     * @param id 编号
     */
    //void deleteReparationPart(Long id);

    /**
     * 获得电梯报修申请
     *
     * @param id 编号
     * @return 电梯报修申请
     */
    ReparationPartRespVO getReparationPart(Long id);

    /**
     * 获得电梯报修申请列表
     *
     * @param ids 编号
     * @return 电梯报修申请列表
     */
    List<ReparationPartRespVO> getReparationPartList(Collection<Long> ids);

    /**
     * 获得电梯报修申请分页
     *
     * @param pageReqVO 分页查询
     * @return 电梯报修申请分页
     */
    PageResult<ReparationPartRespVO> getReparationPartPage(Long id,ReparationPartPageReqVO pageReqVO);


}
