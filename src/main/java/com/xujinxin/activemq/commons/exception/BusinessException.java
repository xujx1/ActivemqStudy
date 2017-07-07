package com.xujinxin.activemq.commons.exception;

/**
 * Created by xujinxin on 2017/7/7.
 * 业务异常类
 */
public class BusinessException extends BaseRuntimeException {

    private static final long serialVersionUID = -6863063675145470994L;

    public BusinessException() {
        super();
    }

    public BusinessException(Throwable throwable) {
        super(throwable);
    }

    public BusinessException(Integer errorCode, String errorMsg) {
        super(errorCode, errorMsg);
    }

    public BusinessException(Integer errorCode, String errorMsg, Throwable throwable) {
        super(errorCode, errorMsg, throwable);
    }
}
