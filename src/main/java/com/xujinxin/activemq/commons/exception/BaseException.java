package com.xujinxin.activemq.commons.exception;

import com.xujinxin.activemq.domain.exception.ExceptionInfo;

/**
 * Created by xujinxin on 2017/7/7.
 * 基本异常类
 */
public class BaseException extends Exception {

    private static final long serialVersionUID = 3021510016607024849L;

    private Throwable throwable;

    private ExceptionInfo info = new ExceptionInfo();

    public BaseException() {

    }

    public BaseException(Throwable throwable) {
        super(throwable);
        this.throwable = throwable;
    }

    public BaseException(Integer errorCode, String errorMsg) {
        super();
        info.setErrorCode(errorCode);
        info.setErrorMsg(errorMsg);
    }

    public BaseException(Integer errorCode,String errorMsg,Throwable throwable){
        super(throwable);
        this.throwable = throwable;
        info.setErrorCode(errorCode);
        info.setErrorMsg(errorMsg);
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }

    public ExceptionInfo getInfo() {
        return info;
    }

    public void setInfo(ExceptionInfo info) {
        this.info = info;
    }
}
