package cn.iocoder.yudao.module.insurance.controller.admin.order;

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

import cn.iocoder.yudao.module.insurance.controller.admin.order.vo.*;
import cn.iocoder.yudao.module.insurance.dal.dataobject.order.InsuranceOrderDO;
import cn.iocoder.yudao.module.insurance.convert.order.InsuranceOrderConvert;
import cn.iocoder.yudao.module.insurance.service.order.InsuranceOrderService;

@Tag(name = "管理后台 - 保单")
@RestController
@RequestMapping("/insurance/order")
@Validated
public class InsuranceOrderController {

    @Resource
    private InsuranceOrderService orderService;

    @PostMapping("/create")
    @Operation(summary = "创建保单")
    @PreAuthorize("@ss.hasPermission('insurance:order:create')")
    public CommonResult<Long> createOrder(@Valid @RequestBody InsuranceOrderCreateReqVO createReqVO) {
        return success(orderService.createOrder(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新保单")
    @PreAuthorize("@ss.hasPermission('insurance:order:update')")
    public CommonResult<Boolean> updateOrder(@Valid @RequestBody InsuranceOrderUpdateReqVO updateReqVO) {
        orderService.updateOrder(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除保单")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('insurance:order:delete')")
    public CommonResult<Boolean> deleteOrder(@RequestParam("id") Long id) {
        orderService.deleteOrder(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得保单")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('insurance:order:query')")
    public CommonResult<InsuranceOrderRespVO> getOrder(@RequestParam("id") Long id) {
        InsuranceOrderDO order = orderService.getOrder(id);
        return success(InsuranceOrderConvert.INSTANCE.convert(order));
    }

    @GetMapping("/list")
    @Operation(summary = "获得保单列表")
    @Parameter(name = "ids", description = "编号列表", required = true, example = "1024,2048")
    @PreAuthorize("@ss.hasPermission('insurance:order:query')")
    public CommonResult<List<InsuranceOrderRespVO>> getOrderList(@RequestParam("ids") Collection<Long> ids) {
        List<InsuranceOrderDO> list = orderService.getOrderList(ids);
        return success(InsuranceOrderConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @Operation(summary = "获得保单分页")
    @PreAuthorize("@ss.hasPermission('insurance:order:query')")
    public CommonResult<PageResult<InsuranceOrderRespVO>> getOrderPage(@Valid InsuranceOrderPageReqVO pageVO) {
        PageResult<InsuranceOrderDO> pageResult = orderService.getOrderPage(pageVO);
        return success(InsuranceOrderConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出保单 Excel")
    @PreAuthorize("@ss.hasPermission('insurance:order:export')")
    @OperateLog(type = EXPORT)
    public void exportOrderExcel(@Valid InsuranceOrderExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<InsuranceOrderDO> list = orderService.getOrderList(exportReqVO);
        // 导出 Excel
        List<InsuranceOrderExcelVO> datas = InsuranceOrderConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "保单.xls", "数据", InsuranceOrderExcelVO.class, datas);
    }

}
