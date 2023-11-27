package com.example.sugandilak;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Pantalla3_SopadeLetras extends AppCompatActivity implements View.OnClickListener{

    TextView uno_uno, uno_dos, uno_tres, uno_cuatro, uno_cinco, uno_seis, uno_siete, uno_ocho, uno_nueve, uno_diez, uno_once;
    TextView dos_uno, dos_dos, dos_tres, dos_cuatro, dos_cinco, dos_seis, dos_siete, dos_ocho, dos_nueve, dos_diez, dos_once;
    TextView tres_uno, tres_dos, tres_tres, tres_cuatro, tres_cinco, tres_seis, tres_siete, tres_ocho, tres_nueve, tres_diez, tres_once;
    TextView cuatro_uno, cuatro_dos, cuatro_tres, cuatro_cuatro, cuatro_cinco, cuatro_seis, cuatro_siete, cuatro_ocho, cuatro_nueve, cuatro_diez, cuatro_once;
    TextView cinco_uno, cinco_dos, cinco_tres, cinco_cuatro, cinco_cinco, cinco_seis, cinco_siete, cinco_ocho, cinco_nueve, cinco_diez, cinco_once;
    TextView seis_uno, seis_dos, seis_tres, seis_cuatro, seis_cinco, seis_seis, seis_siete, seis_ocho, seis_nueve, seis_diez, seis_once;
    TextView siete_uno, siete_dos, siete_tres, siete_cuatro, siete_cinco, siete_seis, siete_siete, siete_ocho, siete_nueve, siete_diez, siete_once;
    TextView ocho_uno, ocho_dos, ocho_tres, ocho_cuatro, ocho_cinco, ocho_seis, ocho_siete, ocho_ocho, ocho_nueve, ocho_diez, ocho_once;
    TextView nueve_uno, nueve_dos, nueve_tres, nueve_cuatro, nueve_cinco, nueve_seis, nueve_siete, nueve_ocho, nueve_nueve, nueve_diez, nueve_once;
    TextView diez_uno, diez_dos, diez_tres, diez_cuatro, diez_cinco, diez_seis, diez_siete, diez_ocho, diez_nueve, diez_diez, diez_once;
    TextView once_uno, once_dos, once_tres, once_cuatro, once_cinco, once_seis, once_siete, once_ocho, once_nueve, once_diez, once_once;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla3_sopade_letras);


    }

    void asignarId (TextView tv, int id){
        tv = findViewById(id);
        tv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }
}