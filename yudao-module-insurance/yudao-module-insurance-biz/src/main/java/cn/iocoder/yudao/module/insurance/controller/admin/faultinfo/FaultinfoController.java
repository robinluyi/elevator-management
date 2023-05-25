package cn.iocoder.yudao.module.insurance.controller.admin.faultinfo;

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

import cn.iocoder.yudao.module.insurance.controller.admin.faultinfo.vo.*;
import cn.iocoder.yudao.module.insurance.dal.dataobject.faultinfo.FaultinfoDO;
import cn.iocoder.yudao.module.insurance.convert.faultinfo.FaultinfoConvert;
import cn.iocoder.yudao.module.insurance.service.faultinfo.FaultinfoService;

@Tag(name = "管理后台 - 故障信息子表")
@RestController
@RequestMapping("/insurance/faultinfo")
@Validated
public class FaultinfoController {

    @Resource
    private FaultinfoService faultinfoService;

    @PostMapping("/create")
    @Operation(summary = "创建故障信息子表")
    @PreAuthorize("@ss.hasPermission('insurance:faultinfo:create')")
    public CommonResult<Long> createFaultinfo(@Valid @RequestBody FaultinfoCreateReqVO createReqVO) {
        return success(faultinfoService.createFaultinfo(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新故障信息子表")
    @PreAuthorize("@ss.hasPermission('insurance:faultinfo:update')")
    public CommonResult<Boolean> updateFaultinfo(@Valid @RequestBody FaultinfoUpdateReqVO updateReqVO) {
        faultinfoService.updateFaultinfo(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除故障信息子表")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('insurance:faultinfo:delete')")
    public CommonResult<Boolean> deleteFaultinfo(@RequestParam("id") Long id) {
        faultinfoService.deleteFaultinfo(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得故障信息子表")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('insurance:faultinfo:query')")
    public CommonResult<FaultinfoRespVO> getFaultinfo(@RequestParam("id") Long id) {
        FaultinfoDO faultinfo = faultinfoService.getFaultinfo(id);
        return success(FaultinfoConvert.INSTANCE.convert(faultinfo));
    }

    @GetMapping("/list")
    @Operation(summary = "获得故障信息子表列表")
    @Parameter(name = "ids", description = "编号列表", required = true, example = "1024,2048")
    @PreAuthorize("@ss.hasPermission('insurance:faultinfo:query')")
    public CommonResult<List<FaultinfoRespVO>> getFaultinfoList(@RequestParam("ids") Collection<Long> ids) {
        List<FaultinfoDO> list = faultinfoService.getFaultinfoList(ids);
        return success(FaultinfoConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @Operation(summary = "获得故障信息子表分页")
    @PreAuthorize("@ss.hasPermission('insurance:faultinfo:query')")
    public CommonResult<PageResult<FaultinfoRespVO>> getFaultinfoPage(@Valid FaultinfoPageReqVO pageVO) {
        PageResult<FaultinfoDO> pageResult = faultinfoService.getFaultinfoPage(pageVO);
        return success(FaultinfoConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出故障信息子表 Excel")
    @PreAuthorize("@ss.hasPermission('insurance:faultinfo:export')")
    @OperateLog(type = EXPORT)
    public void exportFaultinfoExcel(@Valid FaultinfoExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<FaultinfoDO> list = faultinfoService.getFaultinfoList(exportReqVO);
        // 导出 Excel
        List<FaultinfoExcelVO> datas = FaultinfoConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "故障信息子表.xls", "数据", FaultinfoExcelVO.class, datas);
    }

}
