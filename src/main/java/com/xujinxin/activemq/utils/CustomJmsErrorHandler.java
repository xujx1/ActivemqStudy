package com.xujinxin.activemq.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ErrorHandler;

/**
 * Created by xujinxin on 2017/7/8.
 * 自定义jms异常处理类
 */
public class CustomJmsErrorHandler implements ErrorHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomJmsErrorHandler.class);

    @Override
    public void handleError(Throwable t) {
        LOGGER.error("[JMS Message Handle Error]", t);
    }
}
