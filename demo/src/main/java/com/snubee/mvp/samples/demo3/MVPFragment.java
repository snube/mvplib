package com.snubee.mvp.samples.demo3;

import android.view.View;

import com.snubee.mvp.databind.DataBindFragment;
import com.snubee.mvp.databind.DataBinder;
import com.snubee.mvp.presenter.PresenterImp;
import com.snubee.mvp.samples.R;
import com.snubee.mvp.samples.demo2.SimpleDelegate;
import com.snubee.mvp.samples.demo2.TestPresenter;

/**
 * @author snubee
 * @email snubee96@gmail.com
 * @time 2018/3/9 14:56
 **/
public class MVPFragment extends DataBindFragment<TestPresenter,SimpleDelegate> implements View.OnClickListener {


    @Override
    protected void bindEvenListener() {
        super.bindEvenListener();
        mPresenter.getViewDelegate().setOnClickListener(this, R.id.button1);
    }

    @Override
    public DataBinder getDataBinder() {
        return null;
    }

//    @Override
//    public PresenterImp getPresenter() {
//        return new TestPresenter();
//    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                mPresenter.getViewDelegate().setText("你点击了button");
                break;
        }
    }
}
