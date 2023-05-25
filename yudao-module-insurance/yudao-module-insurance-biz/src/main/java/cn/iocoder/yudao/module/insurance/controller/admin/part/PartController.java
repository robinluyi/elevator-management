package cn.iocoder.yudao.module.insurance.controller.admin.part;

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

import cn.iocoder.yudao.module.insurance.controller.admin.part.vo.*;
import cn.iocoder.yudao.module.insurance.dal.dataobject.part.PartDO;
import cn.iocoder.yudao.module.insurance.convert.part.PartConvert;
import cn.iocoder.yudao.module.insurance.service.part.PartService;

@Tag(name = "管理后台 - 报修零件子表")
@RestController
@RequestMapping("/insurance/part")
@Validated
public class PartController {

    @Resource
    private PartService partService;

    @PostMapping("/create")
    @Operation(summary = "创建报修零件子表")
    @PreAuthorize("@ss.hasPermission('insurance:part:create')")
    public CommonResult<Long> createPart(@Valid @RequestBody PartCreateReqVO createReqVO) {
        return success(partService.createPart(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新报修零件子表")
    @PreAuthorize("@ss.hasPermission('insurance:part:update')")
    public CommonResult<Boolean> updatePart(@Valid @RequestBody PartUpdateReqVO updateReqVO) {
        partService.updatePart(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除报修零件子表")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('insurance:part:delete')")
    public CommonResult<Boolean> deletePart(@RequestParam("id") Long id) {
        partService.deletePart(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得报修零件子表")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('insurance:part:query')")
    public CommonResult<PartRespVO> getPart(@RequestParam("id") Long id) {
        PartDO part = partService.getPart(id);
        return success(PartConvert.INSTANCE.convert(part));
    }

    @GetMapping("/list")
    @Operation(summary = "获得报修零件子表列表")
    @Parameter(name = "ids", description = "编号列表", required = true, example = "1024,2048")
    @PreAuthorize("@ss.hasPermission('insurance:part:query')")
    public CommonResult<List<PartRespVO>> getPartList(@RequestParam("ids") Collection<Long> ids) {
        List<PartDO> list = partService.getPartList(ids);
        return success(PartConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @Operation(summary = "获得报修零件子表分页")
    @PreAuthorize("@ss.hasPermission('insurance:part:query')")
    public CommonResult<PageResult<PartRespVO>> getPartPage(@Valid PartPageReqVO pageVO) {
        PageResult<PartDO> pageResult = partService.getPartPage(pageVO);
        return success(PartConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出报修零件子表 Excel")
    @PreAuthorize("@ss.hasPermission('insurance:part:export')")
    @OperateLog(type = EXPORT)
    public void exportPartExcel(@Valid PartExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<PartDO> list = partService.getPartList(exportReqVO);
        // 导出 Excel
        List<PartExcelVO> datas = PartConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "报修零件子表.xls", "数据", PartExcelVO.class, datas);
    }

}
