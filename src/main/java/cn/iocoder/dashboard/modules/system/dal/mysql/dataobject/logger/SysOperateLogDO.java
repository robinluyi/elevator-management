package cn.iocoder.dashboard.modules.system.dal.mysql.dataobject.logger;

import cn.iocoder.dashboard.common.pojo.CommonResult;
import cn.iocoder.dashboard.framework.mybatis.core.dataobject.BaseDO;
import cn.iocoder.dashboard.modules.system.dal.mysql.dataobject.user.SysUserDO;
import cn.iocoder.dashboard.modules.system.enums.logger.SysOperateLogTypeEnum;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
import java.util.Map;

/**
 * 操作日志表
 *
 * @author 芋道源码
 */
@TableName("sys_operate_log")
@Data
@EqualsAndHashCode(callSuper = true)
public class SysOperateLogDO extends BaseDO {

    /**
     * 日志主键
     */
    @TableId
    private Long id;
    /**
     * 链路追踪编号
     *
     * 一般来说，通过链路追踪编号，可以将访问日志，错误日志，链路追踪日志，logger 打印日志等，结合在一起，从而进行排错。
     */
    private String traceId;
    /**
     * 用户编号
     *
     * {@link SysUserDO#getId()}
     */
    private Long userId;
    /**
     * 操作模块
     */
    private String module;
    /**
     * 操作名
     */
    private String name;
    /**
     * 操作分类
     *
     * 枚举 {@link SysOperateLogTypeEnum}
     */
    private Integer type;
    /**
     * 操作内容，记录整个操作的明细
     * 例如说，修改编号为 1 的用户信息，将性别从男改成女，将姓名从芋道改成源码。
     *
     * TODO 预留字段
     */
    private String content;
    /**
     * 拓展字段，有些复杂的业务，需要记录一些字段
     * 例如说，记录订单编号，则可以添加 key 为 "orderId"，value 为订单编号
     *
     * TODO 预留字段
     */
    @TableField(typeHandler = FastjsonTypeHandler.class)
    private Map<String, Object> exts;

    /**
     * 请求方法名
     */
    private String requestMethod;
    /**
     * 请求地址
     */
    private String requestUrl;
    /**
     * 用户 IP
     */
    private String userIp;
    /**
     * 浏览器 UA
     */
    private String userAgent;

    /**
     * Java 方法名
     */
    private String javaMethod;
    /**
     * Java 方法的参数
     */
    @TableField(typeHandler = FastjsonTypeHandler.class)
    private Map<String, Object> javaMethodArgs;
    /**
     * 开始时间
     */
    private Date startTime;
    /**
     * 执行时长，单位：毫秒
     */
    private Integer duration;
    /**
     * 结果码
     *
     * 目前使用的 {@link CommonResult#getCode()} 属性
     */
    private Integer resultCode;
    /**
     * 结果提示
     *
     * 目前使用的 {@link CommonResult#getMsg()} 属性
     */
    private String resultMsg;
    /**
     * 结果数据
     *
     * 如果是对象，则使用 JSON 格式化
     */
    private String resultData;

}