package com.example.sugandilak;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.sugandilak.EntidadesDB.JuegoDao;
import com.example.sugandilak.EntidadesDB.Juego;
import com.example.sugandilak.EntidadesDB.JuegoDatabase;


public class MainActivity extends AppCompatActivity {

    private static JuegoDatabase INSTANCE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        System.out.println("Pre Dao");

        INSTANCE=JuegoDatabase.getInstance(this);
        JuegoDao dao = INSTANCE.JuegoDao();

        System.out.println("Post Dao");

        Juego juego1 = new Juego(1, "AAA", "Placeholder1");
        Juego juego2 = new Juego(2, "BBB", "Placeholder2");

        System.out.println("Post Juegos");

        dao.insert(juego1);
        dao.insert(juego2);

        System.out.println("Post insert");
    }
}