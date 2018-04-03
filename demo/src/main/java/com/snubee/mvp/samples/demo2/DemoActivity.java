package com.snubee.mvp.samples.demo2;

import android.view.View;

import com.snubee.mvp.databind.DataBindActivity;
import com.snubee.mvp.databind.DataBinder;
import com.snubee.mvp.samples.R;

/**
 * @author snubee
 * @email snubee96@gmail.com
 * @time 2018/3/9 15:05
 **/
public class DemoActivity extends DataBindActivity<TestPresenter, SimpleDelegate> implements View
        .OnClickListener {

    TestBean test = new TestBean("名字");


    TestPresenter mTestPresenter;

    @Override
    protected void bindEvenListener() {
        super.bindEvenListener();
        mTestPresenter = mPresenter;

        mTestPresenter.getViewDelegate().setOnClickListener(this, R.id.button1);
        mTestPresenter.getData();
    }

    @Override
    public DataBinder getDataBinder() {
        return new Demo2DataBinder();
    }

//    @Override
//    public TestPresenter getPresenter() {
//        return mTestPresenter = new TestPresenter();
//    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                mTestPresenter.getViewDelegate().setText("你点击了button");
                test.setName("多个model的类型改变");
                mTestPresenter.notifyModelChanged(test);
                break;
        }
    }
}
