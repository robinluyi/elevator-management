package cn.iocoder.yudao.module.insurance.enums;

import cn.iocoder.yudao.framework.common.exception.ErrorCode;

/**
 * 保险 错误码枚举类
 *
 * 保险系统，使用 1-010-000-000 段
 */
public interface ErrorCodeConstants {

    // ==========  通用模块 1-010-000-000 ==========
    ErrorCode ORDER_NOT_EXISTS = new ErrorCode(1010000001, "保单不存在");

}
