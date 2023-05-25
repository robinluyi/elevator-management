package cn.iocoder.yudao.module.insurance.controller.admin.part.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import javax.validation.constraints.*;

@Schema(description = "管理后台 - 报修零件子表更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PartUpdateReqVO extends PartBaseVO {

    @Schema(description = "报修零件主键", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "报修零件主键不能为空")
    private Long id;

}
