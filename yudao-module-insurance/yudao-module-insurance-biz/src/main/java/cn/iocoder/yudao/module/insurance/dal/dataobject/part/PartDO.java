package cn.iocoder.yudao.module.insurance.dal.dataobject.part;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 报修零件子表 DO
 *
 * @author 德尔开发
 */
@TableName("insurance_part")
@KeySequence("insurance_part_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PartDO extends BaseDO {

    /**
     * 报修零件主键
     */
    @TableId
    private Long id;
    /**
     * 报修单号
     */
    private Long reparationId;
    /**
     * 配件名称
     */
    private String partName;
    /**
     * 单位
     */
    private Byte partUnitId;
    /**
     * 单价
     */
    private Long partUnitPirce;
    /**
     * 数量
     */
    private Long partQuantity;
    /**
     * 小计
     */
    private Long partTotal;
    /**
     * 流程实例的编号
     */
    private String processInstanceId;

}
