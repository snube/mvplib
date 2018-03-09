package com.snubee.mvp.presenter;


import com.snubee.mvp.view.IDelegate;

/**
 * presenter base class
 * 业务层代理的接口协议
 *
 * @author snubee
 */
public interface IPresenter<T extends IDelegate> {
    boolean isNotActive();


    T getViewDelegate();

}
