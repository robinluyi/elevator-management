package cn.iocoder.yudao.module.insurance.controller.admin.faultinfo.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import javax.validation.constraints.*;

@Schema(description = "管理后台 - 故障信息子表更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class FaultinfoUpdateReqVO extends FaultinfoBaseVO {

    @Schema(description = "故障信息主键", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "故障信息主键不能为空")
    private Long id;

    @Schema(description = "流程实例的编号")
    private String processInstanceId;

}
