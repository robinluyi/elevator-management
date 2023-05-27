package cn.iocoder.yudao.module.bpm.controller.admin.button.vo;

import javax.validation.constraints.NotNull;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
/**
 * 按钮
 */
@Data
public class InsuranceButtonBaseVO {
    @Schema(description = "id", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "id不能为空")
    private String id;

    @Schema(description = "type", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "type")
    private String type;

    @Schema(description = "icon", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "icon不能为空")
    private String icon;

    @Schema(description = "task", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "task不能为空")
    private String task;

    @Schema(description = "text", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "text")
    private String text;

    @Schema(description = "path", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "path")
    private String path;
}
