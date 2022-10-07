package com.example.cinema2;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class RaspPlus extends AppCompatActivity {
    float x1,x2,y1,y2;
    ImageButton rasp;
    ImageButton zad;
    ImageButton setting;
    ImageButton back;
    ImageButton trash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rasp_plus);

        rasp = (ImageButton) findViewById(R.id.Raspisanie);
        zad = (ImageButton) findViewById(R.id.Zadanie);
        setting = (ImageButton) findViewById(R.id.Setting);
        back = (ImageButton) findViewById(R.id.Back);
        trash = (ImageButton) findViewById(R.id.Trash);
        Spinner spinner = findViewById(R.id.spinner);

        int selected = spinner.getSelectedItemPosition();

        View.OnClickListener raspisanie = view -> {
            Intent intent = new Intent(RaspPlus.this, MainActivity.class);
            startActivity(intent);
        };
        rasp.setOnClickListener(raspisanie);

        View.OnClickListener zadanie = view -> {
            Intent intent = new Intent(RaspPlus.this, TaskMain.class);
            startActivity(intent);
        };
        zad.setOnClickListener(zadanie);

        View.OnClickListener set = view -> {
            Intent intent = new Intent(RaspPlus.this, Settings.class);
            startActivity(intent);
        };
        setting.setOnClickListener(set);

        View.OnClickListener tra = view -> {
            Intent intent = new Intent(RaspPlus.this, MainActivity.class);
            startActivity(intent);
        };
        trash.setOnClickListener(tra);

        View.OnClickListener bac = view -> {
            finish();
        };
        back.setOnClickListener(bac);
    }

    public boolean onTouchEvent(MotionEvent touchEvent) {
        switch (touchEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                x1 = touchEvent.getX();
                y1 = touchEvent.getY();
                break;
            case MotionEvent.ACTION_UP:
                x2 = touchEvent.getX();
                y2 = touchEvent.getY();
                if (x2 < x1) {
                    Intent i = new Intent(RaspPlus.this, ColorForLayout.class);
                    startActivity(i);
                }
                break;
        }
        return false;
    }
}