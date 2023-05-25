package cn.iocoder.yudao.module.insurance.controller.admin.faultinfo.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import javax.validation.constraints.*;

/**
 * 故障信息子表 Base VO，提供给添加、修改、详细的子 VO 使用
 * 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
 */
@Data
public class FaultinfoBaseVO {

    @Schema(description = "报修单号", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "报修单号不能为空")
    private Long reparationId;

    @Schema(description = "小区照片")
    private String communityPic;

    @Schema(description = "单元照片")
    private String unitPic;

    @Schema(description = "电梯照片")
    private String elevtrPic;

    @Schema(description = "故障现场照片")
    private String faultPic;

    @Schema(description = "故障现场照片2")
    private String faultPic2;

    @Schema(description = "故障现场照片3")
    private String faultPic3;

    @Schema(description = "故障现场照片4")
    private String faultPic4;

}
