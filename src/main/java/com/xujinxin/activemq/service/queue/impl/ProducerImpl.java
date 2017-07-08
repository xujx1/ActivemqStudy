package com.xujinxin.activemq.service.queue.impl;

import com.xujinxin.activemq.domain.order.Order;
import com.xujinxin.activemq.service.queue.IProducer;
import com.xujinxin.activemq.utils.JsonUtil;
import org.apache.activemq.command.ActiveMQQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * Created by xujinxin on 2017/7/7.
 * 队列生产者
 */

@Service
public class ProducerImpl implements IProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProducerImpl.class);

    @Resource
    private JmsTemplate jmsTemplate;


    @Override
    public void sendMessage(Order order) {
        LOGGER.info("生产者推送消息为[{}]", order);
        jmsTemplate.convertAndSend(order);
    }
}
