package com.xujinxin.test;

import com.xujinxin.activemq.domain.order.Order;
import com.xujinxin.activemq.domain.product.Product;
import com.xujinxin.activemq.domain.user.User;
import com.xujinxin.activemq.service.queue.IProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;

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
    public void test() throws InterruptedException {

        Product product =new Product();
        product.setId(1);
        product.setName("测试");
        product.setAmount(new BigDecimal(10));
        product.setInventory(100L);


        User user =new User();
        user.setId(1);
        user.setName("测试");
        user.setAddress("测试地址");

        Order order =new Order();
        order.setId(1);
        order.setUser(user);
        order.setProduct(product);
        producer.sendMessage(order);
    }
}
