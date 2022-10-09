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

public class Saturday extends AppCompatActivity {

    Float x1, x2, y1, y2;
    TextView textView;
    ImageButton rasp;
    ImageButton zad;
    ImageButton setting;
    Button para1, para2, para3, para4;
    ConstraintLayout para1l, para2l, para3l, para4l;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saturday);

        textView = findViewById(R.id.textView26);
        rasp = (ImageButton) findViewById(R.id.Raspisanie);
        zad = (ImageButton) findViewById(R.id.Zadanie);
        setting = (ImageButton) findViewById(R.id.Setting);
        para1 = findViewById(R.id.button21);
        para2 = findViewById(R.id.button22);
        para3 = findViewById(R.id.button23);
        para4 = findViewById(R.id.button24);
        para1l = findViewById(R.id.constraintLayout3);
        para2l = findViewById(R.id.constraintLayout5);
        para3l = findViewById(R.id.constraintLayout6);
        para4l = findViewById(R.id.constraintLayout7);

        Locale locale = new Locale("ru");
        Locale.setDefault(locale);

        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.SUNDAY);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d MMMM, EEEE");
        String dateTime = simpleDateFormat.format(calendar.getTime());
        textView.setText(dateTime);

        SaveRead with = SaveRead.with(this);


        int type = 0;
        if (with.hasKey("weektype"))
            type = with.readInt("weektype");

        View.OnClickListener raspisanie = view -> {
            Intent intent = new Intent(Saturday.this, Saturday.class);
            startActivity(intent);
        };
        rasp.setOnClickListener(raspisanie);

        View.OnClickListener zadanie = view -> {
            Intent intent = new Intent(Saturday.this, TaskMain.class);
            startActivity(intent);
        };
        zad.setOnClickListener(zadanie);

        View.OnClickListener set = view -> {
            Intent intent = new Intent(Saturday.this, Settings.class);
            startActivity(intent);
        };
        setting.setOnClickListener(set);

        int finalType = type;
        para1.setOnClickListener
                (view -> {
                    Intent intent = new Intent(Saturday.this, RaspPlus.class);
                    intent.putExtra("id", finalType == 0 ? 21 : 121);
                    startActivity(intent);
                });


        para2.setOnClickListener
                (view -> {
                    Intent intent = new Intent(Saturday.this, RaspPlus.class);
                    intent.putExtra("id", finalType == 0 ? 22 : 122);
                    startActivity(intent);
                });

        para3.setOnClickListener
                (view -> {
                    Intent intent = new Intent(Saturday.this, RaspPlus.class);
                    intent.putExtra("id", finalType == 0 ? 23 : 123);
                    startActivity(intent);
                });

        para4.setOnClickListener
                (view -> {
                    Intent intent = new Intent(Saturday.this, RaspPlus.class);
                    intent.putExtra("id", finalType == 0 ? 24 : 124);
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
            ids = new String[]{"21", "22", "23", "24"};
        else ids = new String[]{"121", "122", "123", "124"};
        for (String id : ids) {
            if (with.hasKey(id)) {
                String s = with.readString(id);
                ParaInfo load = ParaInfo.load(s);
                switch (id) {
                    case "121":
                    case "21": {
                        if (!load.color.trim().isEmpty())
                            para1l.setBackgroundColor(Color.parseColor(load.color));

                        ((TextView) findViewById(R.id.cab1)).setText(load.cab);
                        ((TextView) findViewById(R.id.starttime1)).setText(load.starttime);
                        ((TextView) findViewById(R.id.endtime1)).setText(load.endtime);
                        ((TextView) findViewById(R.id.predmet1)).setText(load.predmet);
                        break;
                    }
                    case "122":
                    case "22": {
                        if (!load.color.trim().isEmpty())
                            para2l.setBackgroundColor(Color.parseColor(load.color));

                        ((TextView) findViewById(R.id.cab2)).setText(load.cab);
                        ((TextView) findViewById(R.id.starttime2)).setText(load.starttime);
                        ((TextView) findViewById(R.id.endtime2)).setText(load.endtime);
                        ((TextView) findViewById(R.id.predmet2)).setText(load.predmet);
                        break;
                    }
                    case "123":
                    case "23": {
                        if (!load.color.trim().isEmpty())
                            para3l.setBackgroundColor(Color.parseColor(load.color));

                        ((TextView) findViewById(R.id.cab3)).setText(load.cab);
                        ((TextView) findViewById(R.id.starttime3)).setText(load.starttime);
                        ((TextView) findViewById(R.id.endtime3)).setText(load.endtime);
                        ((TextView) findViewById(R.id.predmet3)).setText(load.predmet);
                        break;
                    }
                    case "124":
                    case "24": {
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
                    Intent i = new Intent(Saturday.this, Friday.class);
                    startActivity(i);
                }
                break;
        }
        return false;
    }
}