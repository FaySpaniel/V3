package com.example.cinema2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class TaskMain extends AppCompatActivity {

    Button task1;
    Button task2;
    Button task3;
    Button task4;
    Button task5;
    ImageButton rasp;
    ImageButton zad;
    ImageButton setting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_main);

        rasp = (ImageButton) findViewById(R.id.Raspisanie);
        zad = (ImageButton) findViewById(R.id.Zadanie);
        setting = (ImageButton) findViewById(R.id.Setting);
        task1 = (Button) findViewById(R.id.button25);
        task2 = (Button) findViewById(R.id.button26);
        task3 = (Button) findViewById(R.id.button27);
        task4 = (Button) findViewById(R.id.button28);
        task5 = (Button) findViewById(R.id.button29);

        View.OnClickListener raspisanie = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TaskMain.this, MainActivity.class);
                startActivity(intent);
            }
        };
        rasp.setOnClickListener(raspisanie);

        View.OnClickListener zadanie = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TaskMain.this, TaskMain.class);
                startActivity(intent);
            }
        };
        zad.setOnClickListener(zadanie);

        View.OnClickListener set = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TaskMain.this, Settings.class);
                startActivity(intent);
            }
        };
        setting.setOnClickListener(set);

        View.OnClickListener firsttask = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TaskMain.this, Tasks.class);
                startActivity(intent);
            }
        };
        task1.setOnClickListener(firsttask);

        View.OnClickListener secondtask = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TaskMain.this, Tasks.class);
                startActivity(intent);
            }
        };
        task2.setOnClickListener(secondtask);

        View.OnClickListener thirdtask = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TaskMain.this, Tasks.class);
                startActivity(intent);
            }
        };
        task3.setOnClickListener(thirdtask);

        View.OnClickListener fourthtask = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TaskMain.this, Tasks.class);
                startActivity(intent);
            }
        };
        task4.setOnClickListener(fourthtask);

        View.OnClickListener fifthtask = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TaskMain.this, Tasks.class);
                startActivity(intent);
            }
        };
        task5.setOnClickListener(fifthtask);

    }
}