package com.snubee.mvp.databind;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import com.snubee.mvp.presenter.PresenterImp;
import com.snubee.mvp.view.IDelegate;

import butterknife.ButterKnife;


/**
 * 集成数据-视图绑定的Activity基类(Presenter层)
 *
 * @param <T> View层代理类
 * @author snubee
 */
public abstract class DataBindActivity<T extends IDelegate> extends AppCompatActivity {

    protected PresenterImp<T> mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = getPresenter();

        mPresenter.onCreate(getLayoutInflater(), savedInstanceState);
        setContentView(mPresenter.getViewDelegate().getRootView());

        mPresenter.getViewDelegate().initWidget();
        mPresenter.addDataBinder(getDataBinder());
        mPresenter.isMoreDataBinder();
        mPresenter.bindEventStart();
        bindEvenListener();
    }

    /**
     * 业务逻辑实现类
     */
    protected void bindEvenListener() {

    }


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mPresenter.onRestoreInstanceState(getLayoutInflater(), savedInstanceState);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
    }


    /**
     * 实现类返回一个databinder，即viewmodel
     *
     * @return
     */
    public abstract DataBinder getDataBinder();

    /**
     * 返回一个业务逻辑的presenter
     *
     * @return
     */
    @NonNull
    public abstract PresenterImp getPresenter();


}