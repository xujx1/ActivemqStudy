package com.xujinxin.activemq.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by xujinxin on 2017/7/8.
 * 当线程池待处理事件达到最大容量时，且线程数达到了最大线程数，启动回绝方法
 */
public class TaskRejectedExecutionHandler implements RejectedExecutionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(TaskRejectedExecutionHandler.class);

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        LOGGER.info("[Thread Poll Execute Reject Task]");
        executor.execute(r);
    }
}
