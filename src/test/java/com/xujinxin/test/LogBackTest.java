package com.xujinxin.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by xujinxin on 2017/7/7.
 * 测试logback日志
 */
public class LogBackTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogBackTest.class);

    @Test
    public void logback(){
        LOGGER.info("测试[{}]","logback");
    }
}
