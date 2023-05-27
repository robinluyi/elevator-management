package cn.iocoder.yudao.module.bpm.controller.admin.task.vo.task;

import javax.validation.constraints.NotEmpty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "管理后台 - 通过流程任务的 Request VO")
@Data
public class BpmTaskApproveReqVO {

    @Schema(description = "任务编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotEmpty(message = "任务编号不能为空")
    private String id;

    @Schema(description = "审批意见", requiredMode = Schema.RequiredMode.REQUIRED, example = "不错不错！")
    @NotEmpty(message = "审批意见不能为空")
    private String reason;

    @Schema(description = "任务步骤代码", requiredMode = Schema.RequiredMode.NOT_REQUIRED, defaultValue = "", example = "step1")
    private String step;

    @Schema(description = "路径流向", requiredMode = Schema.RequiredMode.NOT_REQUIRED, defaultValue = "1",example = "1")
    private String path;

    

}
