package com.snubee.mvp.databind;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import com.snubee.mvp.presenter.PresenterImp;
import com.snubee.mvp.view.IDelegate;

import java.lang.reflect.ParameterizedType;

import butterknife.ButterKnife;


/**
 * 集成数据-视图绑定的Activity基类(Presenter层)
 *
 * @param <T> View层代理类
 * @param <P> Presenter
 * @author snubee
 */
public abstract class DataBindActivity<P extends PresenterImp<T>, T extends IDelegate> extends AppCompatActivity {

    protected P mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        mPresenter = getPresenter();
        initPresenter();

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
//
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