package com.example.cinema2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class ColorForLayout extends AppCompatActivity {
    float x1, x2, y1, y2;
    Button abrikos, aquamarine, blue, bheaven, borange, bpink, brown, chertopolox, dpink, dblue, ddark, dgreen, flower, glinomes, gray, gtree, grass, hacki, latoune, lbrown, maline, mandrine, mint, niagara, pinkq, siena, sparge, pinka, blackred, whitegreen, briblue, dpurple, heaven, opink, tomato, white;
    ImageButton rasp;
    ImageButton zad;
    ImageButton setting;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_for_layout);

        rasp = (ImageButton) findViewById(R.id.Raspisanie);
        zad = (ImageButton) findViewById(R.id.Zadanie);
        setting = (ImageButton) findViewById(R.id.Setting);
        abrikos = (Button) findViewById(R.id.button30);
        aquamarine = (Button) findViewById(R.id.button31);
        blue = (Button) findViewById(R.id.button32);
        bheaven = (Button) findViewById(R.id.button33);
        borange = (Button) findViewById(R.id.button34);
        bpink = (Button) findViewById(R.id.button35);
        briblue = (Button) findViewById(R.id.button36);
        brown = (Button) findViewById(R.id.button37);
        dblue = (Button) findViewById(R.id.button38);
        dgreen = (Button) findViewById(R.id.button39);
        chertopolox = (Button) findViewById(R.id.button40);
        dpurple = (Button) findViewById(R.id.button41);
        ddark = (Button) findViewById(R.id.button42);
        dpink = (Button) findViewById(R.id.button43);
        glinomes = (Button) findViewById(R.id.button44);
        gtree = (Button) findViewById(R.id.button45);
        gray = (Button) findViewById(R.id.button46);
        grass = (Button) findViewById(R.id.button47);
        hacki = (Button) findViewById(R.id.button48);
        flower = (Button) findViewById(R.id.button49);
        heaven = (Button) findViewById(R.id.button50);
        niagara = (Button) findViewById(R.id.button51);
        latoune = (Button) findViewById(R.id.button52);
        mandrine = (Button) findViewById(R.id.button53);
        opink = (Button) findViewById(R.id.button54);
        mint = (Button) findViewById(R.id.button55);
        maline = (Button) findViewById(R.id.button56);
        lbrown = (Button) findViewById(R.id.button57);
        pinka = (Button) findViewById(R.id.button58);
        pinkq = (Button) findViewById(R.id.button59);
        whitegreen = (Button) findViewById(R.id.button60);
        sparge = (Button) findViewById(R.id.button61);
        tomato = (Button) findViewById(R.id.button62);
        siena = (Button) findViewById(R.id.button63);
        blackred = (Button) findViewById(R.id.button64);
        white = (Button) findViewById(R.id.button65);

        rasp.setOnClickListener
                (view -> {
                    Intent intent = new Intent(ColorForLayout.this,MainActivity.class);
                    startActivity(intent);
                });

        zad.setOnClickListener
                (view -> {
                    Intent intent = new Intent(ColorForLayout.this, TaskMain.class);
                    startActivity(intent);
                });

        setting.setOnClickListener
                (view -> {
                    Intent intent = new Intent(ColorForLayout.this, Settings.class);
                    startActivity(intent);
                });


        int id = getIntent().getIntExtra("id", -1);
        SaveRead with = SaveRead.with(this);
        String name = String.valueOf(id);
        ParaInfo load;
        if (with.hasKey(name)) {
            String s = with.readString(name);
            load = ParaInfo.load(s);

        } else {
            load = new ParaInfo();
            load.id = id;
        }


        abrikos.setOnClickListener(view -> {
            load.color = getResources().getString(R.color.Abrikos);
            String save = load.save();
            with.write(name, save);
            back(name);
        });

        aquamarine.setOnClickListener(view -> {
            load.color = getResources().getString(R.color.Aquamarine);
            String save = load.save();
            with.write(name, save);
            back(name);
        });

        blue.setOnClickListener(view -> {
            load.color = getResources().getString(R.color.Blue);
            String save = load.save();
            with.write(name, save);
            back(name);
        });

        bheaven.setOnClickListener(view -> {
            load.color = getResources().getString(R.color.Bright_Heaven);
            String save = load.save();
            with.write(name, save);
            back(name);
        });

        borange.setOnClickListener(view -> {
            load.color = getResources().getString(R.color.Bright_Orange);
            String save = load.save();
            with.write(name, save);
            back(name);
        });

        bpink.setOnClickListener(view -> {
            load.color = getResources().getString(R.color.Bright_Orange);
            String save = load.save();
            with.write(name, save);
            back(name);
        });

        briblue.setOnClickListener(view -> {
            load.color = getResources().getString(R.color.Briliant_blue);
            String save = load.save();
            with.write(name, save);
            back(name);
        });

        brown.setOnClickListener(view -> {
            load.color = getResources().getString(R.color.Brown);
            String save = load.save();
            with.write(name, save);
            back(name);
        });

        dblue.setOnClickListener(view -> {
            load.color = getResources().getString(R.color.Deep_Blue);
            String save = load.save();
            with.write(name, save);
            back(name);
        });

        dgreen.setOnClickListener(view -> {
            load.color = getResources().getString(R.color.Deep_Green);
            String save = load.save();
            with.write(name, save);
            back(name);
        });

        chertopolox.setOnClickListener(view -> {
            load.color = getResources().getString(R.color.Chertopolox);
            String save = load.save();
            with.write(name, save);
            back(name);
        });

        dpurple.setOnClickListener(view -> {
            load.color = getResources().getString(R.color.Deep_Purple);
            String save = load.save();
            with.write(name, save);
            back(name);
        });

        ddark.setOnClickListener(view -> {
            load.color = getResources().getString(R.color.Deep_Dark);
            String save = load.save();
            with.write(name, save);
            back(name);
        });

        dpink.setOnClickListener(view -> {
            load.color = getResources().getString(R.color.Dark_Pink);
            String save = load.save();
            with.write(name, save);
        });

        glinomes.setOnClickListener(view -> {
            load.color = getResources().getString(R.color.Glinomes);
            String save = load.save();
            with.write(name, save);
            back(name);
        });

        gtree.setOnClickListener(view -> {
            load.color = getResources().getString(R.color.Green_Tree);
            String save = load.save();
            with.write(name, save);
            back(name);
        });

        gray.setOnClickListener(view -> {
            load.color = getResources().getString(R.color.Gray);
            String save = load.save();
            with.write(name, save);
            back(name);
        });

        grass.setOnClickListener(view -> {
            load.color = getResources().getString(R.color.Grass);
            String save = load.save();
            with.write(name, save);
            back(name);
        });

        hacki.setOnClickListener(view -> {
            load.color = getResources().getString(R.color.Hacki);
            String save = load.save();
            with.write(name, save);
            back(name);
        });

        flower.setOnClickListener(view -> {
            load.color = getResources().getString(R.color.Flower);
            String save = load.save();
            with.write(name, save);
            back(name);
        });

        heaven.setOnClickListener(view -> {
            load.color = getResources().getString(R.color.Heaven);
            String save = load.save();
            with.write(name, save);
            back(name);
        });

        niagara.setOnClickListener(view -> {
            load.color = getResources().getString(R.color.Niagara);
            String save = load.save();
            with.write(name, save);
            back(name);
        });

        latoune.setOnClickListener(view -> {
            load.color = getResources().getString(R.color.Latoune);
            String save = load.save();
            with.write(name, save);
            back(name);
        });

        mandrine.setOnClickListener(view -> {
            load.color = getResources().getString(R.color.Mandarine);
            String save = load.save();
            with.write(name, save);
            back(name);
        });

        opink.setOnClickListener(view -> {
            load.color = getResources().getString(R.color.Oper_Pink);
            String save = load.save();
            with.write(name, save);
            back(name);
        });

        mint.setOnClickListener(view -> {
            load.color = getResources().getString(R.color.Mint);
            String save = load.save();
            with.write(name, save);
            back(name);
        });

        maline.setOnClickListener(view -> {
            load.color = getResources().getString(R.color.Maline);
            String save = load.save();
            with.write(name, save);
            back(name);
        });

        lbrown.setOnClickListener(view -> {
            load.color = getResources().getString(R.color.Light_Brown);
            String save = load.save();
            with.write(name, save);
            back(name);
        });

        pinka.setOnClickListener(view -> {
            load.color = getResources().getString(R.color.Pink_antic);
            String save = load.save();
            with.write(name, save);
            back(name);
        });

        pinkq.setOnClickListener(view -> {
            load.color = getResources().getString(R.color.Pink_Quartz);
            String save = load.save();
            with.write(name, save);
            back(name);
        });

        whitegreen.setOnClickListener(view -> {
            load.color = getResources().getString(R.color.White_Green);
            String save = load.save();
            with.write(name, save);
            back(name);
        });

        sparge.setOnClickListener(view -> {
            load.color = getResources().getString(R.color.Sparge);
            String save = load.save();
            with.write(name, save);
            back(name);
        });

        tomato.setOnClickListener(view -> {
            load.color = getResources().getString(R.color.Tomato);
            String save = load.save();
            with.write(name, save);
            back(name);
        });

        siena.setOnClickListener(view -> {
            load.color = getResources().getString(R.color.Siena);
            String save = load.save();
            with.write(name, save);
            back(name);
        });

        blackred.setOnClickListener(view -> {
            load.color = getResources().getString(R.color.Black_Red);
            String save = load.save();
            with.write(name, save);
            back(name);
        });

        white.setOnClickListener(view -> {
            load.color = getResources().getString(R.color.white);
            String save = load.save();
            with.write(name, save);
            back(name);
        });


    }
    public void back(String color)
    {
        Intent intent = new Intent(this,RaspPlus.class);
        intent.putExtra("id",color);
        startActivity(intent);
        finish();
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
                    finish();
                }
                break;
        }
        return false;
    }
}