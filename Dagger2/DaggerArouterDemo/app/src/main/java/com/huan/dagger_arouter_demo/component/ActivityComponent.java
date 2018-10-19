package com.huan.dagger_arouter_demo.component;


import com.huan.dagger_arouter_demo.MainActivity;
import com.huan.dagger_arouter_demo.module.WatchModule;

import javax.inject.Inject;

import dagger.Component;

@Component(modules = WatchModule.class)
public interface ActivityComponent {
    void inject(MainActivity mainActivity);
}
