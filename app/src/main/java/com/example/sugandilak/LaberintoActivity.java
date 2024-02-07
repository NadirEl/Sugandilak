package com.example.sugandilak;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import com.example.sugandilak.EntidadesDB.ElorrioDatabase;
import com.example.sugandilak.EntidadesDB.Pregunta;

import java.util.ArrayList;
import java.util.List;

import nl.dionsegijn.konfetti.KonfettiView;
import nl.dionsegijn.konfetti.models.Shape;
import nl.dionsegijn.konfetti.models.Size;

public class LaberintoActivity extends AppCompatActivity {

    //recoge la clase del juego del laberinto
    GameView game;
    //los botones para moverse
    Button arriba, abajo, derecha, izquierda;
    //lista de las preguntas
    List<Pregunta> preguntas = new ArrayList<>();
    //componente del confeti
    KonfettiView con;
    // numero que del camino, comprueba desde donde tiene que empezar con las preguntas
    int principio = 0;
    //numero de las casillas del camino que avanza
    int casillas = 0;
    Handler handler = new Handler();

    //base de datos
    ElorrioDatabase ddbb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_labriento);
        //instanciamos la base de datos
        ddbb = ElorrioDatabase.getInstance(this);

        game = findViewById(R.id.laberinto);
        con = findViewById(R.id.viewconfeti);
        arriba = findViewById(R.id.button2);
        abajo = findViewById(R.id.button3);
        derecha = findViewById(R.id.button4);
        izquierda = findViewById(R.id.button5);

        //llenamos el array de preguntas
        llenarArray();
        // cuando clicamos el boton de arriba
        arriba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //comprueba si hay pared en la parte de arriba
                if (!game.player.topWall) {
                    // se mueve el jugador
                    game.movePlayer(GameView.Direction.UP);
                    //comprueba si ha terminado
                    if(game.player.col == 13 && game.player.row == 11){
                        laberintoTerminado();
                    }else {
                        //si no ha terminado, suma casilla, y comprueba si hay pregunta
                        casillas++;
                        Pregunta enviar = hayPregunta();
                        if (casillas > principio && enviar!= null) {
                            if (casillas % 8 == 0) {
                                // si hay pregunta, desactivamos los botones y abrimos el fragment de la pregunta
                                arriba.setEnabled(false);
                                abajo.setEnabled(false);
                                derecha.setEnabled(false);
                                izquierda.setEnabled(false);
                                FragmentManager fragmentManager = getSupportFragmentManager();
                                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                                fragmentTransaction.add(R.id.fragment, PreguntaFragment.getInstance(enviar));
                                fragmentTransaction.commit();
                            }
                        }
                    }
                }
            }
        });
        // cuando clicamos el boton de abajo
        abajo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!game.player.bottomWall) {
                    game.movePlayer(GameView.Direction.DOWN);
                    if(game.player.col == 13 && game.player.row == 11){
                        laberintoTerminado();
                    }else {
                        casillas++;
                        Pregunta enviar = hayPregunta();
                        if (casillas > principio && enviar!= null) {
                            if (casillas % 8 == 0) {
                                arriba.setEnabled(false);
                                abajo.setEnabled(false);
                                derecha.setEnabled(false);
                                izquierda.setEnabled(false);
                                FragmentManager fragmentManager = getSupportFragmentManager();
                                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                                fragmentTransaction.add(R.id.fragment, PreguntaFragment.getInstance(enviar));
                                fragmentTransaction.commit();
                            }
                        }
                    }
                }
            }
        });
        // cuando clicamos el boton de derecha
        derecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!game.player.rightWall) {
                    game.movePlayer(GameView.Direction.RIGHT);
                    if(game.player.col == 13 && game.player.row == 11){
                        laberintoTerminado();
                    }else {
                        casillas++;
                        Pregunta enviar = hayPregunta();
                        if (casillas > principio && enviar!= null) {
                            if (casillas % 8 == 0) {
                                arriba.setEnabled(false);
                                abajo.setEnabled(false);
                                derecha.setEnabled(false);
                                izquierda.setEnabled(false);
                                FragmentManager fragmentManager = getSupportFragmentManager();
                                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                                fragmentTransaction.add(R.id.fragment, PreguntaFragment.getInstance(enviar));
                                fragmentTransaction.commit();
                            }
                        }
                    }
                }
            }
        });
        // cuando clicamos el boton de izquierda
        izquierda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!game.player.leftWall) {
                    game.movePlayer(GameView.Direction.LEFT);
                    if(game.player.col == 13 && game.player.row == 11){
                        laberintoTerminado();
                    }else {
                        casillas++;
                        Pregunta enviar = hayPregunta();
                        if (casillas > principio && enviar!= null) {
                            if (casillas % 8 == 0) {
                                arriba.setEnabled(false);
                                abajo.setEnabled(false);
                                derecha.setEnabled(false);
                                izquierda.setEnabled(false);
                                FragmentManager fragmentManager = getSupportFragmentManager();
                                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                                fragmentTransaction.add(R.id.fragment, PreguntaFragment.getInstance(enviar));
                                fragmentTransaction.commit();
                            }
                        }
                    }
                }
            }
        });


    }

    //función que llama a la base de datos para recoger las preguntas
    private void llenarArray() {
        preguntas = ddbb.preguntaDAO().conseguirTodasPreguntas();
    }

    //función que comprueba, si se ha acertado
    void preguntaAcertada(boolean acertar, int id) {
        if (!acertar) {
            //si no se ha acertado, vuelve al principio
            game.movePlayer(GameView.Direction.OTRAVEZ);
            //y casillas a 0, ya que vuelve al principio
            casillas = 0;
        } else {
            //si no seteamos la pregunta a contestada
            preguntas.get(id - 1).setContestada(true);
            //y ponemos desde donde tiene que empezar a raponder preguntas
            principio = 8 * id;
        }
        // y activamos los botones
        arriba.setEnabled(true);
        abajo.setEnabled(true);
        derecha.setEnabled(true);
        izquierda.setEnabled(true);
    }

    //compruba si hay pregunta en el camino
    Pregunta hayPregunta() {
        Pregunta posibleP = null;

        for (int i = 0; i < preguntas.size(); i++) {
            if (!preguntas.get(i).isContestada()) {
                posibleP = preguntas.get(i);
                i = preguntas.size()+1;
            }
        }

        return posibleP;
    }


    //si termina el laberinto, activa los confeti, y cuando termina los confetis vuelve al mapa,y termina el juego.
    void laberintoTerminado(){
        con.build()
                .addColors(Color.YELLOW, Color.MAGENTA, Color.GREEN)
                .setDirection(0.0, 359)
                .setSpeed(1f, 5f)
                .setFadeOutEnabled(true)
                .setTimeToLive(5000L)
                .addShapes(Shape.Square.INSTANCE, Shape.Circle.INSTANCE)
                .addSizes(new Size(12, 5f))
                .setPosition(-50f, con.getWidth() + 50f, -50f, -50f)
                .streamFor(300, 2000L);
        arriba.setEnabled(false);
        abajo.setEnabled(false);
        derecha.setEnabled(false);
        izquierda.setEnabled(false);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(LaberintoActivity.this, MainActivity.class);
                i.putExtra("id", 5);
                startActivity(i);
            }
        }, 5000);


    }

}