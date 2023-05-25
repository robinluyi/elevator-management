package cn.iocoder.yudao.module.insurance.controller.admin.reparation.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;

import com.alibaba.excel.annotation.ExcelProperty;
import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;


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

    @ExcelProperty("配件总价格")
    private Long totalPrice;

    @ExcelProperty("配件名称")
    private String partName;

    @ExcelProperty(value = "单位", converter = DictConvert.class)
    @DictFormat("elevtr_part_unit") // TODO 代码优化：建议设置到对应的 XXXDictTypeConstants 枚举类中
    private Byte partUnitId;

    @ExcelProperty("单价")
    private Integer partUnitPirce;

    @ExcelProperty("数量")
    private Integer partQuantity;

    @ExcelProperty("小计")
    private Byte partTotal;

    @ExcelProperty("小区照片")
    private String communityPic;

    @ExcelProperty("单元照片")
    private String unitPic;

    @ExcelProperty("电梯照片")
    private String elevtrPic;

    @ExcelProperty("故障现场照片")
    private String faultPic;

    @ExcelProperty("故障现场照片")
    private String faultPic2;

    @ExcelProperty("流程实例的编号")
    private String processInstanceId;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
