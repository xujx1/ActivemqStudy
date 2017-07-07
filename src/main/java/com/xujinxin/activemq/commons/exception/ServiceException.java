package com.xujinxin.activemq.commons.exception;

/**
 * Created by xujinxin on 2017/7/7.
 * 服务异常类
 */
public class ServiceException extends BaseRuntimeException{

    private static final long serialVersionUID = 8836950183434051756L;

    public ServiceException() {
        super();
    }

    public ServiceException(Throwable throwable) {
        super(throwable);
    }

    public ServiceException(Integer errorCode, String errorMsg) {
        super(errorCode, errorMsg);
    }

    public ServiceException(Integer errorCode, String errorMsg, Throwable throwable) {
        super(errorCode, errorMsg, throwable);
    }
}
