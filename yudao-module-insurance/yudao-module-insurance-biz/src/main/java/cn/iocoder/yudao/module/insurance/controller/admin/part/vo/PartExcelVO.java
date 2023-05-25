package cn.iocoder.yudao.module.insurance.controller.admin.part.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 报修零件子表 Excel VO
 *
 * @author 德尔开发
 */
@Data
public class PartExcelVO {

    @ExcelProperty("报修零件主键")
    private Long id;

    @ExcelProperty("报修单号")
    private Long reparationId;

    @ExcelProperty("配件名称")
    private String partName;

    @ExcelProperty("单位")
    private Byte partUnitId;

    @ExcelProperty("单价")
    private Long partUnitPirce;

    @ExcelProperty("数量")
    private Long partQuantity;

    @ExcelProperty("小计")
    private Long partTotal;

    @ExcelProperty("流程实例的编号")
    private String processInstanceId;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
