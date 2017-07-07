package com.xujinxin.activemq.constant.order;

import com.xujinxin.activemq.constant.CommonEnum;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Optional;

/**
 * Created by xujinxin on 2017/7/7.
 * 订单状态
 */
public enum OrderStatus implements CommonEnum {


    UNPAID(0, "未付款"),
    PAID(1, "已付款"),
    DELIVERY(2, "已发货"),
    RECEIVED(3, "已退货"),
    RETURNED(4, "已收货");


    OrderStatus(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }


    public static String getMessage(Integer code) {
        String message = "";
        Optional<OrderStatus> optional =
                Arrays.stream(OrderStatus.values()).filter(stateEnum -> stateEnum.getCode().equals(code)).findFirst();
        if (optional.isPresent()) {
            message = optional.get().getMessage();
        }
        if (StringUtils.isEmpty(message)) {
            LOGGER.warn("根据code[{}]查询未查询出合适的message", code);
        }
        return message;
    }


    private static final Logger LOGGER = LoggerFactory.getLogger(OrderStatus.class);
    private Integer code;
    private String message;


}
