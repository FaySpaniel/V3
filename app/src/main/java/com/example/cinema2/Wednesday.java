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

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Wednesday extends AppCompatActivity {

    float x1, x2, y1, y2;
    TextView textView;
    ImageButton rasp;
    ImageButton zad;
    ImageButton setting;
    Button para1, para2, para3, para4;
    ConstraintLayout para1l, para2l, para3l, para4l;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wednesday);

        textView = findViewById(R.id.textView23);
        rasp = (ImageButton) findViewById(R.id.Raspisanie);
        zad = (ImageButton) findViewById(R.id.Zadanie);
        setting = (ImageButton) findViewById(R.id.Setting);

        para1 = findViewById(R.id.button9);
        para2 = findViewById(R.id.button10);
        para3 = findViewById(R.id.button11);
        para4 = findViewById(R.id.button12);
        para1l = findViewById(R.id.constraintLayout3);
        para2l = findViewById(R.id.constraintLayout5);
        para3l = findViewById(R.id.constraintLayout6);
        para4l = findViewById(R.id.constraintLayout7);

        Locale locale = new Locale("ru");
        Locale.setDefault(locale);

        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.SUNDAY);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d MMMM, EEEE");
        String dateTime = simpleDateFormat.format(calendar.getTime());
        textView.setText(dateTime);

        SaveRead with = SaveRead.with(this);


        int type = 0;
        if (with.hasKey("weektype"))
            type = with.readInt("weektype");

        rasp.setOnClickListener
                (view -> {
                    Intent intent = new Intent(Wednesday.this, Wednesday.class);
                    startActivity(intent);
                });

        zad.setOnClickListener
                (view -> {
                    Intent intent = new Intent(Wednesday.this, TaskMain.class);
                    startActivity(intent);
                });

        setting.setOnClickListener
                (view -> {
                    Intent intent = new Intent(Wednesday.this, Settings.class);
                    startActivity(intent);
                });

        int finalType = type;
        para1.setOnClickListener
                (view -> {
                    Intent intent = new Intent(Wednesday.this, RaspPlus.class);
                    intent.putExtra("id", finalType == 0 ? 9 : 109);
                    startActivity(intent);
                });


        para2.setOnClickListener
                (view -> {
                    Intent intent = new Intent(Wednesday.this, RaspPlus.class);
                    intent.putExtra("id", finalType == 0 ? 10 : 110);
                    startActivity(intent);
                });

        para3.setOnClickListener
                (view -> {
                    Intent intent = new Intent(Wednesday.this, RaspPlus.class);
                    intent.putExtra("id", finalType == 0 ? 11 : 111);
                    startActivity(intent);
                });

        para4.setOnClickListener
                (view -> {
                    Intent intent = new Intent(Wednesday.this, RaspPlus.class);
                    intent.putExtra("id", finalType == 0 ? 12 : 112);
                    startActivity(intent);
                });
        updateData();
    }

    public void updateData() {
        String[] ids;
        SaveRead with = SaveRead.with(this);
        int type = 0;
        if (with.hasKey("weektype"))
            type = with.readInt("weektype");
        if (type == 0)
            ids = new String[]{"9", "10", "11", "12"};
        else ids = new String[]{"109", "110", "111", "112"};
        for (String id : ids) {
            if (with.hasKey(id)) {
                String s = with.readString(id);
                ParaInfo load = ParaInfo.load(s);
                switch (id) {
                    case "109":
                    case "9": {
                        if (!load.color.trim().isEmpty())
                            para1l.setBackgroundColor(Color.parseColor(load.color));

                        ((TextView) findViewById(R.id.cab1)).setText(load.cab);
                        ((TextView) findViewById(R.id.starttime1)).setText(load.starttime);
                        ((TextView) findViewById(R.id.endtime1)).setText(load.endtime);
                        ((TextView) findViewById(R.id.predmet1)).setText(load.predmet);
                        break;
                    }
                    case "110":
                    case "10": {
                        if (!load.color.trim().isEmpty())
                            para2l.setBackgroundColor(Color.parseColor(load.color));

                        ((TextView) findViewById(R.id.cab2)).setText(load.cab);
                        ((TextView) findViewById(R.id.starttime2)).setText(load.starttime);
                        ((TextView) findViewById(R.id.endtime2)).setText(load.endtime);
                        ((TextView) findViewById(R.id.predmet2)).setText(load.predmet);
                        break;
                    }
                    case "111":
                    case "11": {
                        if (!load.color.trim().isEmpty())
                            para3l.setBackgroundColor(Color.parseColor(load.color));

                        ((TextView) findViewById(R.id.cab3)).setText(load.cab);
                        ((TextView) findViewById(R.id.starttime3)).setText(load.starttime);
                        ((TextView) findViewById(R.id.endtime3)).setText(load.endtime);
                        ((TextView) findViewById(R.id.predmet3)).setText(load.predmet);
                        break;
                    }
                    case "112":
                    case "12": {
                        if (!load.color.trim().isEmpty())
                            para4l.setBackgroundColor(Color.parseColor(load.color));

                        ((TextView) findViewById(R.id.cab4)).setText(load.cab);
                        ((TextView) findViewById(R.id.starttime4)).setText(load.starttime);
                        ((TextView) findViewById(R.id.endtime4)).setText(load.endtime);
                        ((TextView) findViewById(R.id.predmet4)).setText(load.predmet);
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
                if (x1 < x2) {
                    Intent i = new Intent(Wednesday.this, Tuesday.class);
                    startActivity(i);

                } else {
                    if (x2 < x1) {
                        Intent i = new Intent(Wednesday.this, Thursday.class);
                        startActivity(i);
                    }
                }
                break;
        }
        return false;
    }
}