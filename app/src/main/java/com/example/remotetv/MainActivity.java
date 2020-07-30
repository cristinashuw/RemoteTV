package com.example.remotetv;

import android.media.AudioManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.Toast;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends DaggerAppCompatActivity {
    private SeekBar seekBar;
    private AudioManager audioManager;

    @ApplicationScope
    @Inject
    Remote remote;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Log.e("REMOTE LOCATION", remote.toString());
//
//        seekBar = findViewById(R.id.seekBar);
//        audioManager = (AudioManager) getApplicationContext().getSystemService(Context.AUDIO_SERVICE);
//        seekBar.setMax(audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC));
//        seekBar.setProgress(audioManager.getStreamVolume(AudioManager.STREAM_MUSIC));

        Switch powerButton = findViewById(R.id.PowerButton);
        Button volumeUpButton = findViewById(R.id.VolUpButton);
        Button volumeDownButton = findViewById(R.id.VolDownButton);

        powerButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                remote.power(b);
            }
        });

        volumeUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                remote.volumeUp();
            }
        });


        volumeDownButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                remote.volumeDown();
            }
        });

    }

    public void VolUpButton(View view){
        audioManager.adjustVolume(AudioManager.ADJUST_RAISE, AudioManager.FLAG_PLAY_SOUND);
        seekBar.setProgress(audioManager.getStreamVolume(AudioManager.STREAM_MUSIC));
        Toast.makeText(this,"Volume Up", Toast.LENGTH_SHORT).show();
    }

    public void VolDownButton(View view){
        audioManager.adjustVolume(AudioManager.ADJUST_LOWER, AudioManager.FLAG_PLAY_SOUND);
        seekBar.setProgress(audioManager.getStreamVolume(AudioManager.STREAM_MUSIC));
        Toast.makeText(this,"Volume Down", Toast.LENGTH_SHORT).show();
    }
}
