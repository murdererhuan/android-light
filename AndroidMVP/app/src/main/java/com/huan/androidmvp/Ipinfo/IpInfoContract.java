package com.huan.androidmvp.Ipinfo;

import com.huan.androidmvp.model.Ipinfo;
import com.huan.androidmvp.BaseView;


/*
*   定义一个契约接口IpInfoContract 契约接口主要用来存放相同业务的 Presenter 和 View的接口
*
* */


public interface IpInfoContract {
    interface Presenter{
        void getIpInfo(String ip);
    }

    interface View extends BaseView<Presenter> {
        void setIpInfo(Ipinfo ipInfo);
        void showLoading();
        void hideLoading();
        void showError();
        boolean isActive();
    }
}
