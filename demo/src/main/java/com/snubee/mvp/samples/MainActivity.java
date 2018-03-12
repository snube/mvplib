package com.snubee.mvp.samples;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.snubee.mvp.databind.DataBindActivity;
import com.snubee.mvp.databind.DataBinder;
import com.snubee.mvp.presenter.PresenterImp;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends DataBindActivity<MainDelegate>{


    @Override
    public DataBinder getDataBinder() {
        return null;
    }

    @Override
    public PresenterImp getPresenter() {
        return new MainPresenter();
    }
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        ButterKnife.bind(this, mPresenter.getViewDelegate().getRootView());
////        m.setText("dfjfakk");
//    }
//
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        ButterKnife.bind(this);
//        m.setText("dkjafkljadk");
//    }
}
