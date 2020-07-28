package com.example.remotetv;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class RemoteModule {

    @ApplicationScope
    @Binds
    abstract Remote remoteSamsung(RemoteSamsung remoteSamsung);

    @ContributesAndroidInjector
    abstract MainActivity mainActivity();


}
