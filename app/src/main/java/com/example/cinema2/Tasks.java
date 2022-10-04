package com.example.cinema2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Tasks extends AppCompatActivity {

    ImageButton rasp;
    ImageButton zad;
    ImageButton setting;
    ImageButton trash;
    ImageButton back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);

        rasp = (ImageButton) findViewById(R.id.Raspisanie);
        zad = (ImageButton) findViewById(R.id.Zadanie);
        setting = (ImageButton) findViewById(R.id.Setting);
        trash = (ImageButton) findViewById(R.id.Trash);
        back = (ImageButton) findViewById(R.id.Back);

        View.OnClickListener raspisanie = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Tasks.this, MainActivity.class);
                startActivity(intent);
            }
        };
        rasp.setOnClickListener(raspisanie);

        View.OnClickListener zadanie = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Tasks.this, TaskMain.class);
                startActivity(intent);
            }
        };
        zad.setOnClickListener(zadanie);

        View.OnClickListener set = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Tasks.this, Settings.class);
                startActivity(intent);
            }
        };
        setting.setOnClickListener(set);

        View.OnClickListener tra = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Tasks.this, TaskMain.class);
                startActivity(intent);
            }
        };
        trash.setOnClickListener(tra);

        View.OnClickListener bac = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Tasks.this, TaskMain.class);
                startActivity(intent);
            }
        };
        back.setOnClickListener(bac);
    }
}