package com.xujinxin.test;

import com.xujinxin.activemq.constant.order.OrderStatus;
import org.junit.Test;

/**
 * Created by xujinxin on 2017/7/7.
 */
public class EnumTest {

    @Test
    public void test(){
        System.out.println(OrderStatus.getMessage(6));
    }
}
