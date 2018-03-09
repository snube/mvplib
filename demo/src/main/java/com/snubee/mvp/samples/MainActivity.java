package com.snubee.mvp.samples;

import com.snubee.mvp.databind.DataBindActivity;
import com.snubee.mvp.databind.DataBinder;
import com.snubee.mvp.presenter.PresenterImp;

public class MainActivity extends DataBindActivity<MainDelegate> {


    @Override
    public DataBinder getDataBinder() {
        return null;
    }

    @Override
    public PresenterImp getPresenter() {
        return new MainPresenter();
    }


}
