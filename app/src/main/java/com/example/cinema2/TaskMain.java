package com.example.cinema2;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class TaskMain extends AppCompatActivity {

    Float x1,x2,y1,y2;
    Button task1;
    Button task2;
    Button task3;
    Button task4;
    Button task5;
    ImageButton rasp;
    ImageButton zad;
    ImageButton setting;
    ConstraintLayout taskl1,taskl2, taskl3, taskl4, taskl5;
    TextView status1;
    TextView status2;
    TextView status3;
    TextView status4;
    TextView status5;

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
        taskl1 = findViewById(R.id.constraintLayout11);
        taskl2 = findViewById(R.id.constraintLayout7);
        taskl3 = findViewById(R.id.constraintLayout8);
        taskl4 = findViewById(R.id.constraintLayout9);
        taskl5 = findViewById(R.id.constraintLayout10);
        status1 = findViewById(R.id.Status1);
        status2 = findViewById(R.id.Status2);
        status3 = findViewById(R.id.Status3);
        status4 = findViewById(R.id.Status4);
        status5 = findViewById(R.id.Status5);

        rasp.setOnClickListener
                (view -> {
                    Intent intent = new Intent(TaskMain.this, MainActivity.class);
                    startActivity(intent);
                });

        zad.setOnClickListener
                (view -> {
                    Intent intent = new Intent(TaskMain.this, TaskMain.class);
                    startActivity(intent);
                });

        setting.setOnClickListener
                (view -> {
                    Intent intent = new Intent(TaskMain.this, Settings.class);
                    startActivity(intent);
                });


        task1.setOnClickListener
                (view -> {
                    Intent intent = new Intent(TaskMain.this, Tasks.class);
                    intent.putExtra("id",51);
                    startActivity(intent);
                });


        task2.setOnClickListener
                (view -> {
                    Intent intent = new Intent(TaskMain.this, Tasks.class);
                    intent.putExtra("id",52);
                    startActivity(intent);
                });


        task3.setOnClickListener
                (view -> {
                    Intent intent = new Intent(TaskMain.this, Tasks.class);
                    intent.putExtra("id",53);
                    startActivity(intent);
                });


        task4.setOnClickListener
                (view -> {
                    Intent intent = new Intent(TaskMain.this, Tasks.class);
                    intent.putExtra("id",54);
                    startActivity(intent);
                });


        task5.setOnClickListener
                (view -> {
                    Intent intent = new Intent(TaskMain.this, Tasks.class);
                    intent.putExtra("id",55);
                    startActivity(intent);
                });
        updateData();
    }

    public void updateData() {
        SaveRead with = SaveRead.with(this);
        String[] ids = new String[]{"51", "52", "53", "54","55"};
        for (String id : ids) {
            if (with.hasKey(id)) {
                String s = with.readString(id);
                TaskInfo load = TaskInfo.load(s);
                switch (id) {
                    case "51": {
                        if (!load.color.trim().isEmpty())
                            taskl1.setBackgroundColor(Color.parseColor(load.color));
                            status1.setText(load.done ? "Выполнено": "В работе");

                        ((TextView) findViewById(R.id.nametask1)).setText(load.nameTask);
                        ((TextView) findViewById(R.id.predmet1)).setText(load.predmet);
                        ((TextView) findViewById(R.id.enddate1)).setText(load.endDate);
                        break;
                    }
                    case "52": {
                        if (!load.color.trim().isEmpty())
                            taskl2.setBackgroundColor(Color.parseColor(load.color));
                            status2.setText(load.done ? "Выполнено": "В работе");

                        ((TextView) findViewById(R.id.nametask2)).setText(load.nameTask);
                        ((TextView) findViewById(R.id.predmet2)).setText(load.predmet);
                        ((TextView) findViewById(R.id.enddate2)).setText(load.endDate);
                        break;
                    }
                    case "53": {
                        if (!load.color.trim().isEmpty())
                            taskl3.setBackgroundColor(Color.parseColor(load.color));
                            status3.setText(load.done ? "Выполнено": "В работе");

                        ((TextView) findViewById(R.id.nametask3)).setText(load.nameTask);
                        ((TextView) findViewById(R.id.predmet3)).setText(load.predmet);
                        ((TextView) findViewById(R.id.enddate3)).setText(load.endDate);
                        break;
                    }
                    case "54": {
                        if (!load.color.trim().isEmpty())
                            taskl4.setBackgroundColor(Color.parseColor(load.color));
                            status4.setText(load.done ? "Выполнено": "В работе");

                        ((TextView) findViewById(R.id.nametask4)).setText(load.nameTask);
                        ((TextView) findViewById(R.id.predmet4)).setText(load.predmet);
                        ((TextView) findViewById(R.id.enddate4)).setText(load.endDate);
                        break;
                    }
                    case "55": {
                        if (!load.color.trim().isEmpty())
                            taskl5.setBackgroundColor(Color.parseColor(load.color));
                            status5.setText(load.done ? "Выполнено": "В работе");

                        ((TextView) findViewById(R.id.nametask5)).setText(load.nameTask);
                        ((TextView) findViewById(R.id.predmet5)).setText(load.predmet);
                        ((TextView) findViewById(R.id.enddate5)).setText(load.endDate);
                        break;
                    }
                }
            }
        }
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
                    Intent i = new Intent(this, Tasks.class);
                    startActivity(i);
                }
                break;
        }
        return false;
    }
}