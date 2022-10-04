package com.example.cinema2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class RaspPlus extends AppCompatActivity {

    ImageButton rasp;
    ImageButton zad;
    ImageButton setting;
    ImageButton back;
    ImageButton trash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rasp_plus);

        rasp = (ImageButton) findViewById(R.id.Raspisanie);
        zad = (ImageButton) findViewById(R.id.Zadanie);
        setting = (ImageButton) findViewById(R.id.Setting);
        back = (ImageButton) findViewById(R.id.Back);
        trash = (ImageButton) findViewById(R.id.Trash);
        Spinner spinner = findViewById(R.id.spinner);

        int selected = spinner.getSelectedItemPosition();

        View.OnClickListener raspisanie = view -> {
            Intent intent = new Intent(RaspPlus.this, MainActivity.class);
            startActivity(intent);
        };
        rasp.setOnClickListener(raspisanie);

        View.OnClickListener zadanie = view -> {
            Intent intent = new Intent(RaspPlus.this, TaskMain.class);
            startActivity(intent);
        };
        zad.setOnClickListener(zadanie);

        View.OnClickListener set = view -> {
            Intent intent = new Intent(RaspPlus.this, Settings.class);
            startActivity(intent);
        };
        setting.setOnClickListener(set);

        View.OnClickListener tra = view -> {
            Intent intent = new Intent(RaspPlus.this, MainActivity.class);
            startActivity(intent);
        };
        trash.setOnClickListener(tra);

        View.OnClickListener bac = view -> {
            Intent intent = new Intent(RaspPlus.this, TaskMain.class);
            startActivity(intent);
        };
        back.setOnClickListener(bac);
    }
}