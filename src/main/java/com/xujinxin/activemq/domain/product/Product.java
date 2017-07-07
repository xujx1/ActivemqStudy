package com.xujinxin.activemq.domain.product;


import com.xujinxin.activemq.domain.CommonDomain;

import java.math.BigDecimal;

/**
 * Created by xujinxin on 2017/7/7.
 * 商品
 */
public class Product extends CommonDomain {

    private static final long serialVersionUID = -1797043123721515409L;

    //商品Id
    private Integer id;
    //商品名称
    private String name;
    //商品金额
    private BigDecimal amount;
    //商品库存
    private Long inventory;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Long getInventory() {
        return inventory;
    }

    public void setInventory(Long inventory) {
        this.inventory = inventory;
    }

}
