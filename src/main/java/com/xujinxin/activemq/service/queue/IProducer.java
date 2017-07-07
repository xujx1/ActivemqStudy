package com.xujinxin.activemq.service.queue;

/**
 * Created by xujinxin on 2017/7/7.
 * 队列生产者
 */
public interface IProducer {
     void sendMessage(String message);
}
