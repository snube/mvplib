package com.snubee.mvp.samples.demo2;

import com.snubee.mvp.databind.DataBinder;

/**
 *  生殖器
 *  @author snubee
 *  @email snubee96@gmail.com
 *  @time 2018/3/9 15:31
 *
**/
public class Demo2DataBinder implements DataBinder<SimpleDelegate, JavaBean> {

    @Override
    public void viewBindModel(SimpleDelegate viewDelegate, JavaBean data) {
        viewDelegate.textView.setText("djafkhajk fdhadjk hfdjakss" + data.getName());
    }

}
