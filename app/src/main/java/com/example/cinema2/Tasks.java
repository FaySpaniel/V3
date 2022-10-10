package com.example.cinema2;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

public class Tasks extends AppCompatActivity {

    float x1,x2,y1,y2;
    ImageButton rasp;
    ImageButton zad;
    ImageButton setting;
    ImageButton trash;
    ImageButton back;
    ImageButton save;
    EditText nametask;
    EditText predmet;
    EditText enddate;
    EditText note;
    SwitchCompat done;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);

        rasp = (ImageButton) findViewById(R.id.Raspisanie);
        zad = (ImageButton) findViewById(R.id.Zadanie);
        setting = (ImageButton) findViewById(R.id.Setting);
        trash = (ImageButton) findViewById(R.id.Trash);
        back = (ImageButton) findViewById(R.id.Back);
        nametask = findViewById(R.id.NameTask);
        predmet = findViewById(R.id.Predmet);
        enddate = findViewById(R.id.EndDate);
        note = findViewById(R.id.Note);
        save = findViewById(R.id.saveBtn);
        done = findViewById(R.id.switch1);

        id = getIntent().getIntExtra("id", -1);
        SaveRead with = SaveRead.with(this);
        String name = String.valueOf(id);
        TaskInfo load;
        if (with.hasKey(name)) {
            String s = with.readString(name);
            load = TaskInfo.load(s);
            note.setText(load.note);
            done.setChecked(load.done);
            predmet.setText(load.predmet);
            enddate.setText(load.endDate);
            nametask.setText(load.nameTask);
        } else {
            load = new TaskInfo();
            load.id = id;
        }

        rasp.setOnClickListener
                (view -> {
                    Intent intent = new Intent(Tasks.this, MainActivity.class);
                    startActivity(intent);
                });

        zad.setOnClickListener
                (view -> {
                    Intent intent = new Intent(Tasks.this, TaskMain.class);
                    startActivity(intent);
                });

        setting.setOnClickListener
                (view -> {
                    Intent intent = new Intent(Tasks.this, Settings.class);
                    startActivity(intent);
                });

        trash.setOnClickListener
                (view -> {
                    SaveRead.with(this).removeKey(name);
                    startActivity(new Intent(this, TaskMain.class));
                    finish();
                });

        back.setOnClickListener
                (view -> {
                    Intent intent = new Intent(this,TaskMain.class);
                    startActivity(intent);
                });

        View.OnClickListener SaveInfo = view -> {
            load.done=done.isChecked();
            load.predmet=predmet.getText().toString();
            load.endDate=enddate.getText().toString();
            load.nameTask=nametask.getText().toString();
            load.note=note.getText().toString();
            String save = load.save();
            with.write(name, save);

        };
        save.setOnClickListener(SaveInfo);
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
                if (x1 > x2) {
                    Intent i = new Intent(this, ColorForLayout.class);
                    i.putExtra("id",id);
                    startActivity(i);
                }
                break;
        }
        return false;
    }
}