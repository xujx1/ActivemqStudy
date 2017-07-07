package com.xujinxin.activemq.service.queue.impl;

import com.xujinxin.activemq.annotation.IgnoreLog;
import com.xujinxin.activemq.service.queue.IConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.MessageCreator;

import javax.jms.*;

/**
 * Created by xujinxin on 2017/7/7.
 * 队列消费者
 */
public class ConsumerImpl implements IConsumer, MessageListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerImpl.class);

    @Override
    @IgnoreLog
    public void onMessage(Message message) {
        LOGGER.info("消费者接受消息为[{}]", message);
        if (message instanceof TextMessage) {
            TextMessage textMessage = (TextMessage) message;
            try {
                String value = textMessage.getText();
                LOGGER.info("消费者接受消息为[{}]", value);
            } catch (JMSException e) {
                LOGGER.error("消费者解析消息异常,{}", e);
            }

        }
    }
}
