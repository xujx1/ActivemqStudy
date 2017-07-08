package com.xujinxin.activemq.utils;

import com.xujinxin.activemq.domain.order.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 * Created by xujinxin on 2017/7/8.
 * 订单消息格式转换器
 */
public class OrderMessageConverter implements MessageConverter {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderMessageConverter.class);

    @Override
    public Message toMessage(Object object, Session session) throws JMSException, MessageConversionException {
        String message = JsonUtil.toString(object);
        LOGGER.info("生产者推送消息为[{}]", message);
        return session.createTextMessage(message);
    }

    @Override
    public Object fromMessage(Message message) throws JMSException, MessageConversionException {
        Order order = new Order();
        LOGGER.info("消费者接受消息为[{}]", message);
        if (message != null && message instanceof TextMessage) {
            TextMessage textMessage = (TextMessage) message;
            String value = textMessage.getText();
            order = JsonUtil.toBean(value, Order.class);
        }
        return order;
    }
}
