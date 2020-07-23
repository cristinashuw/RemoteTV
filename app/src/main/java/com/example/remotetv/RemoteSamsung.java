package com.example.remotetv;

import android.util.Log;

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
    public void volemeDown() {
        Log.d(TAG, "Volume Down");
    }
}