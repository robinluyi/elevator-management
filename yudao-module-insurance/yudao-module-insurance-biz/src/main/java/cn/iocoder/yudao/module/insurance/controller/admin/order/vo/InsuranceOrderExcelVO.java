package cn.iocoder.yudao.module.insurance.controller.admin.order.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.LocalDateTime;

import com.alibaba.excel.annotation.ExcelProperty;
import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;


/**
 * 保单 Excel VO
 *
 * @author 德尔开发
 */
@Data
public class InsuranceOrderExcelVO {

    @ExcelProperty("编号")
    private Long id;

    @ExcelProperty("保单号")
    private String orderId;

    @ExcelProperty(value = "险种代码(ZHI,ZKM)", converter = DictConvert.class)
    @DictFormat("insurance_type") // TODO 代码优化：建议设置到对应的 XXXDictTypeConstants 枚举类中
    private String insrType;

    @ExcelProperty("项目名称")
    private String projectName;

    @ExcelProperty("区")
    private String district;

    @ExcelProperty("被保险人")
    private String insuredUsername;

    @ExcelProperty("电梯总数")
    private Integer total;

    @ExcelProperty("机构名称")
    private String organizationName;

}
