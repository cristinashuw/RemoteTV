package com.example.remotetv;

import dagger.Module;
import dagger.Provides;

@Module
public abstract class RemoteModule {

    @Provides
    static Remote provideRemote() {
        return new RemoteSamsung() {
        };
    }
}
