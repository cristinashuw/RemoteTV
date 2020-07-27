package com.example.remotetv;

import dagger.android.AndroidInjector;


public abstract class DaggerApplication extends dagger.android.DaggerApplication {
    @Override
    protected abstract AndroidInjector<? extends dagger.android.support.DaggerApplication> applicationInjector();
}
