package com.example.cinema2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Spinner;

public class RaspPlus extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rasp_plus);

        Spinner spinner = findViewById(R.id.spinner);
        int selected = spinner.getSelectedItemPosition();
    }
}