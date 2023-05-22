package cn.iocoder.yudao.module.insurance.controller.admin.order.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 保单分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class InsuranceOrderPageReqVO extends PageParam {

    @Schema(description = "保单号")
    private String orderId;

    @Schema(description = "险种代码(ZHI,ZKM)")
    private String insrType;

    @Schema(description = "项目名称")
    private String projectName;

    @Schema(description = "省")
    private String provincial;

    @Schema(description = "市")
    private String city;

    @Schema(description = "区")
    private String district;

    @Schema(description = "街道")
    private String street;

    @Schema(description = "被保险人")
    private String insuredUsername;

    @Schema(description = "起保时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] insrStartTime;

    @Schema(description = "终保时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] insrEndTime;

    @Schema(description = "电梯总数")
    private Integer total;

    @Schema(description = "直梯总数")
    private Integer totalStraight;

    @Schema(description = "扶梯总数")
    private Integer totalEscalator;

    @Schema(description = "机构名称")
    private String organizationName;

    @Schema(description = "备注")
    private String comments;

    @Schema(description = "是否装配配件")
    private Byte hasPart;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
