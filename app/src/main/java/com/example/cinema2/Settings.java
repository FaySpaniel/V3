package com.example.cinema2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class Settings extends AppCompatActivity {

    ImageButton rasp;
    ImageButton zad;
    ImageButton setting;
    ImageButton back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        rasp = (ImageButton) findViewById(R.id.Raspisanie);
        zad = (ImageButton) findViewById(R.id.Zadanie);
        setting = (ImageButton) findViewById(R.id.Setting);
        back = (ImageButton) findViewById(R.id.Back);
        Spinner typeweek = findViewById(R.id.spinner);

        typeweek.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent,
                                       View itemSelected, int selectedItemPosition, long selectedId) {

                SaveRead.with(Settings.this).write("weektype", selectedItemPosition);
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        rasp.setOnClickListener
                (view -> {
                    Intent intent = new Intent(Settings.this, MainActivity.class);
                    startActivity(intent);
                });

        zad.setOnClickListener
                (view -> {
                    Intent intent = new Intent(Settings.this, TaskMain.class);
                    startActivity(intent);
                });

        setting.setOnClickListener
                (view -> {
                    Intent intent = new Intent(Settings.this, Settings.class);
                    startActivity(intent);
                });

        back.setOnClickListener
                (view -> {
                    finish();
                    overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
                });

        SaveRead with = SaveRead.with(this);
        if (with.hasKey("weektype"))
            typeweek.setSelection(with.readInt("weektype"));
    }
}