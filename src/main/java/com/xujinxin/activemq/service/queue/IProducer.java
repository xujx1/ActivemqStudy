package com.xujinxin.activemq.service.queue;

import com.xujinxin.activemq.domain.order.Order;

/**
 * Created by xujinxin on 2017/7/7.
 * 队列生产者
 */
public interface IProducer {
     void sendMessage(Order order);
}
