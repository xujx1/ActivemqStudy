package com.xujinxin.activemq.domain.user;

import com.xujinxin.activemq.domain.CommonDomain;

/**
 * Created by xujinxin on 2017/7/7.
 * 用户信息
 */
public class User extends CommonDomain {

    private static final long serialVersionUID = 3546591436121318155L;

    //用户id
    private Integer id;
    //用户名
    private String name;
    //用户地址
    private String address;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
