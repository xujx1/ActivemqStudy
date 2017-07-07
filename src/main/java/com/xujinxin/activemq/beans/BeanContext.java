package com.xujinxin.activemq.beans;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Created by xujinxin on 2017/7/7.
 * 辅助访问Spring
 */
@Component
public class BeanContext implements ApplicationContextAware {

    private static ApplicationContext context = null;

    @Override
    public void setApplicationContext(ApplicationContext appContext) throws BeansException {
        context = appContext;
    }

    public static ApplicationContext getContext() {
        return context;
    }
}
