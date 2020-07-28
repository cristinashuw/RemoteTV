package com.example.remotetv;

import android.util.Log;

import javax.inject.Inject;

import static android.content.ContentValues.TAG;

public class RemoteSamsung implements Remote {

    @Override
    public void power(boolean isOn) {
        Log.d(TAG, "power: ");
    }

    @Override
    public void volumeUp() {
        Log.d(TAG, "Volume Up");

    }

    @Override
    public void volumeDown() {
        Log.d(TAG, "Volume Down");
    }


    @Inject
    public RemoteSamsung() {

    }
}
