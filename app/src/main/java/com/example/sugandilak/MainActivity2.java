package com.example.sugandilak;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    TextView id_explicaciones;
    ImageView id_gif;
    Button btn_iniciar;
    Handler handler = new Handler();
    int currentIndex = 0;

    String textoOriginal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
     /*   MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.eliza1);

        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                int duration = mp.getDuration();
                int durationInSeconds = duration / 1000;

                System.out.println("Duración del audio: " + durationInSeconds + " segundos");
                Log.d("MediaPlayer", "Duración del audio: " + durationInSeconds + " segundos");
            }
        });

        mediaPlayer.start();

*/
        id_explicaciones = findViewById(R.id.id_explicaciones);
        btn_iniciar = findViewById(R.id.btn_iniciar);
        id_gif = findViewById(R.id.id_gif);
        // Guarda el texto original;

        // Oculta el botón al inicio

        btn_iniciar.setVisibility(View.GONE);


        // Inicia el proceso de mostrar el texto letra por letra
        String valor = getIntent().getExtras().getString("id");
        int id = Integer.valueOf(valor);
        if (id == 1) {
            textoOriginal = "Hasierako azalpena: Kaixo! Elorrioko Sortzez Garbiaren Basilika izenaz ezagutzen den monumentu historikoaren aurrean zaudete! Goazen bere historia ezagutzera!! Elorrioko ondare artistikoko monumentu aipagarriena da. Eraikin oso handia da, ia 50 metroko luzera eta 25 metroko zabalera du. Bere eraikuntzari dagokionez, oro har, hiru fase bereiz ditzakegu";
            mostrarTextoPorLetras();
        } else if (id == 2) {
            textoOriginal = "Balentin Berriotxoa 1827ko otsailaren 14an jaio egin zen, Elorrion. Gaur egungo ume guztiak bezala, eskolara joan zen, oso haur azkarra zirudien, ikasteko gogo handiak zituena. Berriotxoa txikia zenean gauza asko egin zituen, adibidez txistua jo, bere aitari aroztegian lagundu";
            mostrarTextoPorLetras();
        } else if (id == 3) {
            textoOriginal = "Kaixo! Orain Elorrioko jai tradizional bat ezagutuko dugu!! Ezagutzen dituzue Errebonbiloak? Urtero, urriko lehenengo igandean, \"Errebonbilloak\" izeneko jaia egiten da Elorrion.1571. urtean, Lepantoko batailan flota kristauak turkiarrari irabazi zion. Bataila hartan, Elorrioko gazteek parte hartu omen zuten, eta, Elorriora itzultzean, pozik jarri zirenez, zenbait tiro bota zituzten airera, berriz etxean zirela poztasunez adierazten.";
            mostrarTextoPorLetras();

        } else if (id == 4) {
            textoOriginal = "Euskal Herriko Erdi Aroko hilobi-multzo garrantzitsuena da, bai osagai kopuruagatik, bai antzina-antzinako kronologiagatik. Harrizko hogeta hiru sarkofago eta disko-formako bost hilarri dauzka; horietako batzuk, XIX. mendera arte, gertuko auzoetan zehar sakabanatuta egon ziren. Egungo antolamendua ez da jatorrizkoa";

            mostrarTextoPorLetras();
        } else if (id == 5) {
            textoOriginal = "Urkiolako parke naturalean, Anboto mendia aurkitzen dugu, Bizkaiko mendi ikusgarriena eta arriskutsuena. Anboto Bizkaiko mendi garrantzitsuenetako bat da, baina ez bakarrik bertako paisaiengatik, baita euskal mitologian duen garrantziagatik ere. Hemen agertzen da euskal mitologiako pertsonaiarik ezagunena";
            mostrarTextoPorLetras();

        }

        btn_iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String valor = getIntent().getExtras().getString("id");
                int id = Integer.valueOf(valor);
                if (id == 1) {
                    Intent intent = new Intent(MainActivity2.this, jeugo1.class);
                    startActivity(intent);
                } else if (id == 2) {
                    Intent intent = new Intent(MainActivity2.this, Pantalla2VidaDeSanValentin.class);
                    startActivity(intent);
                } else if (id == 3) {
                    Intent intent = new Intent(MainActivity2.this, Pantalla3_SopadeLetras.class);
                    startActivity(intent);

                } else if (id == 4) {
                    Intent intent = new Intent(MainActivity2.this, Juego_Parejas_Cartas.class);
                    startActivity(intent);

                } else if (id == 5) {
                    Intent intent = new Intent(MainActivity2.this, Laberinto.class);
                    startActivity(intent);

                }

            }
        });
    }


    private void mostrarTextoPorLetras() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Verifica si hay más letras para mostrar
                if (currentIndex < textoOriginal.length()) {
                    // Obtén la letra actual y agrégala al texto
                    String letraActual = String.valueOf(textoOriginal.charAt(currentIndex));
                    id_explicaciones.setText(id_explicaciones.getText() + letraActual);

                    // Incrementa el índice para la próxima letra
                    currentIndex++;

                    // Programa la próxima actualización en medio segundo
                    handler.postDelayed(this, 10);
                } else {
                    // Cuando se ha mostrado todo el texto, muestra el botón
                    btn_iniciar.setVisibility(View.VISIBLE);
                    //     id_gif.setImageResource(0);
                }
            }
        }, 500);
    }
}
