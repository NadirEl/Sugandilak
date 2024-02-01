package com.example.sugandilak;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.sugandilak.EntidadesDB.ElorrioDatabase;
import com.example.sugandilak.EntidadesDB.Ubicacion;

import java.util.ArrayList;
import java.util.List;

public class ActivityBBDD extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bbdd);




        Ubicacion u1 = new Ubicacion(1, "BASÍLICA DE LA PURA CREACIÓN", 43.1302778, -2.5425);
        Ubicacion u2 = new Ubicacion(2, "SAN VALENTÍN BERRIOTXOA", 43.12994, -2.5423);
        Ubicacion u3 = new Ubicacion(3, "REBOMBILLOAS", 43.13019, -2.54200);
        Ubicacion u4 = new Ubicacion(4, "NECRÓPOLIS DE ARGIÑETA", 43.14, -2.536);
        Ubicacion u5 = new Ubicacion(5, "ANBOTOKO MARI", 43.1397, -2.53545);





    }
}