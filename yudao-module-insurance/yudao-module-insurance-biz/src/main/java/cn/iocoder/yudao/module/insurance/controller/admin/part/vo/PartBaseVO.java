package cn.iocoder.yudao.module.insurance.controller.admin.part.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import javax.validation.constraints.*;

/**
 * 报修零件子表 Base VO，提供给添加、修改、详细的子 VO 使用
 * 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
 */
@Data
public class PartBaseVO {

    @Schema(description = "报修单号", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "报修单号不能为空")
    private Long reparationId;

    @Schema(description = "配件名称", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "配件名称不能为空")
    private String partName;

    @Schema(description = "单位", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "单位不能为空")
    private Byte partUnitId;

    @Schema(description = "单价", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "单价不能为空")
    private Long partUnitPirce;

    @Schema(description = "数量", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "数量不能为空")
    private Long partQuantity;

    @Schema(description = "小计", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "小计不能为空")
    private Long partTotal;

    @Schema(description = "流程实例的编号")
    private String processInstanceId;

}
