package com.xujinxin.activemq.commons.exception.handler;

import com.xujinxin.activemq.commons.exception.BaseRuntimeException;
import com.xujinxin.activemq.commons.exception.BusinessException;
import com.xujinxin.activemq.commons.exception.ServiceException;
import com.xujinxin.activemq.constant.errorcode.CommonExceptionCode;
import org.springframework.dao.DataAccessException;

/**
 * Created by xujinxin on 2017/7/7.
 * 异常统一封装类 系统封装了ProxyException，ServiceException，BusinessException
 */
public class ExceptionHandlerUtil {

    /**
     * 将所有异常转换为BusinessException，然后抛出
     * @param cause 原始异常
     */
    public static void wrapAndThrowBusinessException(Throwable cause) {
        BusinessException businessException;
        if (cause == null) {// 未知异常
            businessException = new BusinessException(CommonExceptionCode.UNKNOWN_EXCEPTION.getCode(),
                    CommonExceptionCode.UNKNOWN_EXCEPTION.getMessage());
        } else if (cause instanceof BusinessException) {// 如果是BusinessException直接抛
            businessException = (BusinessException) cause;
        } else if (cause instanceof BaseRuntimeException) {// 业务异常
            BaseRuntimeException baseRuntimeException = (BaseRuntimeException) cause;
            businessException = new BusinessException(baseRuntimeException.getExceptionInfo().getErrorCode(),
                    baseRuntimeException.getExceptionInfo().getErrorMsg(), baseRuntimeException.getThrowable());
        } else if (cause instanceof DataAccessException) {// 数据库异常码
            businessException = new BusinessException(CommonExceptionCode.DATABASE_EXCEPTION.getCode(),
                    CommonExceptionCode.DATABASE_EXCEPTION.getMessage(), cause);
        } else {
            businessException = new BusinessException(CommonExceptionCode.UNKNOWN_EXCEPTION.getCode(),
                    CommonExceptionCode.UNKNOWN_EXCEPTION.getMessage(), cause);
        }
        throw businessException;
    }

    /**
     * 将所有异常转换为ServiceException，然后抛出
     * @param cause 原始异常
     */
    public static void wrapAndThrowServiceException(Throwable cause) {
        ServiceException serviceException;
        if (cause == null) {// 未知异常
            serviceException = new ServiceException(CommonExceptionCode.UNKNOWN_EXCEPTION.getCode(),
                    CommonExceptionCode.UNKNOWN_EXCEPTION.getMessage());
        } else if (cause instanceof ServiceException) {
            serviceException = (ServiceException) cause;
        } else if (cause instanceof BaseRuntimeException) {// 业务异常
            BaseRuntimeException baseRuntimeException = (BaseRuntimeException) cause;
            serviceException = new ServiceException(baseRuntimeException.getExceptionInfo().getErrorCode(),
                    baseRuntimeException.getExceptionInfo().getErrorMsg(), baseRuntimeException.getThrowable());
        } else if (cause instanceof DataAccessException) {// 数据库异常
            serviceException = new ServiceException(CommonExceptionCode.DATABASE_EXCEPTION.getCode(),
                    CommonExceptionCode.DATABASE_EXCEPTION.getMessage(), cause);
        } else {// 设置未知异常码
            serviceException = new ServiceException(CommonExceptionCode.UNKNOWN_EXCEPTION.getCode(),
                    CommonExceptionCode.UNKNOWN_EXCEPTION.getMessage(), cause);
        }
        throw serviceException;
    }
}
