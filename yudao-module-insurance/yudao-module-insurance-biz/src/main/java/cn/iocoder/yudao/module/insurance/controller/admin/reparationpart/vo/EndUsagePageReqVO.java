package cn.iocoder.yudao.module.insurance.controller.admin.reparationpart.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.module.insurance.controller.admin.reparation.vo.ReparationPageReqVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 电梯用户 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class EndUsagePageReqVO extends PageParam {
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    @Schema(description = "申请时间")
    private LocalDateTime[] createTime;
    @Schema(description = "状态-参见 bpm_process_instance_result 枚举")
    private Integer result;
    @Schema(description = "原因-模糊匹配")
    private String reason;
    @Schema(description = "使用单位编号")
    private Long endusageDeptId;
}