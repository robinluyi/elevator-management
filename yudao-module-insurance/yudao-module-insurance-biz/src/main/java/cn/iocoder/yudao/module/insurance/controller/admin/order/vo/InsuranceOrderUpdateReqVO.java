package cn.iocoder.yudao.module.insurance.controller.admin.order.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import javax.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 保单更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class InsuranceOrderUpdateReqVO extends InsuranceOrderBaseVO {
    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "编号不能为空")
    private Long id;

    @Schema(description = "省", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "省不能为空")
    private String provincial;

    @Schema(description = "市", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "市不能为空")
    private String city;

    @Schema(description = "街道", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "街道不能为空")
    private String street;

    @Schema(description = "起保时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "起保时间不能为空")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime insrStartTime;

    @Schema(description = "终保时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "终保时间不能为空")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime insrEndTime;

    @Schema(description = "直梯总数", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "直梯总数不能为空")
    private Integer totalStraight;

    @Schema(description = "扶梯总数", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "扶梯总数不能为空")
    private Integer totalEscalator;

    @Schema(description = "备注")
    private String comments;

    @Schema(description = "是否装配配件", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "是否装配配件不能为空")
    private Byte hasPart;

}
