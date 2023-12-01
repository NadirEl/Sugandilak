package com.example.sugandilak;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.sugandilak.EntidadesDB.JuegoDao;
import com.example.sugandilak.EntidadesDB.Juego;
import com.example.sugandilak.EntidadesDB.JuegoDatabase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    private static JuegoDatabase INSTANCE;
    Button id_juego1;
    Button id_juego2;
    Button id_juego3;
    Button id_juego4;
    Button id_juego5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        id_juego1 = findViewById(R.id.id_juego1);
        id_juego2 = findViewById(R.id.id_juego2);
        id_juego3 = findViewById(R.id.id_juego3);
        id_juego4 = findViewById(R.id.id_juego4);
        id_juego5 = findViewById(R.id.id_juego5);
        id_juego1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);


                intent.putExtra("id", "1");

                id_juego1.setBackgroundResource(R.color.green);
                startActivity(intent);

            }
        });
        id_juego2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);


                intent.putExtra("id", "2");
                startActivity(intent);
            }
        });
        id_juego3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);


                intent.putExtra("id", "3");
                startActivity(intent);

            }
        });
        id_juego4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);


                intent.putExtra("id", "4");
                startActivity(intent);

            }
        });
        id_juego5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);


                intent.putExtra("id", "5");
                startActivity(intent);

            }
        });





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