package com.snubee.mvp.databind;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.snubee.mvp.presenter.PresenterImp;
import com.snubee.mvp.view.IDelegate;

import java.lang.reflect.ParameterizedType;


/**
 * 集成数据-视图绑定的Fragment基类(Presenter层)
 *
 * @param <T> View层代理类
 * @param <P> Presenter
 * @author snubee
 */
public abstract class DataBindFragment<P extends PresenterImp<T>, T extends IDelegate> extends Fragment {

    protected P mPresenter;
    protected LayoutInflater mInflater;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        mPresenter = getPresenter();
        initPresenter();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        this.mInflater = inflater;
        mPresenter.onCreate(inflater, savedInstanceState);
        Log.i("snubee", "onCreateView");
        return mPresenter.getViewDelegate().getRootView();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.i("snubee", "onViewCreated");
        mPresenter.getViewDelegate().initWidget();
        mPresenter.addDataBinder(getDataBinder());
        mPresenter.isMoreDataBinder();
        mPresenter.bindEventStart();
        bindEvenListener();
    }

    protected void bindEvenListener() {
    }


    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        mPresenter.onRestoreInstanceState(mInflater, savedInstanceState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
    }


    /**
     * 实现类返回一个databinder，即viewmodel
     *
     * @return
     */
    public abstract DataBinder getDataBinder();

//    /**
//     * 返回一个业务逻辑的presenter
//     *
//     * @return
//     */
//    @NonNull
//    public abstract PresenterImp getPresenter();

    /**
     * 初始化Presenter
     */
    private void initPresenter() {
        if (this.getClass().getGenericSuperclass() instanceof ParameterizedType &&
                ((ParameterizedType) (this.getClass().getGenericSuperclass())).getActualTypeArguments().length > 0) {
            Class mPresenterClass = (Class) ((ParameterizedType) (this.getClass()
                    .getGenericSuperclass())).getActualTypeArguments()[0];
            try {
                mPresenter = (P) mPresenterClass.newInstance();
            } catch (java.lang.InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

}
