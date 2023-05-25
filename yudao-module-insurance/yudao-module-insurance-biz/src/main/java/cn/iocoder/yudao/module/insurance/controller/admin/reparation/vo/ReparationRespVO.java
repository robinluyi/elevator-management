package cn.iocoder.yudao.module.insurance.controller.admin.reparation.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - 电梯报修申请 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ReparationRespVO extends ReparationBaseVO {

    @Schema(description = "维修表单主键", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long id;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
