package cn.iocoder.yudao.module.insurance.controller.admin.reparation.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import javax.validation.constraints.*;

@Schema(description = "管理后台 - 电梯报修申请更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ReparationUpdateReqVO extends ReparationBaseVO {

    @Schema(description = "维修表单主键", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "维修表单主键不能为空")
    private Long id;

}