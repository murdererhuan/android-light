package com.huan.androidmvp.Ipinfo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.huan.androidmvp.R;
import com.huan.androidmvp.net.IpInfoTask;
import com.huan.androidmvp.util.ActivityUtils;

public class MainActivity extends AppCompatActivity {

    private IpInfoPresenter ipInfoPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IpInfoFragment ipInfoFragment=(IpInfoFragment)
                getSupportFragmentManager().findFragmentById(R.id.contentFrame);
        if(ipInfoFragment==null){
            ipInfoFragment=IpInfoFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),ipInfoFragment,R.id.contentFrame);

        }

        IpInfoTask ipInfoTask=IpInfoTask.getInstance();
        ipInfoPresenter =new IpInfoPresenter(ipInfoFragment,ipInfoTask);
        ipInfoFragment.setPresenter(ipInfoPresenter);
    }
}
