package com.example.cinema2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;

public class Thursday extends AppCompatActivity {

    float x1,x2,y1,y2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thursday);
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
                    Intent i = new Intent(Thursday.this, Wednesday.class);
                    startActivity(i);

                }
                else {
                    if (x2 < x1) {
                        Intent i = new Intent(Thursday.this, Friday.class);
                        startActivity(i);
                    }
                }
                break;
        }
        return false;
    }
}