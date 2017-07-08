package com.xujinxin.activemq.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ErrorHandler;

/**
 * Created by xujinxin on 2017/7/8.
 * 自定义线程池异常捕获类
 */
public class ThreadPollErrorHandler implements ErrorHandler{
    private static final Logger LOGGER = LoggerFactory.getLogger(ThreadPollErrorHandler.class);

    @Override
    public void handleError(Throwable t) {
        LOGGER.error("[ThreadPoll Error]", t);
    }
}
