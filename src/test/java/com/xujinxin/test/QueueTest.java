package com.xujinxin.test;

import com.xujinxin.activemq.service.queue.IProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by xujinxin on 2017/7/7.
 * 队列测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/spring-context.xml")
public class QueueTest {

    @Resource
    private IProducer producer;

    @Test
    public void test() {
        producer.sendMessage("test");
    }
}
