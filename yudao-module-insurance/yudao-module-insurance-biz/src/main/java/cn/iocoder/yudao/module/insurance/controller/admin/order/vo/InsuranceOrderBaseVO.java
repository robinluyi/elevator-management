package cn.iocoder.yudao.module.insurance.controller.admin.order.vo;

import javax.validation.constraints.NotNull;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 保单 Base VO，提供给添加、修改、详细的子 VO 使用
 * 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
 */
@Data
public class InsuranceOrderBaseVO {

    @Schema(description = "保单号", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "保单号不能为空")
    private String orderId;

    @Schema(description = "险种代码(ZHI,ZKM)", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "险种代码(ZHI,ZKM)不能为空")
    private String insrType;

    @Schema(description = "项目名称", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "项目名称不能为空")
    private String projectName;

    @Schema(description = "区", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "区不能为空")
    private String district;

    @Schema(description = "被保险人", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "被保险人不能为空")
    private String insuredUsername;

    @Schema(description = "电梯总数", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "电梯总数不能为空")
    private Integer total;

    @Schema(description = "机构名称", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "机构名称不能为空")
    private String organizationName;

}
