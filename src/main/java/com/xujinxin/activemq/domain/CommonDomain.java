package com.xujinxin.activemq.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * Created by xujinxin on 2017/7/7.
 * 公共业务对象
 */
public class CommonDomain implements Serializable{

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 574843856826340496L;

    /**
     * ToString
     */

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
