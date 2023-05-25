package cn.iocoder.yudao.module.insurance.dal.dataobject.reparation;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 电梯报修申请 DO
 *
 * @author 德尔开发
 */
@TableName("insurance_reparation")
@KeySequence("insurance_reparation_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReparationDO extends BaseDO {

    /**
     * 维修表单主键
     */
    @TableId
    private Long id;
    /**
     * 申请人的用户编号
     */
    private Long userId;
    /**
     * 提交人所在单位
     */
    private Long userDeptId;
    /**
     * 报险人姓名
     */
    private String userNickname;
    /**
     * 报险人手机号码
     */
    private String userMobile;
    /**
     * 使用单位编号
     */
    private Long endusageDeptId;
    /**
     * 使用单位
     */
    private String endusageDeptName;
    /**
     * 使用单位负责人
     */
    private Long endusageDeptManagerId;
    /**
     * 电梯id
     */
    private Long elevtrId;
    /**
     * 梯号
     */
    private String elevtrNumber;
    /**
     * 维保单位编号
     */
    private Long maintainDeptId;
    /**
     * 维保单位
     */
    private String maintainDeptName;
    /**
     * 注册代码
     */
    private String registrationId;
    /**
     * 流程实例的编号
     */
    private String processInstanceId;
    /**
     * 配件总价格
     */
    private Long totalPrice;

}
