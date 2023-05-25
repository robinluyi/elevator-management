package cn.iocoder.yudao.module.insurance.controller.admin.reparation;

import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Operation;

import javax.validation.constraints.*;
import javax.validation.*;
import javax.servlet.http.*;
import java.util.*;
import java.io.IOException;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;

import cn.iocoder.yudao.framework.operatelog.core.annotations.OperateLog;
import static cn.iocoder.yudao.framework.operatelog.core.enums.OperateTypeEnum.*;

import cn.iocoder.yudao.module.insurance.controller.admin.reparation.vo.*;
import cn.iocoder.yudao.module.insurance.dal.dataobject.reparation.ReparationDO;
import cn.iocoder.yudao.module.insurance.convert.reparation.ReparationConvert;
import cn.iocoder.yudao.module.insurance.service.reparation.ReparationService;

@Tag(name = "管理后台 - 电梯报修申请")
@RestController
@RequestMapping("/insurance/reparation")
@Validated
public class ReparationController {

    @Resource
    private ReparationService reparationService;

    @PostMapping("/create")
    @Operation(summary = "创建电梯报修申请")
    @PreAuthorize("@ss.hasPermission('insurance:reparation:create')")
    public CommonResult<Long> createReparation(@Valid @RequestBody ReparationCreateReqVO createReqVO) {
        return success(reparationService.createReparation(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新电梯报修申请")
    @PreAuthorize("@ss.hasPermission('insurance:reparation:update')")
    public CommonResult<Boolean> updateReparation(@Valid @RequestBody ReparationUpdateReqVO updateReqVO) {
        reparationService.updateReparation(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除电梯报修申请")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('insurance:reparation:delete')")
    public CommonResult<Boolean> deleteReparation(@RequestParam("id") Long id) {
        reparationService.deleteReparation(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得电梯报修申请")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('insurance:reparation:query')")
    public CommonResult<ReparationRespVO> getReparation(@RequestParam("id") Long id) {
        ReparationDO reparation = reparationService.getReparation(id);
        return success(ReparationConvert.INSTANCE.convert(reparation));
    }

    @GetMapping("/list")
    @Operation(summary = "获得电梯报修申请列表")
    @Parameter(name = "ids", description = "编号列表", required = true, example = "1024,2048")
    @PreAuthorize("@ss.hasPermission('insurance:reparation:query')")
    public CommonResult<List<ReparationRespVO>> getReparationList(@RequestParam("ids") Collection<Long> ids) {
        List<ReparationDO> list = reparationService.getReparationList(ids);
        return success(ReparationConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @Operation(summary = "获得电梯报修申请分页")
    @PreAuthorize("@ss.hasPermission('insurance:reparation:query')")
    public CommonResult<PageResult<ReparationRespVO>> getReparationPage(@Valid ReparationPageReqVO pageVO) {
        PageResult<ReparationDO> pageResult = reparationService.getReparationPage(pageVO);
        return success(ReparationConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出电梯报修申请 Excel")
    @PreAuthorize("@ss.hasPermission('insurance:reparation:export')")
    @OperateLog(type = EXPORT)
    public void exportReparationExcel(@Valid ReparationExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<ReparationDO> list = reparationService.getReparationList(exportReqVO);
        // 导出 Excel
        List<ReparationExcelVO> datas = ReparationConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "电梯报修申请.xls", "数据", ReparationExcelVO.class, datas);
    }

}
