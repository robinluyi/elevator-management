package cn.iocoder.yudao.module.insurance.controller.admin.reparation.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.*;

@Schema(description = "管理后台 - 电梯报修申请创建 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ReparationCreateReqVO extends ReparationBaseVO {
    @Schema(description = "状态-参见 bpm_process_instance_result 枚举", example = "1")
    private Integer result;
}
