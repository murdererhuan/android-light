package com.huan.dagger_arouter_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;


import com.huan.dagger_arouter_demo.component.DaggerActivityComponent;
import com.huan.dagger_arouter_demo.model.Watch;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    Watch watch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DaggerActivityComponent.create().inject(this);

        String sr=watch.work();
        Log.d("huanfuan",sr);

    }
}
