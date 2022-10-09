package com.example.cinema2;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class RaspPlus extends AppCompatActivity {
    float x1, x2, y1, y2;
    ImageButton rasp;
    ImageButton zad;
    ImageButton setting;
    ImageButton back;
    ImageButton trash;
    ImageButton save;
    EditText predmet;
    EditText prepod;
    EditText cab;
    EditText starttime;
    EditText endtime;
    EditText typeles;
    private int id;
    private ParaInfo load;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rasp_plus);

        rasp = (ImageButton) findViewById(R.id.Raspisanie);
        zad = (ImageButton) findViewById(R.id.Zadanie);
        setting = (ImageButton) findViewById(R.id.Setting);
        back = (ImageButton) findViewById(R.id.Back);
        trash = (ImageButton) findViewById(R.id.Trash);
        save = (ImageButton) findViewById(R.id.SaveBtn);
        predmet = findViewById(R.id.Predmet);
        prepod = findViewById(R.id.prepod);
        cab = findViewById(R.id.Kabinet);
        starttime = findViewById(R.id.start);
        endtime = findViewById(R.id.end);
        typeles = findViewById(R.id.TypeLesson);


        id = getIntent().getIntExtra("id", -1);
        SaveRead with = SaveRead.with(this);
        String name = String.valueOf(id);
        if (with.hasKey(name)) {
            String s = with.readString(name);
            load = ParaInfo.load(s);
            prepod.setText(load.prepod);
            predmet.setText(load.predmet);
            cab.setText(load.cab);
            starttime.setText(load.starttime);
            endtime.setText(load.endtime);
            typeles.setText(load.typels);
        } else {
            load = new ParaInfo();
            load.id = id;
        }


        rasp.setOnClickListener
                (view -> {
                    Intent intent = new Intent(RaspPlus.this, MainActivity.class);
                    startActivity(intent);
                });

        zad.setOnClickListener
                (view -> {
                    Intent intent = new Intent(RaspPlus.this, TaskMain.class);
                    startActivity(intent);
                });

        setting.setOnClickListener
                (view -> {
                    Intent intent = new Intent(RaspPlus.this, Settings.class);
                    startActivity(intent);
                });

        trash.setOnClickListener
                (view -> {
                    SaveRead.with(this).removeKey(name);
                    startActivity(new Intent(this, MainActivity.class));
                    finish();
                });

        back.setOnClickListener
                (view -> {
                    finish();
                });

        View.OnClickListener SaveInfo = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                load.predmet = predmet.getText().toString();
                load.cab = cab.getText().toString();
                load.endtime = endtime.getText().toString();
                load.starttime = starttime.getText().toString();
                load.typels = typeles.getText().toString();
                load.prepod = prepod.getText().toString();
                String save = load.save();
                with.write(name, save);

            }
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
                if (x2 < x1) {
                    Intent i = new Intent(RaspPlus.this, ColorForLayout.class);
                    i.putExtra("id", id);
                    startActivity(i);
                }
                break;
        }
        return false;
    }
}