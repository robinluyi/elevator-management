package cn.iocoder.yudao.module.insurance.controller.admin.part.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 报修零件子表 Excel 导出 Request VO，参数和 PartPageReqVO 是一致的")
@Data
public class PartExportReqVO {

    @Schema(description = "报修单号")
    private Long reparationId;

    @Schema(description = "配件名称")
    private String partName;

    @Schema(description = "单位")
    private Byte partUnitId;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
