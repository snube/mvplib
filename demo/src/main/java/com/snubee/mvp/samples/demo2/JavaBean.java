package com.snubee.mvp.samples.demo2;

import com.snubee.mvp.model.IModel;

/**
 *   
 *  @author snubee
 *  @email snubee96@gmail.com
 *  @time 2018/3/9 15:39
 *
**/
public class JavaBean implements IModel {
    private String name;

    public JavaBean(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
