package cn.iocoder.yudao.module.insurance.service.reparationpart;

import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.insurance.controller.admin.reparationpart.vo.ReparationPartCreateReqVO;
import cn.iocoder.yudao.module.insurance.controller.admin.reparationpart.vo.ReparationPartPageReqVO;
import cn.iocoder.yudao.module.insurance.controller.admin.reparationpart.vo.ReparationPartRespVO;
import cn.iocoder.yudao.module.insurance.controller.admin.reparationpart.vo.ReparationPartUpdateReqVO;

/**
 * 电梯报修申请 Service 接口
 *
 * @author 德尔开发
 */
public interface ReparationPartService {
    /**
     * OA 请假对应的流程定义 KEY
     */
    public final String PROCESS_KEY = "Insurance_reporting_proc_test";
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


    void updateReparationPart(Long id, Integer result);
}
