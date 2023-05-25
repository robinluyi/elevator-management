package cn.iocoder.yudao.module.insurance.controller.admin.faultinfo.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 故障信息子表 Excel VO
 *
 * @author 德尔开发
 */
@Data
public class FaultinfoExcelVO {

    @ExcelProperty("故障信息主键")
    private Long id;

    @ExcelProperty("报修单号")
    private Long reparationId;

    @ExcelProperty("小区照片")
    private String communityPic;

    @ExcelProperty("单元照片")
    private String unitPic;

    @ExcelProperty("电梯照片")
    private String elevtrPic;

    @ExcelProperty("故障现场照片")
    private String faultPic;

    @ExcelProperty("故障现场照片2")
    private String faultPic2;

    @ExcelProperty("故障现场照片3")
    private String faultPic3;

    @ExcelProperty("故障现场照片4")
    private String faultPic4;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
