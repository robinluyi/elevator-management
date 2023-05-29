package cn.iocoder.yudao.module.insurance.controller.admin.reparation.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 电梯报修申请 Excel VO
 *
 * @author 德尔开发
 */
@Data
public class ReparationExcelVO {

    @ExcelProperty("维修表单主键")
    private Long id;

    @ExcelProperty("申请人的用户编号")
    private Long userId;

    @ExcelProperty("提交人所在单位")
    private Long userDeptId;

    @ExcelProperty("报险人姓名")
    private String userNickname;

    @ExcelProperty("报险人手机号码")
    private String userMobile;

    @ExcelProperty("使用单位编号")
    private Long endusageDeptId;

    @ExcelProperty("使用单位")
    private String endusageDeptName;

    @ExcelProperty("使用单位负责人")
    private Long endusageDeptManagerId;

    @ExcelProperty("电梯id")
    private Long elevtrId;

    @ExcelProperty("梯号")
    private String elevtrNumber;

    @ExcelProperty("维保单位编号")
    private Long maintainDeptId;

    @ExcelProperty("维保单位")
    private String maintainDeptName;

    @ExcelProperty("注册代码")
    private String registrationId;

    @ExcelProperty("流程实例的编号")
    private String processInstanceId;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

    @ExcelProperty("配件总价格")
    private Long totalPrice;
    @Schema(description = "状态-参见 bpm_process_instance_result 枚举", example = "1")
    private Integer result;
}
