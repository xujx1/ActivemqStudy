package com.xujinxin.activemq.constant.errorcode;

import com.xujinxin.activemq.constant.CommonEnum;

/**
 * Created by xujinxin on 2017/7/7.
 * 常用业务异常
 */
public enum CommonExceptionCode implements CommonEnum {

    UNKNOWN_EXCEPTION(1022999999, "未知错误"),

    DATABASE_EXCEPTION(1021999998, "数据库错误"),

    PARAM_INVALID_EXCEPTION(1022999997, "参数无效"),

    RESULT_NOT_FIND(1022999996, "未发现数据"),

    CANNOT_UPDATE(1022999995, "不可更新"),

    PARAM_MUST_IS_NULL(1022999994, "必填项为空"),

    PARAM_IS_NOT_RULE(1022999993, "参数不符合规则"),

    CANNOT_REMOVE(1022999992, "不可删除"),

    CANNOT_INSERT(1022999991, "不可新增"),;


    private Integer code;

    private String message;

    CommonExceptionCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
