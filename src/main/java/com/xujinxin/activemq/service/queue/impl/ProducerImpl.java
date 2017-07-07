package com.xujinxin.activemq.service.queue.impl;

import com.xujinxin.activemq.service.queue.IProducer;
import org.apache.activemq.command.ActiveMQQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by xujinxin on 2017/7/7.
 * 队列生产者
 */

@Service
public class ProducerImpl implements IProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProducerImpl.class);

    @Resource
    private JmsTemplate jmsTemplate;

    @Resource
    private ActiveMQQueue requestDestination;


    @Override
    public void sendMessage(String message) {
        LOGGER.info("生产者推送消息为[{}]", message);
        jmsTemplate.send(requestDestination, session -> session.createTextMessage(message));
    }
}
