package com.xujinxin.activemq.service.queue.impl;

import com.xujinxin.activemq.annotation.IgnoreLog;
import com.xujinxin.activemq.domain.order.Order;
import com.xujinxin.activemq.service.queue.IConsumer;
import com.xujinxin.activemq.utils.JsonUtil;
import org.aspectj.weaver.ast.Or;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;

import javax.annotation.Resource;
import javax.jms.*;

/**
 * Created by xujinxin on 2017/7/7.
 * 队列消费者
 */
public class ConsumerImpl implements IConsumer, MessageListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerImpl.class);

    @Resource
    private JmsTemplate jmsTemplate;

    @Override
    @IgnoreLog
    public void onMessage(Message message) {
        LOGGER.info("消费者接受消息为[{}]", message);
        Order order = (Order) jmsTemplate.receiveAndConvert();
        LOGGER.info("消费者接受消息为[{}]", order);
    }
}
