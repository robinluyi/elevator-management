package cn.iocoder.yudao.module.insurance.controller.admin.reparationpart;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.iocoder.yudao.module.insurance.controller.admin.reparationpart.vo.ReparationPartCreateReqVO;
import cn.iocoder.yudao.module.insurance.controller.admin.reparationpart.vo.ReparationPartPageReqVO;
import cn.iocoder.yudao.module.insurance.controller.admin.reparationpart.vo.ReparationPartRespVO;
import cn.iocoder.yudao.module.insurance.controller.admin.reparationpart.vo.ReparationPartUpdateReqVO;
import cn.iocoder.yudao.module.insurance.service.reparationpart.ReparationPartService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;
import static cn.iocoder.yudao.framework.security.core.util.SecurityFrameworkUtils.getLoginUserId;


@Tag(name = "管理后台 - 电梯报修申请")
@RestController
@RequestMapping("/insurance/reparationpart")
@Validated
public class ReparationPartController {

    @Resource
    private ReparationPartService service;

    @PostMapping("/create")
    @PreAuthorize("@ss.hasPermission('insurance:reparation:create')")
    @Operation(summary = "创建电梯报修请求申请")
    public CommonResult<Long> createReparationPart(@Valid @RequestBody ReparationPartCreateReqVO createReqVO) {
        return success(service.createReparationPart(getLoginUserId(), createReqVO));
    }

    @GetMapping("/get")
    @PreAuthorize("@ss.hasPermission('insurance:reparation:query')")
    @Operation(summary = "获得电梯报修请求申请")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    public CommonResult<ReparationPartRespVO> getReparationPart(@RequestParam("id") Long id) {
        ReparationPartRespVO leave = service.getReparationPart(id);
        return success( leave);
    }

    @GetMapping("/page")
    @PreAuthorize("@ss.hasPermission('insurance:reparation:query')")
    @Operation(summary = "获得电梯报修请求申请分页")
    public CommonResult<PageResult< ReparationPartRespVO>> getReparationPartPage(@Valid ReparationPartPageReqVO pageVO) {
        PageResult< ReparationPartRespVO> pageResult = service.getReparationPartPage(getLoginUserId(), pageVO);
        return success( pageResult);
    }


    @PutMapping("/update")
    @PreAuthorize("@ss.hasPermission('insurance:reparation:create')")
    @Operation(summary = "更新电梯报修请求申请")
    public CommonResult<Long> updateReparationPart(@Validated @RequestBody ReparationPartUpdateReqVO updateReqVO) {
        return success(service.updateReparationPart(getLoginUserId(), updateReqVO));
    }
    @PutMapping("/updatesubmit")
    @PreAuthorize("@ss.hasPermission('insurance:reparation:create')")
    @Operation(summary = "重新提交电梯报修请求申请")
    public CommonResult<Long> submitUpdatedReparationPart(@Validated @RequestBody ReparationPartUpdateReqVO updateReqVO) {
        return success(service.submitUpdatedReparationPart(getLoginUserId(), updateReqVO));
    }

    @PutMapping("/endusageupdate")
    @PreAuthorize("@ss.hasPermission('insurance:reparation:create')")
    @Operation(summary = "保存物业确认")
    public CommonResult<Long> endusageupdate(@Validated @RequestBody ReparationPartUpdateReqVO updateReqVO) {
        return success(service.endusageConfirmReparationPart(getLoginUserId(), updateReqVO));
    }
    @PutMapping("/endusageupdatesubmit")
    @PreAuthorize("@ss.hasPermission('insurance:reparation:create')")
    @Operation(summary = "提交物业确认")
    public CommonResult<Long> endusageupdatesubmit(@Validated @RequestBody ReparationPartUpdateReqVO updateReqVO) {
        return success(service.submitEndusageConfirmReparationPart(getLoginUserId(), updateReqVO));
    }
    @PutMapping("/postrepairupdate")
    @PreAuthorize("@ss.hasPermission('insurance:reparation:create')")
    @Operation(summary = "保存物业确认")
    public CommonResult<Long> postrepairupdate(@Validated @RequestBody ReparationPartUpdateReqVO updateReqVO) {
        return success(service.postrepairConfirmReparationPart(getLoginUserId(), updateReqVO));
    }
    @PutMapping("/postrepairupdatesubmit")
    @PreAuthorize("@ss.hasPermission('insurance:reparation:create')")
    @Operation(summary = "提交物业确认")
    public CommonResult<Long> postrepairupdatesubmit(@Validated @RequestBody ReparationPartUpdateReqVO updateReqVO) {
        return success(service.submitPostrepairReparationPart(getLoginUserId(), updateReqVO));
    }
}
