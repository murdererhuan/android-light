package com.huan.androidmvp.net;

import com.huan.androidmvp.LoadTasksCallBack;

public interface NetTask<T> {
    void  execute(T data, LoadTasksCallBack callBack);
}
