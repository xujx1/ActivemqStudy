package com.xujinxin.test;

import com.xujinxin.activemq.domain.order.Order;
import com.xujinxin.activemq.domain.product.Product;
import com.xujinxin.activemq.domain.user.User;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * Created by xujinxin on 2017/7/7.
 * 测试ToString()
 */
public class ToStringTest {

    @Test
    public void test() {
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

        System.out.println(order);
    }
}
