package cn.iocoder.yudao.module.insurance.controller.admin.reparation.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import javax.validation.constraints.*;

/**
 * 电梯报修申请 Base VO，提供给添加、修改、详细的子 VO 使用
 * 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
 */
@Data
public class ReparationBaseVO {

    @Schema(description = "申请人的用户编号", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "申请人的用户编号不能为空")
    private Long userId;

    @Schema(description = "提交人所在单位", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "提交人所在单位不能为空")
    private Long userDeptId;

    @Schema(description = "报险人姓名", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "报险人姓名不能为空")
    private String userNickname;

    @Schema(description = "报险人手机号码")
    private String userMobile;

    @Schema(description = "使用单位编号", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "使用单位编号不能为空")
    private Long endusageDeptId;

    @Schema(description = "使用单位")
    private Long endusageDeptName;

    @Schema(description = "使用单位负责人")
    private Long endusageDeptManagerId;

    @Schema(description = "电梯id", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "电梯id不能为空")
    private Long elevtrId;

    @Schema(description = "梯号")
    private String elevtrNumber;

    @Schema(description = "维保单位编号", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "维保单位编号不能为空")
    private Long maintainDeptId;

    @Schema(description = "维保单位")
    private Long maintainDeptName;

    @Schema(description = "注册代码")
    private String registrationId;

    @Schema(description = "配件总价格")
    private Long totalPrice;

    @Schema(description = "配件名称", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "配件名称不能为空")
    private String partName;

    @Schema(description = "单位", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "单位不能为空")
    private Byte partUnitId;

    @Schema(description = "单价", requiredMode = Schema.RequiredMode.REQUIRED, example = "个")
    @NotNull(message = "单价不能为空")
    private Integer partUnitPirce;

    @Schema(description = "数量", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "数量不能为空")
    private Integer partQuantity;

    @Schema(description = "小计", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "小计不能为空")
    private Byte partTotal;

    @Schema(description = "小区照片")
    private String communityPic;

    @Schema(description = "单元照片")
    private String unitPic;

    @Schema(description = "电梯照片")
    private String elevtrPic;

    @Schema(description = "故障现场照片")
    private String faultPic;

    @Schema(description = "故障现场照片")
    private String faultPic2;

    @Schema(description = "流程实例的编号", example = "25388")
    private String processInstanceId;

}
