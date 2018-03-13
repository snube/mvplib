package com.snubee.mvp.samples.demo3;

import android.support.annotation.UiThread;
import android.widget.Button;

import com.snubee.mvp.samples.R;
import com.snubee.mvp.view.DelegateIpm;

import butterknife.BindView;

@UiThread
public class MainDelegate extends DelegateIpm {
    @BindView(R.id.button2)
    Button mButton2;
    @BindView(R.id.button3)
    Button mButton3;


//    @BindView(R.id.button2)
//    Button mButton2;
//    @BindView(R.id.button3)
//    Button mButton3;

    @Override
    public int getRootLayoutId() {
        return R.layout.activity_main;
    }


    public void setText() {
        mButton2.setText("dkjfkalh djkah jkads kjlhadsf");
    }
}
