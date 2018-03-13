package com.snubee.mvp.samples;

import android.content.Intent;
import android.view.View;

import com.snubee.mvp.presenter.PresenterImp;
import com.snubee.mvp.samples.demo3.MainDelegate;
import com.snubee.mvp.samples.demo3.ShellActivity;

/**
 * Created by snubee on 2018/3/8.
 */

public class MainPresenter extends PresenterImp<MainDelegate> implements View.OnClickListener {


    @Override
    protected Class<MainDelegate> getDelegateClass() {
        return MainDelegate.class;
    }

    @Override
    public boolean isMoreDataBinder() {
        return false;
    }

    @Override
    public void bindEventStart() {
        getViewDelegate().setOnClickListener(this, R.id.button2);
        getViewDelegate().setOnClickListener(this, R.id.button3);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button2:
                getViewDelegate().setText();
//                getViewDelegate().getActivity().startActivity(new Intent(getViewDelegate().getActivity(), DemoActivity.class));
                break;
            case R.id.button3:
                getViewDelegate().getActivity().startActivity(new Intent(getViewDelegate().getActivity(), ShellActivity.class));
                break;
            default:
                break;
        }
    }

}
