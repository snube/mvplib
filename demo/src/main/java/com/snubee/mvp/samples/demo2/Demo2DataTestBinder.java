package com.snubee.mvp.samples.demo2;

import android.util.Log;

import com.snubee.mvp.databind.DataBinder;

/**
 *  设值器，将数据与视图显示绑定，会在数据改变时调用
 *  @author snubee
 *  @email snubee96@gmail.com
 *  @time 2018/3/9 15:30
 *
**/
public class Demo2DataTestBinder implements DataBinder<SimpleDelegate, TestBean> {

    @Override
    public void viewBindModel(SimpleDelegate viewDelegate, TestBean data) {
        Log.i("snubee ---","8");
        viewDelegate.test.setText(data.getName());
    }
}
