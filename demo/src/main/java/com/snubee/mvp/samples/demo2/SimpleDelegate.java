package com.snubee.mvp.samples.demo2;

import android.widget.TextView;

import com.snubee.mvp.samples.R;
import com.snubee.mvp.view.DelegateIpm;

/**
 * View视图层
 * @author snubee
 */
public class SimpleDelegate extends DelegateIpm {

    public TextView textView;
    public TextView test;

    @Override
    public int getRootLayoutId() {
        return R.layout.delegate_simple;
    }

    @Override
    public void initWidget() {
        super.initWidget();
        textView = get(R.id.text);
        test = get(R.id.test);
        textView.setText("在视图代理层创建布局");
    }

    public void setText(String text) {
        TextView textView = get(R.id.text);
        textView.setText(text);
    }
}