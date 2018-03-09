package com.snubee.mvp.samples.demo2;

import android.util.Log;

import com.snubee.mvp.presenter.PresenterImp;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

/**
 * Created by snubee on 2018/3/8.
 */

public class TestPresenter extends PresenterImp<SimpleDelegate> {


    TestBean test = new TestBean("名字");
    Demo2DataTestBinder testBinder;

    @Override
    protected Class<SimpleDelegate> getDelegateClass() {
        return SimpleDelegate.class;
    }

    @Override
    public boolean isMoreDataBinder() {
        testBinder = new Demo2DataTestBinder();
        addDataBinder(testBinder);

        return true;
    }

    @Override
    public void bindEventStart() {

    }

    /**
     * 获取网络数据
     */
    public void getData() {
        getViewDelegate().getRootView().postDelayed(new Runnable() {
            @Override
            public void run() {
                OkGo.<String>post("http://amdc.alipay.com/query")//请求url
                        .execute(new StringCallback() {
                            @Override
                            public void onSuccess(Response<String> response) {
                                Log.i("snubee  ", isNotActive() + "  --  " + response.body());
                                if (!isNotActive()) {
                                    test.setName(response.body());
                                    notifyModelChanged(test);
                                }
                            }
                        });
            }
        }, 1000);
    }

}
