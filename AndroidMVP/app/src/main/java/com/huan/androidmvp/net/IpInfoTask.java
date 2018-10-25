package com.huan.androidmvp.net;

import com.huan.androidmvp.model.Ipinfo;
import com.huan.androidmvp.LoadTasksCallBack;

import cn.finalteam.okhttpfinal.BaseHttpRequestCallback;
import cn.finalteam.okhttpfinal.HttpRequest;
import cn.finalteam.okhttpfinal.RequestParams;

public class IpInfoTask implements NetTask<String> {

    private static IpInfoTask INSTANCE=null;
    private static final String HOST = "http://ip.taobao.com/service/getIpInfo.php";
    private LoadTasksCallBack loadTasksCallBack;

    public IpInfoTask(){

    }

    public static IpInfoTask getInstance(){
        if (INSTANCE==null){
            INSTANCE=new IpInfoTask();
        }
        return INSTANCE;
    }




    @Override
    public void execute(String ip,final LoadTasksCallBack callBack) {
        RequestParams requestParams=new RequestParams();
        requestParams.addFormDataPart("ip",ip);
        HttpRequest.post(HOST,requestParams,new BaseHttpRequestCallback<Ipinfo>(){
            @Override
            public void onStart() {
                super.onStart();
                loadTasksCallBack.onStart();
            }

            @Override
            protected void onSuccess(Ipinfo ipinfo) {
                super.onSuccess(ipinfo);
                loadTasksCallBack.onSuccess(ipinfo);
            }

            @Override
            public void onFinish() {
                super.onFinish();
                loadTasksCallBack.onFinish();
            }

            @Override
            public void onFailure(int errorCode, String msg) {
                super.onFailure(errorCode, msg);
                loadTasksCallBack.onFailed();
            }
        });
    }
}
