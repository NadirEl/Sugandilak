package com.example.sugandilak;

import android.content.Intent;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.sugandilak.EntidadesDB.AudioApp;
import com.example.sugandilak.EntidadesDB.ElorrioDatabase;
import com.example.sugandilak.EntidadesDB.Imagen;
import com.example.sugandilak.EntidadesDB.PreguntaImagen;
import com.example.sugandilak.EntidadesDB.RecordCartas;
import com.example.sugandilak.EntidadesDB.Texto;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    //id que se recoge del mapa
    int id;
    //los arrays de la parte de la explicacion
    List<Texto> textos = new ArrayList<>();
    List<Imagen> img = new ArrayList<>();
    List<AudioApp> audios = new ArrayList<>();
    FragmentManager fragmentManager = getSupportFragmentManager();
    //base de datos
    ElorrioDatabase ddbb;
    //lista de la clasificacion del juego de las cartas
    List<RecordCartas> mejores = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //se recoge los ids del mapa
        Bundle b = getIntent().getExtras();
        id = b.getInt("id");
        //se instancia la base de datos
        ddbb = ElorrioDatabase.getInstance(this);

        recogerTextos();
    }
    //función que recoge los textos,las imagenes y los audios de la base de datos
    void recogerTextos() {

        textos = ddbb.textoDAO().conseguirTextosPorId(id);

        audios = ddbb.audioDAO().conseguirTodosAudios(id);

        img = ddbb.imagenDAO().conseguirImagenesPorId(id);

        //y se abre el fragment de la explicación, el de la muñeca
        abrirFragmentExplicacion();
    }

    //función que abre la explicación
    void abrirFragmentExplicacion() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.idfragment, ExplicacionFragment.getInstance(textos, img, audios, id));
        fragmentTransaction.commit();
    }
    //función que abre el juego 1
    void abrirFragmentJuego1(){
        List<PreguntaImagen> listapi = recogerPreguntasImagen();
        FragmentTransaction fragmentTransaction1 = fragmentManager.beginTransaction();
        fragmentTransaction1.add(R.id.idfragment, FragmentPreguntaImagen.getInstance(listapi));
        fragmentTransaction1.commit();
    }
    //función que abre el juego 2
    void abrirFragmentJuego2(){
        FragmentTransaction fragmentTransaction2 = fragmentManager.beginTransaction();
        fragmentTransaction2.add(R.id.idfragment, Juego2Fragment.getInstance());
        fragmentTransaction2.commit();
    }
    //función que abre el fragment del video
    void abrirFragmentVideo(){
        Intent i = new Intent(MainActivity2.this, VideoActivity.class);
        startActivity(i);
    }
    //función que abre el fragment de poner el nombre para el juego 4
    void abrirUser(){
        FragmentTransaction fragmentTransaction4 = fragmentManager.beginTransaction();
        fragmentTransaction4.add(R.id.idfragment, UserFragment.getInstance());
        fragmentTransaction4.commit();
    }

    //función que abre el fragment de la clasificación del juego 4
    void abrirClasificacion(RecordCartas r){

        ddbb.recordCartasDAO().insertarRecord(r);
        mejores = ddbb.recordCartasDAO().mejores10();

        FragmentTransaction fragmentTransaction4 = fragmentManager.beginTransaction();
        fragmentTransaction4.add(R.id.idfragment, RecordFragment.getInstance(mejores));
        fragmentTransaction4.commit();
    }
    //función que abre el juego 4
    void abrirFragmentJuego4(String user){
        FragmentTransaction fragmentTransaction4 = fragmentManager.beginTransaction();
        fragmentTransaction4.add(R.id.idfragment, PrimerFragment.getInstance(user));
        fragmentTransaction4.commit();
    }
    //función que abre el juego 3
    void abrirFragmentJuego3(){
        FragmentTransaction fragmentTransaction3 = fragmentManager.beginTransaction();
        fragmentTransaction3.add(R.id.idfragment, SopaDeLetrasFragment.getInstance());
        fragmentTransaction3.commit();
    }


    //función que recoge las preguntaImagenes de la base de datos
    List<PreguntaImagen> recogerPreguntasImagen(){
        List<PreguntaImagen> pi = ddbb.preguntaImagenDAO().conseguirTodasPreguntaImagenes();

        return pi;
    }

    //función que vuelve al mapa
    void volverMapa(int id){
        Intent i = new Intent(MainActivity2.this, MainActivity.class);
        i.putExtra("id", id);
        startActivity(i);
    }
}

