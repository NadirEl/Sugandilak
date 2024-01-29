package com.example.sugandilak;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.sugandilak.EntidadesDB.ElorrioDatabase;
import com.example.sugandilak.EntidadesDB.Ubicacion;

import java.util.ArrayList;

public class ActivityBBDD extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bbdd);

        ElorrioDatabase ddbb = ElorrioDatabase.getInstance(this);

        ddbb.ubicacionDAO().deleteAllUbicacion();


    }
}