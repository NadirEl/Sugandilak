package com.example.sugandilak;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class jeugo1 extends AppCompatActivity {
    Button btn_respuesta2, btn_respuesta1, btn_respuesta3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jeugo1);
        btn_respuesta1 = findViewById(R.id.btn_respuesta1);
        btn_respuesta2 = findViewById(R.id.btn_respuesta2);
        btn_respuesta3 = findViewById(R.id.btn_respuesta3);
        btn_respuesta1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//correcta
                Toast toast1 =
                        Toast.makeText(getApplicationContext(),
                                "Tu opcion esta correcta", Toast.LENGTH_SHORT);

                toast1.show();
                Intent intent = new Intent(jeugo1.this, MainActivity.class);
                startActivity(intent);
            }
        });
        btn_respuesta2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Toast toast1 =
                        Toast.makeText(getApplicationContext(),
                                "Has eligedo la opcion mal", Toast.LENGTH_SHORT);

                toast1.show();
            }
        });
        btn_respuesta3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast toast1 =
                        Toast.makeText(getApplicationContext(),
                                "Has eligedo la opcion mal", Toast.LENGTH_SHORT);

                toast1.show();

            }
        });
    }
}