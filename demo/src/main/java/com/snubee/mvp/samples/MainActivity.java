package com.snubee.mvp.samples;

import com.snubee.mvp.databind.DataBindActivity;
import com.snubee.mvp.databind.DataBinder;
import com.snubee.mvp.presenter.PresenterImp;
import com.snubee.mvp.samples.demo3.MainDelegate;

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
