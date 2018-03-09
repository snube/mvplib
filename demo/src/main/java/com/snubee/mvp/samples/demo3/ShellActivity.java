package com.snubee.mvp.samples.demo3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.snubee.mvp.samples.R;

/**
 * @author snubee
 * @email snubee96@gmail.com
 * @time 2018/3/9 14:57
 **/
public class ShellActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shell);
        getSupportFragmentManager().beginTransaction().replace(R.id.content, new MVPFragment())
                .commit();
    }
}
