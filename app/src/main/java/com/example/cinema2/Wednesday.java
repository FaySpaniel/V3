package com.example.cinema2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.TextView;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class Wednesday extends AppCompatActivity {

    float x1,x2,y1,y2;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wednesday);

        textView = findViewById(R.id.textView23);

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        calendar.add(Calendar.DATE,2);
        String dateTime = simpleDateFormat.format(calendar.getTime());
        textView.setText(dateTime);
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

                }
                else {
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