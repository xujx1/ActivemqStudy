package com.xujinxin.activemq.beans;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by xujinxin on 2017/7/7.
 * 初始化ObjectMapper
 */

@Component
public class ObjectMapperFactoryBean implements FactoryBean<ObjectMapper> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ObjectMapperFactoryBean.class);

    private volatile static ObjectMapper OBJECT_MAPPER;
    private static final Lock LOCK = new ReentrantLock();

    @Override
    public ObjectMapper getObject() throws Exception {
        if (null == OBJECT_MAPPER) {
            if (LOCK.tryLock()) {
                try {
                    LOCK.lock();
                    init();
                } catch (Exception e) {
                    LOGGER.error("初始化ObjectMapper异常[{}]", e);
                } finally {
                    LOCK.unlock();
                }
            }
        }
        return OBJECT_MAPPER;
    }

    @Override
    public Class<?> getObjectType() {
        return ObjectMapper.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    private void init() {
        if (null == OBJECT_MAPPER) {
            OBJECT_MAPPER = new ObjectMapper();
            OBJECT_MAPPER.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
            OBJECT_MAPPER.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
            OBJECT_MAPPER.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
            OBJECT_MAPPER.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
            OBJECT_MAPPER.configure(SerializationFeature.WRITE_ENUMS_USING_INDEX, true);
            OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            OBJECT_MAPPER.configure(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE, false);
            OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, false);
            OBJECT_MAPPER.configure(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL, true);
            OBJECT_MAPPER.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
            // null to ""
            OBJECT_MAPPER.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>() {
                @Override
                public void serialize(Object paramT, JsonGenerator paramJsonGenerator,
                                      SerializerProvider paramSerializerProvider) throws IOException {
                    paramJsonGenerator.writeString("");
                }
            });
        }
    }

}
