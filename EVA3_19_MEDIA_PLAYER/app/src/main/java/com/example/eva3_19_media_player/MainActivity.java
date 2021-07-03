package com.example.eva3_19_media_player;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaPlayer = MediaPlayer.create(this, R.raw.song);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(mediaPlayer != null){
            mediaPlayer.start();
        }
    }
}