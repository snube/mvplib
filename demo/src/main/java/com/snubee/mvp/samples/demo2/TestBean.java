package com.snubee.mvp.samples.demo2;

import com.snubee.mvp.model.IModel;

/**
 *
 *  @author snubee
 *  @email snubee96@gmail.com
 *  @time 2018/3/9 15:31
 *
**/
public class TestBean implements IModel {
    private String name;

    public TestBean(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
