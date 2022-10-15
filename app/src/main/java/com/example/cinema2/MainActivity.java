package com.example.cinema2;

import android.annotation.SuppressLint;
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

public class MainActivity extends AppCompatActivity {

    float x1, x2, y1, y2;
    TextView textView;
    ImageButton rasp;
    ImageButton zad;
    ImageButton setting;
    Button para1, para2, para3, para4;
    ConstraintLayout para1l, para2l, para3l, para4l;


    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView12);
        rasp = (ImageButton) findViewById(R.id.Raspisanie);
        zad = (ImageButton) findViewById(R.id.Zadanie);
        setting = (ImageButton) findViewById(R.id.Setting);
        para1 = findViewById(R.id.button);
        para2 = findViewById(R.id.button2);
        para3 = findViewById(R.id.button3);
        para4 = findViewById(R.id.button4);
        para1l = findViewById(R.id.constraintLayout3);
        para2l = findViewById(R.id.constraintLayout5);
        para3l = findViewById(R.id.constraintLayout6);
        para4l = findViewById(R.id.constraintLayout7);


        Locale locale = new Locale("ru");
        Locale.setDefault(locale);


        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.SUNDAY);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d MMMM, EEEE");
        String dateTime = simpleDateFormat.format(calendar.getTime());
        textView.setText(dateTime);
        SaveRead with = SaveRead.with(MainActivity.this);


        int type = 0;
        if (with.hasKey("weektype"))
            type = with.readInt("weektype");

        rasp.setOnClickListener
                (view -> {
                    Intent intent = new Intent(MainActivity.this, MainActivity.class);
                    startActivity(intent);
                });

        zad.setOnClickListener
                (view -> {
                    Intent intent = new Intent(MainActivity.this, TaskMain.class);
                    startActivity(intent);
                });

        setting.setOnClickListener
                (view -> {
                    Intent intent = new Intent(MainActivity.this, Settings.class);
                    startActivity(intent);
                });

        int finalType = type;
        para1.setOnClickListener
                (view -> {
                    Intent intent = new Intent(MainActivity.this, RaspPlus.class);
                    intent.putExtra("id", finalType == 0 ? 1 : 101);
                    startActivity(intent);
                });


        para2.setOnClickListener
                (view -> {
                    Intent intent = new Intent(MainActivity.this, RaspPlus.class);
                    intent.putExtra("id", finalType == 0 ? 2 : 102);
                    startActivity(intent);
                });

        para3.setOnClickListener
                (view -> {
                    Intent intent = new Intent(MainActivity.this, RaspPlus.class);
                    intent.putExtra("id", finalType == 0 ? 3 : 103);
                    startActivity(intent);
                });

        para4.setOnClickListener
                (view -> {
                    Intent intent = new Intent(MainActivity.this, RaspPlus.class);
                    intent.putExtra("id", finalType == 0 ? 4 : 104);
                    startActivity(intent);
                });


        Intent intent = getIntent();

        if (intent.getBooleanExtra("First", true)) {
            Calendar cal = Calendar.getInstance();
            cal.setFirstDayOfWeek(Calendar.SUNDAY);
            String dateTim = simpleDateFormat.format(cal.getTime());

            if (dateTim.contains("вторник")) {
                openIntent(MainActivity.this, Tuesday.class);
            } else if (dateTim.contains("среда")) {
                openIntent(MainActivity.this, Wednesday.class);
            } else if (dateTim.contains("четверг")) {
                openIntent(MainActivity.this, Thursday.class);
            } else if (dateTim.contains("пятница")) {
                openIntent(MainActivity.this, Friday.class);
            } else if (dateTim.contains("суббота")) {
                openIntent(MainActivity.this, Saturday.class);
            } else {
                Intent intent1 = new Intent(MainActivity.this, MainActivity.class);
                intent1.putExtra("First", false);
                startActivity(intent1);
            }
        }
        updateData();
    }

    public void updateData() {
        String[] ids;
        SaveRead with = SaveRead.with(this);
        int type = 0;
        if (with.hasKey("weektype"))
            type = with.readInt("weektype");
        if (type == 0)
            ids = new String[]{"1", "2", "3", "4"};
        else ids = new String[]{"101", "102", "103", "104"};
        for (String id : ids) {
            if (with.hasKey(id)) {
                String s = with.readString(id);
                ParaInfo load = ParaInfo.load(s);
                switch (id) {
                    case "101":
                    case "1": {
                        if (!load.color.trim().isEmpty())
                            para1l.setBackgroundColor(Color.parseColor(load.color));

                        ((TextView) findViewById(R.id.cab1)).setText(load.cab);
                        ((TextView) findViewById(R.id.starttime1)).setText(load.starttime);
                        ((TextView) findViewById(R.id.endtime1)).setText(load.endtime);
                        ((TextView) findViewById(R.id.predmet1)).setText(load.predmet);
                        break;
                    }
                    case "102":
                    case "2": {
                        if (!load.color.trim().isEmpty())
                            para2l.setBackgroundColor(Color.parseColor(load.color));

                        ((TextView) findViewById(R.id.cab2)).setText(load.cab);
                        ((TextView) findViewById(R.id.starttime2)).setText(load.starttime);
                        ((TextView) findViewById(R.id.endtime2)).setText(load.endtime);
                        ((TextView) findViewById(R.id.predmet2)).setText(load.predmet);
                        break;
                    }
                    case "103":
                    case "3": {
                        if (!load.color.trim().isEmpty())
                            para3l.setBackgroundColor(Color.parseColor(load.color));

                        ((TextView) findViewById(R.id.cab3)).setText(load.cab);
                        ((TextView) findViewById(R.id.starttime3)).setText(load.starttime);
                        ((TextView) findViewById(R.id.endtime3)).setText(load.endtime);
                        ((TextView) findViewById(R.id.predmet3)).setText(load.predmet);
                        break;
                    }
                    case "104":
                    case "4": {
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
                if (x2 < x1) {
                    Intent i = new Intent(MainActivity.this, Tuesday.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                }
                break;
        }
        return false;
    }

    public void openIntent(AppCompatActivity activity, Class<?> cls) {
        Intent intent = new Intent(activity, cls);
        startActivity(intent);
    }
}