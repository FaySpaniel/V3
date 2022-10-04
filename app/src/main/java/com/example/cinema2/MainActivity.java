package com.example.cinema2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    float x1,x2,y1,y2;
    TextView textView;
    ImageButton rasp;
    ImageButton zad;
    ImageButton setting;
    Button para1;
    Button para2;
    Button para3;
    Button para4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView12);
        rasp =(ImageButton) findViewById(R.id.Raspisanie);
        zad = (ImageButton) findViewById(R.id.Zadanie);
        setting = (ImageButton) findViewById(R.id.Setting);
        para1 = (Button) findViewById(R.id.button);
        para2 = (Button) findViewById(R.id.button2);
        para3 = (Button) findViewById(R.id.button3);
        para4 = (Button) findViewById(R.id.button4);

        Locale locale = new Locale("ru");
        Locale.setDefault(locale);

        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.SUNDAY);
        calendar.set(Calendar.DAY_OF_WEEK,Calendar.MONDAY);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d MMMM, EEEE");
        String dateTime = simpleDateFormat.format(calendar.getTime());
        textView.setText(dateTime);

        View.OnClickListener raspisanie = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,MainActivity.class);
                startActivity(intent);
            }
        };
        rasp.setOnClickListener(raspisanie);

        View.OnClickListener zadanie = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,TaskMain.class);
                startActivity(intent);
            }
        };
        zad.setOnClickListener(zadanie);

        View.OnClickListener set = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Settings.class);
                startActivity(intent);
            }
        };
        setting.setOnClickListener(set);

        View.OnClickListener firstpara = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,RaspPlus.class);
                startActivity(intent);
            }
        };
        para1.setOnClickListener(firstpara);

        View.OnClickListener secondpara = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,RaspPlus.class);
                startActivity(intent);
            }
        };
        para2.setOnClickListener(secondpara);

        View.OnClickListener thirdpara = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,RaspPlus.class);
                startActivity(intent);
            }
        };
        para3.setOnClickListener(thirdpara);

        View.OnClickListener fourthpara = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,RaspPlus.class);
                startActivity(intent);
            }
        };
        para4.setOnClickListener(fourthpara);
    }
    @Override
    protected void onStart(){
        super.onStart();

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
                }
                break;
        }
        return false;
    }
}