package com.example.sugandilak;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.sugandilak.EntidadesDB.Database;
import com.example.sugandilak.EntidadesDB.Explicacion;
import com.example.sugandilak.EntidadesDB.ExplicacionDao;
import com.example.sugandilak.EntidadesDB.Pantalla;
import com.example.sugandilak.EntidadesDB.PantallaDao;


public class MainActivity extends AppCompatActivity {

    private static Database INSTANCE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        System.out.println("Pre Dao");

        INSTANCE= Database.getInstance(this);
        ExplicacionDao ExplicacionDao = INSTANCE.ExplicacionDao();
        PantallaDao PantallaDao = INSTANCE.PantallaDao();

        System.out.println("Post Dao");

        Explicacion explicacion1 = new Explicacion(1, "AAA", "Placeholder1");
        Explicacion explicacion2 = new Explicacion(2, "BBB", "Placeholder2");
        Pantalla pantalla1 = new Pantalla(1, "srcDeImagen1");
        Pantalla pantalla2= new Pantalla(2, "srcDeImagen2");

        System.out.println("Post Explicacion");

        ExplicacionDao.insert(explicacion1);
        ExplicacionDao.insert(explicacion2);
        PantallaDao.insert(pantalla1);
        PantallaDao.insert(pantalla2);


        System.out.println("Post insert");
    }
}