package com.example.cinema2;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Friday extends AppCompatActivity {

    float x1, x2, y1, y2;
    TextView textView;
    ImageButton rasp;
    ImageButton zad;
    ImageButton setting;
    Button para1, para2,para3,para4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friday);

        textView = findViewById(R.id.textView25);
        rasp = (ImageButton) findViewById(R.id.Raspisanie);
        zad = (ImageButton) findViewById(R.id.Zadanie);
        setting = (ImageButton) findViewById(R.id.Setting);
        para1 = findViewById(R.id.button17);
        para2 = findViewById(R.id.button18);
        para3 = findViewById(R.id.button19);
        para4 = findViewById(R.id.button20);

        Locale locale = new Locale("ru");
        Locale.setDefault(locale);

        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.SUNDAY);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d MMMM, EEEE");
        String dateTime = simpleDateFormat.format(calendar.getTime());
        textView.setText(dateTime);

        View.OnClickListener raspisanie = view -> {
            Intent intent = new Intent(Friday.this, Friday.class);
            startActivity(intent);
        };
        rasp.setOnClickListener(raspisanie);

        View.OnClickListener zadanie = view -> {
            Intent intent = new Intent(Friday.this, TaskMain.class);
            startActivity(intent);
        };
        zad.setOnClickListener(zadanie);

        View.OnClickListener set = view -> {
            Intent intent = new Intent(Friday.this, Settings.class);
            startActivity(intent);
        };
        setting.setOnClickListener(set);
        para1.setOnClickListener
                (view -> {
                    Intent intent = new Intent(Friday.this, RaspPlus.class);
                    intent.putExtra("id", 17);
                    startActivity(intent);
                });


        para2.setOnClickListener
                (view -> {
                    Intent intent = new Intent(Friday.this, RaspPlus.class);
                    intent.putExtra("id", 18);
                    startActivity(intent);
                });

        para3.setOnClickListener
                (view -> {
                    Intent intent = new Intent(Friday.this, RaspPlus.class);
                    intent.putExtra("id", 19);
                    startActivity(intent);
                });

        para4.setOnClickListener
                (view -> {
                    Intent intent = new Intent(Friday.this, RaspPlus.class);
                    intent.putExtra("id", 20);
                    startActivity(intent);
                });
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
                    Intent i = new Intent(Friday.this, Thursday.class);
                    startActivity(i);

                } else {
                    if (x2 < x1) {
                        Intent i = new Intent(Friday.this, Saturday.class);
                        startActivity(i);
                    }
                }
                break;
        }
        return false;
    }
}