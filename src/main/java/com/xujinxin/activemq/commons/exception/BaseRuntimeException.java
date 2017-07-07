package com.xujinxin.activemq.commons.exception;

import com.xujinxin.activemq.domain.exception.ExceptionInfo;

/**
 * Created by xujinxin on 2017/7/7.
 * 基本运行时异常类
 */
public class BaseRuntimeException extends RuntimeException {

    private static final long serialVersionUID = 3021510016607024849L;


    private Throwable throwable;

    private ExceptionInfo exceptionInfo = new ExceptionInfo();

    public BaseRuntimeException() {

    }

    public BaseRuntimeException(Throwable throwable) {
        super(throwable);
        this.throwable = throwable;
    }

    public BaseRuntimeException(Integer errorCode, String errorMsg) {
        super();
        exceptionInfo.setErrorCode(errorCode);
        exceptionInfo.setErrorMsg(errorMsg);
    }

    public BaseRuntimeException(Integer errorCode, String errorMsg, Throwable throwable) {
        super(throwable);
        this.throwable = throwable;
        exceptionInfo.setErrorCode(errorCode);
        exceptionInfo.setErrorMsg(errorMsg);
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }

    public ExceptionInfo getExceptionInfo() {
        return exceptionInfo;
    }

    public void setExceptionInfo(ExceptionInfo exceptionInfo) {
        this.exceptionInfo = exceptionInfo;
    }
}
