package com.example.cinema2;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SuperMax extends AppCompatActivity {

    MediaPlayer mPlayer;
    Button supermax;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_super_max);

        mPlayer = MediaPlayer.create(this, R.raw.sm);
        supermax = findViewById(R.id.button67);


        supermax.setOnClickListener ( view -> mPlayer.start());
    }
}