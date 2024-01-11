package com.example.sugandilak;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class jeugo1 extends AppCompatActivity {
    Button btn_respuesta2, btn_respuesta1, btn_respuesta3;
    ImageView id_img;
    TextView id_explicacio;
    String texto;
    int i = 0;
    ArrayList<Drawable> listimg = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_jeugo1);
        id_explicacio= findViewById(R.id.id_explicacio);
        id_img = findViewById(R.id.imageView);
        btn_respuesta1 = findViewById(R.id.btn_respuesta1);
        btn_respuesta2 = findViewById(R.id.btn_respuesta2);
        btn_respuesta3 = findViewById(R.id.btn_respuesta3);
        if (i == 0) {
            Drawable img2 = getDrawable(R.drawable.func2);
            Drawable img3 = getDrawable(R.drawable.func3);
            Drawable img4 = getDrawable(R.drawable.func4);
            listimg.add(img2);
            listimg.add(img3);
            listimg.add(img4);
        }

        btn_respuesta1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Tu opción es correcta", Toast.LENGTH_SHORT).show();

                if (i == listimg.size()) {
                    Intent intent = new Intent(jeugo1.this, MainActivity.class);
                    intent.putExtra("id", 1);
                    startActivity(intent);
                } else {
                    if (id_img != null) {
                        id_img.setBackground(listimg.get(i));
                        i++;
                        if (id_img.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.func2).getConstantState())) {
                            texto = "Lehendabizi, etapa gotikoa daukagu, 1464tik 1530ra doana. Historiako etapa honetan basilika eraikitzeko lehenengo urratsak eman zituzten. Epealdi honetan aurreko portada eta atzeko portada egin zituzten. Basilikari begira, identifikatu ditzakezue? \n";
                            id_explicacio.setText(texto);
                        } else if (id_img.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.func4).getConstantState())) {
                            texto = "Horrez gain, plazatik ikusten den arkupea ere epealdi honetan egin zen. Ikusten duzue zelako forma duen? \n";
                            id_explicacio.setText(texto);
                        }else if (id_img.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.func3).getConstantState())) {
                            texto = "Lehendabizi, etapa gotikoa daukagu, 1464tik 1530ra doana. Historiako etapa honetan basilika eraikitzeko lehenengo urratsak eman zituzten. Epealdi honetan aurreko portada eta atzeko portada egin zituzten. Basilikari begira, identifikatu ditzakezue? \n";
                            id_explicacio.setText(texto);
                        }
                    }
                }
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