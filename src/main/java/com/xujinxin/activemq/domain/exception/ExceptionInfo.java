package com.xujinxin.activemq.domain.exception;

import java.io.Serializable;

/**
 * Created by xujinxin on 2017/7/7.
 * 保存异常码，异常描述对象
 */
public class ExceptionInfo implements Serializable{

    private static final long serialVersionUID = -6425784703610412329L;

    //错误码
    private Integer errorCode;
    //错误消息
    private String errorMsg;

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
