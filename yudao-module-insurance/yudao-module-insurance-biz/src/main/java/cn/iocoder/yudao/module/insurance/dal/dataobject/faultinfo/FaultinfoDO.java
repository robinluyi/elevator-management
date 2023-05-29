package cn.iocoder.yudao.module.insurance.dal.dataobject.faultinfo;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 故障信息子表 DO
 *
 * @author 德尔开发
 */
@TableName("insurance_faultinfo")
@KeySequence("insurance_faultinfo_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FaultinfoDO extends BaseDO {

    /**
     * 故障信息主键
     */
    @TableId
    private Long id;
    /**
     * 报修单号
     */
    private Long reparationId;
    /**
     * 小区照片
     */
    private String communityPic;
    /**
     * 单元照片
     */
    private String unitPic;
    /**
     * 电梯照片
     */
    private String elevtrPic;
    /**
     * 故障现场照片
     */
    private String faultPic;
    /**
     * 故障现场照片2
     */
    private String faultPic2;
    /**
     * 故障现场照片3
     */
    private String faultPic3;
    /**
     * 故障现场照片4
     */
    private String faultPic4;
    /**
     * 流程实例的编号
     */
    private String processInstanceId;
    /**
     * 申请的结果
     *
     * 枚举 {@link BpmProcessInstanceResultEnum}
     * 考虑到简单，所以直接复用了 BpmProcessInstanceResultEnum 枚举，也可以自己定义一个枚举哈
     */
    private Integer result;

}
