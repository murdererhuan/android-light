package com.huan.dagger_arouter_demo.module;


import com.huan.dagger_arouter_demo.model.Watch;

import dagger.Module;
import dagger.Provides;

@Module
public class WatchModule {
    @Provides
    public Watch provideWatch(){
        return new Watch();
    }
}
