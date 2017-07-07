package com.xujinxin.activemq.domain.order;

import com.xujinxin.activemq.domain.CommonDomain;
import com.xujinxin.activemq.domain.product.Product;
import com.xujinxin.activemq.domain.user.User;

/**
 * Created by xujinxin on 2017/7/7.
 * 订单对象
 */
public class Order extends CommonDomain {

    private static final long serialVersionUID = 1646186799326377417L;

    //订单号
    private Integer id;
    //订单用户信息
    private User user;
    //订单商品信息
    private Product product;
    //订单状态
    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
