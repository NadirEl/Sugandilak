package com.example.sugandilak;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.wajahatkarim3.easyflipview.EasyFlipView;

public class Juego_Parejas_Cartas extends AppCompatActivity {

    EasyFlipView easy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego_parejas_cartas);

        easy = findViewById(R.id.cambiar);
        easy.setToHorizontalType();
        easy.setOnFlipListener(new EasyFlipView.OnFlipAnimationListener() {
            @Override
            public void onViewFlipCompleted(EasyFlipView easyFlipView, EasyFlipView.FlipState newCurrentSide) {


            }
        });

    }
}