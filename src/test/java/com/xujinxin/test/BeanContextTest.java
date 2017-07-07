package com.xujinxin.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xujinxin.activemq.beans.BeanContext;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by xujinxin on 2017/7/7.
 * 测试BeanContext
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/spring-context.xml")
public class BeanContextTest {
    @Test
    public void test() {
        Assert.assertNotNull(BeanContext.getContext().getBean(ObjectMapper.class));
    }
}
