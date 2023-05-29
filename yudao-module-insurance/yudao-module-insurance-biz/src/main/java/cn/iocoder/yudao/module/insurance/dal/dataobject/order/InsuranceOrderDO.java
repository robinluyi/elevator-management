package cn.iocoder.yudao.module.insurance.dal.dataobject.order;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 保单 DO
 *
 * @author 德尔开发
 */
@TableName("insurance_order")
@KeySequence("insurance_order_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InsuranceOrderDO extends BaseDO {

    /**
     * 编号
     */
    @TableId
    private Long id;
    /**
     * 保单号
     */
    private String orderId;
    /**
     * 险种代码(ZHI,ZKM)
     */
    private String insrType;
    /**
     * 项目名称
     */
    private String projectName;
    /**
     * 省
     */
    private String provincial;
    /**
     * 市
     */
    private String city;
    /**
     * 区
     */
    private String district;
    /**
     * 街道
     */
    private String street;
    /**
     * 被保险人
     */
    private String insuredUsername;
    /**
     * 起保时间
     */
    private LocalDateTime insrStartTime;
    /**
     * 终保时间
     */
    private LocalDateTime insrEndTime;
    /**
     * 电梯总数
     */
    private Integer total;
    /**
     * 直梯总数
     */
    private Integer totalStraight;
    /**
     * 扶梯总数
     */
    private Integer totalEscalator;
    /**
     * 机构名称
     */
    private String organizationName;
    /**
     * 备注
     */
    private String comments;
    /**
     * 是否装配配件
     */
    private Byte hasPart;
    /**
     * 申请的结果
     *
     * 枚举 {@link BpmProcessInstanceResultEnum}
     * 考虑到简单，所以直接复用了 BpmProcessInstanceResultEnum 枚举，也可以自己定义一个枚举哈
     */
    private Integer result;

}
