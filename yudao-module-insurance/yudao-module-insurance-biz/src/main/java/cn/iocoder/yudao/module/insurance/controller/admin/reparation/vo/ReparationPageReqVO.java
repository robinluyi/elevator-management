package cn.iocoder.yudao.module.insurance.controller.admin.reparation.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 电梯报修申请分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ReparationPageReqVO extends PageParam {

    @Schema(description = "申请人的用户编号")
    private Long userId;

    @Schema(description = "提交人所在单位")
    private Long userDeptId;

    @Schema(description = "报险人姓名")
    private String userNickname;

    @Schema(description = "报险人手机号码")
    private String userMobile;

    @Schema(description = "使用单位编号")
    private Long endusageDeptId;

    @Schema(description = "使用单位")
    private Long endusageDeptName;

    @Schema(description = "使用单位负责人")
    private Long endusageDeptManagerId;

    @Schema(description = "电梯id")
    private Long elevtrId;

    @Schema(description = "梯号")
    private String elevtrNumber;

    @Schema(description = "维保单位编号")
    private Long maintainDeptId;

    @Schema(description = "维保单位")
    private Long maintainDeptName;

    @Schema(description = "注册代码")
    private String registrationId;

    @Schema(description = "配件总价格")
    private Long totalPrice;

    @Schema(description = "配件名称")
    private String partName;

    @Schema(description = "单位")
    private Byte partUnitId;

    @Schema(description = "单价", example = "个")
    private Integer partUnitPirce;

    @Schema(description = "数量")
    private Integer partQuantity;

    @Schema(description = "小计")
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

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
