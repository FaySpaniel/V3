package com.example.cinema2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class ColorForLayout extends AppCompatActivity {
    float x1, x2, y1, y2;
    Button abrikos,aquamarine,blue,bheaven,borange,bpink,brown,chertopolox,dpink,dblue,ddark,dgreen,flower,glinomes,gray,gtree,grass,hacki,latoune,lbrown,maline,mandrine,mint,niagara,pinkq,siena,sparge,pinka,blackred,whitegreen,briblue,dpurple,heaven,opink,tomato,white;
    ConstraintLayout aboba;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_for_layout);

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
        aboba = (ConstraintLayout) findViewById(R.id.constraintLayout3);


        View.OnClickListener Abrikos = new View.OnClickListener() {

            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
               // SaveRead.with(ColorForLayout.this).readInt("1 para mon",R.id.constraintLayout3);
                aboba.setBackgroundColor(R.color.Abrikos);
            }
        };
        abrikos.setOnClickListener(Abrikos);

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
                    Intent i = new Intent(ColorForLayout.this, RaspPlus.class);
                    startActivity(i);
                }
                break;
        }
        return false;
    }
}