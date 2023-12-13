package com.example.sugandilak;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class jeugo1 extends AppCompatActivity {
    Button btn_respuesta2, btn_respuesta1, btn_respuesta3;
    ImageView id_img;
    int i = 0;
    ArrayList<Drawable> listimg = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_jeugo1);
    //    id_img = findViewById(R.id.id_img);
        btn_respuesta1 = findViewById(R.id.btn_respuesta1);
        btn_respuesta2 = findViewById(R.id.btn_respuesta2);
        btn_respuesta3 = findViewById(R.id.btn_respuesta3);
        if (i == 0) {
            //  Drawable img=getDrawable(R.drawable.func1);
            Drawable img2 = getDrawable(R.drawable.func2);
            Drawable img3 = getDrawable(R.drawable.func3);
            Drawable img4 = getDrawable(R.drawable.func4);
            //listimg.add(img);
            listimg.add(img2);
            listimg.add(img3);
            listimg.add(img4);
        }


        btn_respuesta1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //correcta
                Toast toast1 =
                        Toast.makeText(getApplicationContext(),
                                "Tu opcion esta correcta", Toast.LENGTH_SHORT);

                toast1.show();


                if (i == listimg.size() - 1) {
                    Intent intent = new Intent(jeugo1.this, MainActivity.class);
                    startActivity(intent);
                }
                //nota de unax: linea 58 genera error al jugar el mismo juego 2 veces
                id_img.setBackground(listimg.get(i));
                System.out.println(listimg.size());
                i++;
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