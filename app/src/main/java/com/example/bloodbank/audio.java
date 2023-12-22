package com.example.bloodbank;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class audio extends AppCompatActivity {
  MediaPlayer t ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);
        t =MediaPlayer.create(audio.this,R.raw.voice);

    }

    public void play (View V ){
        t.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        t.release();
    }
}