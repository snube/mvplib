package com.snubee.mvp.samples;

import com.snubee.mvp.view.DelegateIpm;

public class MainDelegate extends DelegateIpm {

    @Override
    public int getRootLayoutId() {
        return R.layout.activity_main;
    }
}
