package com.example.remotetv;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class RemoteModule {

    @Binds
    abstract Remote remoteSamsung(RemoteSamsung remoteSamsung);
}
