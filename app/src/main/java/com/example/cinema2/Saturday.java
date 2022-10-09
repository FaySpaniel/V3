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

public class Saturday extends AppCompatActivity {

    Float x1, x2, y1, y2;
    TextView textView;
    ImageButton rasp;
    ImageButton zad;
    ImageButton setting;
    Button para1, para2,para3,para4;


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

        Locale locale = new Locale("ru");
        Locale.setDefault(locale);

        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.SUNDAY);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d MMMM, EEEE");
        String dateTime = simpleDateFormat.format(calendar.getTime());
        textView.setText(dateTime);

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

        para1.setOnClickListener
                (view -> {
                    Intent intent = new Intent(Saturday.this, RaspPlus.class);
                    intent.putExtra("id", 21);
                    startActivity(intent);
                });


        para2.setOnClickListener
                (view -> {
                    Intent intent = new Intent(Saturday.this, RaspPlus.class);
                    intent.putExtra("id", 22);
                    startActivity(intent);
                });

        para3.setOnClickListener
                (view -> {
                    Intent intent = new Intent(Saturday.this, RaspPlus.class);
                    intent.putExtra("id", 23);
                    startActivity(intent);
                });

        para4.setOnClickListener
                (view -> {
                    Intent intent = new Intent(Saturday.this, RaspPlus.class);
                    intent.putExtra("id", 24);
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
                    Intent i = new Intent(Saturday.this, Friday.class);
                    startActivity(i);
                }
                break;
        }
        return false;
    }
}