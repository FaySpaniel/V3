package com.example.cinema2;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SuperMax extends AppCompatActivity {

    MediaPlayer mPlayermax,mPlayerMiku;
    Button supermax,mikurun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_super_max);

        mPlayermax = MediaPlayer.create(this, R.raw.sm);
        mPlayerMiku = MediaPlayer.create(this,R.raw.mikurun);
        supermax = findViewById(R.id.button67);
        mikurun = findViewById(R.id.button68);


        supermax.setOnClickListener ( view -> mPlayermax.start());
        mikurun.setOnClickListener ( view -> mPlayerMiku.start());

    }
}