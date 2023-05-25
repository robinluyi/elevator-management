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

    // ========== 电梯报修申请 1-010-001-000 ==========
    ErrorCode REPARATION_NOT_EXISTS = new ErrorCode( 1010001001, "电梯报修申请不存在");

    // ========== 报修零件子表 1-010-002-000 ==========
    ErrorCode PART_NOT_EXISTS = new ErrorCode(1010002001, "报修零件子表不存在");

    // ========== 故障信息子表 1-010-003-000  ==========
    ErrorCode FAULTINFO_NOT_EXISTS = new ErrorCode(1010003001, "故障信息子表不存在");

}
