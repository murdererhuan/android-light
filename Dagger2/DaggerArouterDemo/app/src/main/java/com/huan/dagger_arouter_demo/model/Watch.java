package com.huan.dagger_arouter_demo.model;


import android.util.Log;

import javax.inject.Inject;

public class Watch {
    @Inject
    public Watch(){

    }

    public String work(){
        return "手表工作";
    }
}
