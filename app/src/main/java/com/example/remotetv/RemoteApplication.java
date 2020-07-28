package com.example.remotetv;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

public class RemoteApplication extends DaggerApplication {
    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerRemoteComponent.builder().application(this).build();
    }

}
