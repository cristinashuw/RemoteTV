package com.example.remotetv;

import android.app.Application;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Component(modules = {AndroidSupportInjectionModule.class, RemoteModule.class})
public interface RemoteComponent extends AndroidInjector<RemoteApplication> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        RemoteComponent.Builder application(Application application);

        RemoteComponent build();
    }
}
