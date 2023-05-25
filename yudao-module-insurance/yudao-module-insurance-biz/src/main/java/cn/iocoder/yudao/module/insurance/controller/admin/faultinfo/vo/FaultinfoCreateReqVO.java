package cn.iocoder.yudao.module.insurance.controller.admin.faultinfo.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.*;

@Schema(description = "管理后台 - 故障信息子表创建 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class FaultinfoCreateReqVO extends FaultinfoBaseVO {

    @Schema(description = "流程实例的编号")
    private String processInstanceId;

}
