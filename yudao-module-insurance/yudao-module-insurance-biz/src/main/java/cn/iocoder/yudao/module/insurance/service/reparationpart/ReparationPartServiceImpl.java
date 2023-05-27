package cn.iocoder.yudao.module.insurance.service.reparationpart;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.insurance.controller.admin.part.vo.PartPageReqVO;
import cn.iocoder.yudao.module.insurance.controller.admin.part.vo.PartRespVO;
import cn.iocoder.yudao.module.insurance.controller.admin.reparation.vo.*;
import cn.iocoder.yudao.module.insurance.controller.admin.reparationpart.vo.ReparationPartCreateReqVO;
import cn.iocoder.yudao.module.insurance.controller.admin.reparationpart.vo.ReparationPartPageReqVO;
import cn.iocoder.yudao.module.insurance.controller.admin.reparationpart.vo.ReparationPartRespVO;
import cn.iocoder.yudao.module.insurance.controller.admin.reparationpart.vo.ReparationPartUpdateReqVO;
import cn.iocoder.yudao.module.insurance.convert.part.PartConvert;
import cn.iocoder.yudao.module.insurance.convert.reparation.ReparationConvert;
import cn.iocoder.yudao.module.insurance.dal.dataobject.part.PartDO;
import cn.iocoder.yudao.module.insurance.dal.dataobject.reparation.ReparationDO;
import cn.iocoder.yudao.module.insurance.dal.mysql.faultinfo.FaultinfoMapper;
import cn.iocoder.yudao.module.insurance.dal.mysql.part.PartMapper;
import cn.iocoder.yudao.module.insurance.dal.mysql.reparation.ReparationMapper;
import cn.iocoder.yudao.module.insurance.service.part.PartService;
import cn.iocoder.yudao.module.insurance.service.reparation.ReparationService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.insurance.enums.ErrorCodeConstants.REPARATION_NOT_EXISTS;

/**
 * 电梯报修申请 Service 实现类
 *
 * @author 德尔开发
 */
@Service
@Validated
public class ReparationPartServiceImpl implements ReparationPartService {
    /**
     * OA 请假对应的流程定义 KEY
     */
    public static final String PROCESS_KEY = "Insurance_reporting_proc_test";

    @Resource
    private ReparationMapper reparationMapper;

    @Resource
    private PartMapper partMapper;

    @Resource
    private FaultinfoMapper faultinfoMapper;

    @Resource
    private ReparationService reparationService;

    @Resource
    private PartService partService;


    @Override
    public Long createReparationPart(Long id, ReparationPartCreateReqVO createReqVO) {
        // 插入
        //ReparationDO reparation = ReparationConvert.INSTANCE.convert(createReqVO);
        //reparationMapper.insert(reparation);
        // 返回
        //return reparation.getId();
        return null;
    }

    @Override
    public void updateReparationPart(ReparationPartUpdateReqVO updateReqVO) {
        // 校验存在
//        validateReparationExists(updateReqVO.getId());
//        // 更新
//        ReparationDO updateObj = ReparationConvert.INSTANCE.convert(updateReqVO);
//        reparationMapper.updateById(updateObj);
    }

   // @Override
   // public void deleteReparation(Long id) {
//        // 校验存在
//        validateReparationExists(id);
//        // 删除
//        reparationMapper.deleteById(id);
   // }

    private void validateReparationPartExists(Long id) {
        if (reparationMapper.selectById(id) == null) {
            throw exception(REPARATION_NOT_EXISTS);
        }
    }

    @Override
    public ReparationPartRespVO getReparationPart(Long id) {
        ReparationDO reparation = reparationService.getReparation(id);
        ReparationRespVO reparationRespVO = ReparationConvert.INSTANCE.convert(reparation);
        PartPageReqVO pageReqVO = new PartPageReqVO().setReparationId(reparation.getId());
        pageReqVO.setPageNo(1).setPageSize(10000);
        PageResult<PartDO> partPage = partService.getPartPage(pageReqVO);
        List<PartRespVO> partRespVOS = PartConvert.INSTANCE.convertList(partPage.getList());
        ReparationPartRespVO reparationPartRespVO = ReparationConvert.INSTANCE.convert2(reparationRespVO);
        reparationPartRespVO.setParts(partRespVOS);

        return reparationPartRespVO;
    }

    @Override
    public List<ReparationPartRespVO> getReparationPartList(Collection<Long> ids) {
        //return reparationMapper.selectBatchIds(ids);
        return null;
    }

    @Override
    public PageResult<ReparationPartRespVO> getReparationPartPage(Long id,ReparationPartPageReqVO pageReqVO) {
        //return reparationMapper.selectPage(pageReqVO);
        return null;
    }



}
