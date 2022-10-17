package com.example.cinema2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ColorForLayout extends AppCompatActivity {
    float x1, x2, y1, y2;
    Button abrikos, aquamarine, blue, bheaven, borange, bpink, brown, chertopolox, dpink, dblue, ddark, dgreen, flower, glinomes, gray, gtree, grass, hacki, latoune, lbrown, maline, mandrine, mint, niagara, pinkq, siena, sparge, pinka, blackred, whitegreen, briblue, dpurple, heaven, opink, tomato, white;
    ImageButton rasp;
    ImageButton zad;
    ImageButton setting;
    private int id;

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
                    Intent intent = new Intent(ColorForLayout.this, MainActivity.class);
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


        id = getIntent().getIntExtra("id", -1);
        SaveRead with = SaveRead.with(this);
        String name = String.valueOf(id);
        IColor load;
        if (with.hasKey(name)) {
            String s = with.readString(name);
            if (id >= 51 && id <= 55)
                load = TaskInfo.load(s);
            else
                load = ParaInfo.load(s);

        } else {
            if (id >= 51 && id <= 55)
                load = new TaskInfo();

            else
                load = new ParaInfo();
            load.setid(id);
        }


        abrikos.setOnClickListener(view -> {
            load.setcolor(getResources().getString(R.color.Abrikos));
            String save = load.save();
            with.write(name, save);
            back(name);
            Toast toast = Toast.makeText(getApplicationContext(),"Выбран абрикосовый цвет",Toast.LENGTH_SHORT);
            toast.show();
        });

        aquamarine.setOnClickListener(view -> {
            load.setcolor(getResources().getString(R.color.Aquamarine));
            String save = load.save();
            with.write(name, save);
            back(name);
            Toast toast = Toast.makeText(getApplicationContext(),"Выбран аквамариновый цвет",Toast.LENGTH_SHORT);
            toast.show();
        });

        blue.setOnClickListener(view -> {
            load.setcolor(getResources().getString(R.color.Blue));
            String save = load.save();
            with.write(name, save);
            back(name);
            Toast toast = Toast.makeText(getApplicationContext(),"Выбран голубой цвет",Toast.LENGTH_SHORT);
            toast.show();
        });

        bheaven.setOnClickListener(view -> {
            load.setcolor(getResources().getString(R.color.Bright_Heaven));
            String save = load.save();
            with.write(name, save);
            back(name);
            Toast toast = Toast.makeText(getApplicationContext(),"Выбран небесный цвет",Toast.LENGTH_SHORT);
            toast.show();
        });

        borange.setOnClickListener(view -> {
            load.setcolor(getResources().getString(R.color.Bright_Orange));
            String save = load.save();
            with.write(name, save);
            back(name);
            Toast toast = Toast.makeText(getApplicationContext(),"Выбран светло-оранжевый цвет",Toast.LENGTH_SHORT);
            toast.show();
        });

        bpink.setOnClickListener(view -> {
            load.setcolor(getResources().getString(R.color.Bright_Pink));
            String save = load.save();
            with.write(name, save);
            back(name);
            Toast toast = Toast.makeText(getApplicationContext(),"Выбран светло-розовый цвет",Toast.LENGTH_SHORT);
            toast.show();
        });

        briblue.setOnClickListener(view -> {
            load.setcolor(getResources().getString(R.color.Briliant_blue));
            String save = load.save();
            with.write(name, save);
            back(name);
            Toast toast = Toast.makeText(getApplicationContext(),"Выбран бриллиантово-синий цвет",Toast.LENGTH_SHORT);
            toast.show();
        });

        brown.setOnClickListener(view -> {
            load.setcolor(getResources().getString(R.color.Brown));
            String save = load.save();
            with.write(name, save);
            back(name);
            Toast toast = Toast.makeText(getApplicationContext(),"Выбран цвет натуральная умбра",Toast.LENGTH_SHORT);
            toast.show();
        });

        dblue.setOnClickListener(view -> {
            load.setcolor(getResources().getString(R.color.Deep_Blue));
            String save = load.save();
            with.write(name, save);
            back(name);
            Toast toast = Toast.makeText(getApplicationContext(),"Выбран сапфировый цвет",Toast.LENGTH_SHORT);
            toast.show();
        });

        dgreen.setOnClickListener(view -> {
            load.setcolor(getResources().getString(R.color.Deep_Green));
            String save = load.save();
            with.write(name, save);
            back(name);
            Toast toast = Toast.makeText(getApplicationContext(),"Выбран тёмно-зелёный цвет",Toast.LENGTH_SHORT);
            toast.show();
        });

        chertopolox.setOnClickListener(view -> {
            load.setcolor(getResources().getString(R.color.Chertopolox));
            String save = load.save();
            with.write(name, save);
            back(name);
            Toast toast = Toast.makeText(getApplicationContext(),"Выбран цвет чертополоха",Toast.LENGTH_SHORT);
            toast.show();
        });

        dpurple.setOnClickListener(view -> {
            load.setcolor(getResources().getString(R.color.Deep_Purple));
            String save = load.save();
            with.write(name, save);
            back(name);
            Toast toast = Toast.makeText(getApplicationContext(),"Выбран тёмно-фиолетовый цвет",Toast.LENGTH_SHORT);
            toast.show();
        });

        ddark.setOnClickListener(view -> {
            load.setcolor(getResources().getString(R.color.Deep_Dark));
            String save = load.save();
            with.write(name, save);
            back(name);
            Toast toast = Toast.makeText(getApplicationContext(),"Выбран тёмно-синий цвет",Toast.LENGTH_SHORT);
            toast.show();
        });

        dpink.setOnClickListener(view -> {
            load.setcolor(getResources().getString(R.color.Dark_Pink));
            String save = load.save();
            with.write(name, save);
            Toast toast = Toast.makeText(getApplicationContext(),"Выбран розовато-лиловый цвет",Toast.LENGTH_SHORT);
            toast.show();
        });

        glinomes.setOnClickListener(view -> {
            load.setcolor(getResources().getString(R.color.Glinomes));
            String save = load.save();
            with.write(name, save);
            back(name);
            Toast toast = Toast.makeText(getApplicationContext(),"Выбран цвет извстковой глины",Toast.LENGTH_SHORT);
            toast.show();
        });

        gtree.setOnClickListener(view -> {
            load.setcolor(getResources().getString(R.color.Green_Tree));
            String save = load.save();
            with.write(name, save);
            back(name);
            Toast toast = Toast.makeText(getApplicationContext(),"Выбран цвет зелёной сосны",Toast.LENGTH_SHORT);
            toast.show();
        });

        gray.setOnClickListener(view -> {
            load.setcolor(getResources().getString(R.color.Gray));
            String save = load.save();
            with.write(name, save);
            back(name);
            Toast toast = Toast.makeText(getApplicationContext(),"Выбран цвет защитный хаки",Toast.LENGTH_SHORT);
            toast.show();
        });

        grass.setOnClickListener(view -> {
            load.setcolor(getResources().getString(R.color.Grass));
            String save = load.save();
            with.write(name, save);
            back(name);
            Toast toast = Toast.makeText(getApplicationContext(),"Выбран травяной цвет",Toast.LENGTH_SHORT);
            toast.show();
        });

        hacki.setOnClickListener(view -> {
            load.setcolor(getResources().getString(R.color.Hacki));
            String save = load.save();
            with.write(name, save);
            back(name);
            Toast toast = Toast.makeText(getApplicationContext(),"Выбран цвет хаки",Toast.LENGTH_SHORT);
            toast.show();
        });

        flower.setOnClickListener(view -> {
            load.setcolor(getResources().getString(R.color.Flower));
            String save = load.save();
            with.write(name, save);
            back(name);
            Toast toast = Toast.makeText(getApplicationContext(),"Выбран цвет весенний бутон",Toast.LENGTH_SHORT);
            toast.show();
        });

        heaven.setOnClickListener(view -> {
            load.setcolor(getResources().getString(R.color.Heaven));
            String save = load.save();
            with.write(name, save);
            back(name);
            Toast toast = Toast.makeText(getApplicationContext(),"Выбран васильковый цвет",Toast.LENGTH_SHORT);
            toast.show();
        });

        niagara.setOnClickListener(view -> {
            load.setcolor(getResources().getString(R.color.Niagara));
            String save = load.save();
            with.write(name, save);
            back(name);
            Toast toast = Toast.makeText(getApplicationContext(),"Выбран цвет ниагара",Toast.LENGTH_SHORT);
            toast.show();
        });

        latoune.setOnClickListener(view -> {
            load.setcolor(getResources().getString(R.color.Latoune));
            String save = load.save();
            with.write(name, save);
            back(name);
            Toast toast = Toast.makeText(getApplicationContext(),"Выбран цвет античная латунь",Toast.LENGTH_SHORT);
            toast.show();
        });

        mandrine.setOnClickListener(view -> {
            load.setcolor(getResources().getString(R.color.Mandarine));
            String save = load.save();
            with.write(name, save);
            back(name);
            Toast toast = Toast.makeText(getApplicationContext(),"Выбран цвет тусклый мандарин",Toast.LENGTH_SHORT);
            toast.show();
        });

        opink.setOnClickListener(view -> {
            load.setcolor(getResources().getString(R.color.Oper_Pink));
            String save = load.save();
            with.write(name, save);
            back(name);
            Toast toast = Toast.makeText(getApplicationContext(),"Выбран цвет розовато-оперный",Toast.LENGTH_SHORT);
            toast.show();
        });

        mint.setOnClickListener(view -> {
            load.setcolor(getResources().getString(R.color.Mint));
            String save = load.save();
            with.write(name, save);
            back(name);
            Toast toast = Toast.makeText(getApplicationContext(),"Выбран мятный цвет",Toast.LENGTH_SHORT);
            toast.show();
        });

        maline.setOnClickListener(view -> {
            load.setcolor(getResources().getString(R.color.Maline));
            String save = load.save();
            with.write(name, save);
            back(name);
            Toast toast = Toast.makeText(getApplicationContext(),"Выбран серобуромалиновый цвет",Toast.LENGTH_SHORT);
            toast.show();
        });

        lbrown.setOnClickListener(view -> {
            load.setcolor(getResources().getString(R.color.Light_Brown));
            String save = load.save();
            with.write(name, save);
            back(name);
            Toast toast = Toast.makeText(getApplicationContext(),"Выбран светло-коричневый цвет",Toast.LENGTH_SHORT);
            toast.show();
        });

        pinka.setOnClickListener(view -> {
            load.setcolor(getResources().getString(R.color.Pink_antic));
            String save = load.save();
            with.write(name, save);
            back(name);
            Toast toast = Toast.makeText(getApplicationContext(),"Выбран цвет розовый антик",Toast.LENGTH_SHORT);
            toast.show();
        });

        pinkq.setOnClickListener(view -> {
            load.setcolor(getResources().getString(R.color.Pink_Quartz));
            String save = load.save();
            with.write(name, save);
            back(name);
            Toast toast = Toast.makeText(getApplicationContext(),"Выбран цвет розовый кварц",Toast.LENGTH_SHORT);
            toast.show();
        });

        whitegreen.setOnClickListener(view -> {
            load.setcolor(getResources().getString(R.color.White_Green));
            String save = load.save();
            with.write(name, save);
            back(name);
            Toast toast = Toast.makeText(getApplicationContext(),"Выбран бело-зелёный цвет",Toast.LENGTH_SHORT);
            toast.show();
        });

        sparge.setOnClickListener(view -> {
            load.setcolor(getResources().getString(R.color.Sparge));
            String save = load.save();
            with.write(name, save);
            back(name);
            Toast toast = Toast.makeText(getApplicationContext(),"Выбран цвет спаржа",Toast.LENGTH_SHORT);
            toast.show();
        });

        tomato.setOnClickListener(view -> {
            load.setcolor(getResources().getString(R.color.Tomato));
            String save = load.save();
            with.write(name, save);
            back(name);
            Toast toast = Toast.makeText(getApplicationContext(),"Выбран томатно-красный цвет",Toast.LENGTH_SHORT);
            toast.show();
        });

        siena.setOnClickListener(view -> {
            load.setcolor(getResources().getString(R.color.Siena));
            String save = load.save();
            with.write(name, save);
            back(name);
            Toast toast = Toast.makeText(getApplicationContext(),"Выбран цвет сиена",Toast.LENGTH_SHORT);
            toast.show();
        });

        blackred.setOnClickListener(view -> {
            load.setcolor(getResources().getString(R.color.Black_Red));
            String save = load.save();
            with.write(name, save);
            back(name);
            Toast toast = Toast.makeText(getApplicationContext(),"Выбран тёмно-красный цвет",Toast.LENGTH_SHORT);
            toast.show();
        });

        white.setOnClickListener(view -> {
            load.setcolor(getResources().getString(R.color.white));
            String save = load.save();
            with.write(name, save);
            back(name);
            Toast toast = Toast.makeText(getApplicationContext(),"Выбран белый цвет",Toast.LENGTH_SHORT);
            toast.show();
        });


    }

    public void back(String color) {
        Intent intent;
        if (id>=51&& id<=55)
            intent= new Intent(this, Tasks.class);
        else
            intent= new Intent(this, RaspPlus.class);
        intent.putExtra("id", color);
        startActivity(intent);
        finish();
        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
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
                    overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
                }
                break;
        }
        return false;
    }
}