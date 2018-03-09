package com.snubee.mvp.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * View delegate base class
 * 视图层代理的接口协议
 *
 * @author snubee
 */
public interface IDelegate {
    void create(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

    View getRootView();

    void initWidget();

}
