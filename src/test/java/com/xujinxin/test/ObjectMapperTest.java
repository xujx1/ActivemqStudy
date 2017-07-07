package com.xujinxin.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by xujinxin on 2017/7/7.
 * 测试 ObjectMapper
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/spring-context.xml")
public class ObjectMapperTest {

    @Resource
    private ObjectMapper objectMapper;


    @Test
    public void test() {
        Assert.assertNotNull(objectMapper);
    }
}
