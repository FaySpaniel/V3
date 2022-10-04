package com.example.cinema2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class Tuesday extends AppCompatActivity {

    float x1,x2,y1,y2;
    TextView textView;
    ImageButton rasp;
    ImageButton zad;
    ImageButton setting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tuesday);

        textView = findViewById(R.id.textView22);
        rasp =(ImageButton) findViewById(R.id.Raspisanie);
        zad = (ImageButton) findViewById(R.id.Zadanie);
        setting = (ImageButton) findViewById(R.id.Setting);

        Locale locale = new Locale("ru");
        Locale.setDefault(locale);

        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.SUNDAY);
        calendar.set(Calendar.DAY_OF_WEEK,Calendar.TUESDAY);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d MMMM, EEEE");
        String dateTime = simpleDateFormat.format(calendar.getTime());
        textView.setText(dateTime);

        View.OnClickListener raspisanie = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Tuesday.this,Tuesday.class);
                startActivity(intent);
            }
        };
        rasp.setOnClickListener(raspisanie);

        View.OnClickListener zadanie = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Tuesday.this,TaskMain.class);
                startActivity(intent);
            }
        };
        zad.setOnClickListener(zadanie);

        View.OnClickListener set = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Tuesday.this,Settings.class);
                startActivity(intent);
            }
        };
        setting.setOnClickListener(set);
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
                    Intent i = new Intent(Tuesday.this, MainActivity.class);
                    startActivity(i);

                }
                else {
                    if (x2 < x1) {
                        Intent i = new Intent(Tuesday.this, Wednesday.class);
                        startActivity(i);
                    }
                }
                break;
        }
        return false;
    }
}