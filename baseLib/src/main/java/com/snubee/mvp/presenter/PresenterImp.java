package com.snubee.mvp.presenter;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;

import com.snubee.mvp.databind.DataBinder;
import com.snubee.mvp.model.IModel;
import com.snubee.mvp.view.IDelegate;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;


/**
 * Presenter base class for Activity
 * Presenter层的实现基类
 *
 * @param <T> View delegate class type
 * @author snubee
 */
public abstract class PresenterImp<T extends IDelegate> implements IPresenter<T> {
    protected T viewDelegate;

    public PresenterImp() {
        try {
            viewDelegate = getDelegateClass().newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException("create IDelegate error");
        } catch (IllegalAccessException e) {
            throw new RuntimeException("create IDelegate error");
        }
    }

    public void onCreate(LayoutInflater inflater, Bundle savedInstanceState) {
        viewDelegate.create(inflater, null, savedInstanceState);
    }

    public void onRestoreInstanceState(LayoutInflater inflater, Bundle savedInstanceState) {
        if (viewDelegate == null) {
            try {
                viewDelegate = getDelegateClass().newInstance();
                onCreate(inflater, savedInstanceState);
            } catch (InstantiationException e) {
                throw new RuntimeException("create IDelegate error");
            } catch (IllegalAccessException e) {
                throw new RuntimeException("create IDelegate error");
            }
        }
    }

    @Override
    public T getViewDelegate() {
        return viewDelegate;
    }

    /**
     * 资源回收，防止内存泄漏，在view销毁时需要调用该方法
     */
    public void onDestroy() {
        viewDelegate = null;
        for (DataBinder binder : mDataBinders.values())
            binder = null;
        mDataBinders.clear();
        mDataBinders = null;
    }

    protected abstract Class<T> getDelegateClass();

    /**
     * databinder 的 model--databinder 键值对缓存，根据model自动获取匹配的binder更新ui
     */
    protected Map<Object, DataBinder> mDataBinders = new HashMap<>();

    /**
     * 添加一个databinder，ViewModel实现类
     *
     * @param binder
     */
    public void addDataBinder(DataBinder binder) {
        if (binder != null) {
            //通过databinder的model的类型作为 键值对 存入缓存,方便根据model更新view的视图
            Type[] interfacesTypes = binder.getClass().getGenericInterfaces();
            Type[] genericType2 = ((ParameterizedType) interfacesTypes[0]).getActualTypeArguments();
            Class clazz = (Class) genericType2[1];
            mDataBinders.put(clazz.getName(), binder);
        }
    }


    /**
     * 根据model刷新相应的ui
     *
     * @param data
     * @param <D>
     */
    public <D extends IModel> void notifyModelChanged(D data) {
        if (mDataBinders != null && mDataBinders.size() > 0) {
            DataBinder binder = mDataBinders.get(data.getClass().getName());
            if (binder != null)
                binder.viewBindModel(viewDelegate, data);
        }
    }


    /**
     * 是否需要添加更多的databinder，适配一个view有多个接口的情况
     * 实现类在该方法初始化额外的 databinder 并调用addDataBinder（binder）添加到binder管理集合
     *
     * @return
     */
    public abstract boolean isMoreDataBinder();

    /**
     * 提供给实现类的事件开发方法,防止控件没创建引起的空指针问题，统一逻辑方法的入口
     *
     * @return
     */
    public abstract void bindEventStart();


    /**
     * view是否还存在，异步数据返回刷新ui时需要加上该判断防止空指针出现
     *
     * @return
     */
    @Override
    public boolean isNotActive() {
        return viewDelegate == null || viewDelegate.getRootView() == null
                || viewDelegate.getRootView().getContext() == null
                || ((Activity) (viewDelegate.getRootView().getContext())).isFinishing()
                || ((Activity) (viewDelegate.getRootView().getContext())).isDestroyed();
    }
}
