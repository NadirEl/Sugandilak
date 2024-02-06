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
    int id;
    List<Texto> textos = new ArrayList<>();
    List<Imagen> img = new ArrayList<>();
    List<AudioApp> audios = new ArrayList<>();
    FragmentManager fragmentManager = getSupportFragmentManager();

    ElorrioDatabase ddbb;

    List<RecordCartas> mejores = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle b = getIntent().getExtras();
        id = b.getInt("id");

        ddbb = ElorrioDatabase.getInstance(this);

        recogerTextos();
    }

    void recogerTextos() {

        textos = ddbb.textoDAO().conseguirTextosPorId(id);

        audios = ddbb.audioDAO().conseguirTodosAudios(id);

        img = ddbb.imagenDAO().conseguirImagenesPorId(id);

        abrirFragmentExplicacion();
    }

    void abrirFragmentExplicacion() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.idfragment, ExplicacionFragment.getInstance(textos, img, audios, id));
        fragmentTransaction.commit();
    }

    void abrirFragmentJuego1(){
        List<PreguntaImagen> listapi = recogerPreguntasImagen();
        FragmentTransaction fragmentTransaction1 = fragmentManager.beginTransaction();
        fragmentTransaction1.add(R.id.idfragment, FragmentPreguntaImagen.getInstance(listapi));
        fragmentTransaction1.commit();
    }

    void abrirFragmentJuego2(){
        FragmentTransaction fragmentTransaction2 = fragmentManager.beginTransaction();
        fragmentTransaction2.add(R.id.idfragment, Juego2Fragment.getInstance());
        fragmentTransaction2.commit();
    }



    void abrirFragmentVideo(){
        Intent i = new Intent(MainActivity2.this, VideoActivity.class);
        startActivity(i);
    }

    void abrirUser(){
        FragmentTransaction fragmentTransaction4 = fragmentManager.beginTransaction();
        fragmentTransaction4.add(R.id.idfragment, UserFragment.getInstance());
        fragmentTransaction4.commit();
    }

    void abrirClasificacion(RecordCartas r){

        ddbb.recordCartasDAO().insertarRecord(r);
        mejores = ddbb.recordCartasDAO().mejores10();

        FragmentTransaction fragmentTransaction4 = fragmentManager.beginTransaction();
        fragmentTransaction4.add(R.id.idfragment, RecordFragment.getInstance(mejores));
        fragmentTransaction4.commit();
    }

    void abrirFragmentJuego4(String user){
        FragmentTransaction fragmentTransaction4 = fragmentManager.beginTransaction();
        fragmentTransaction4.add(R.id.idfragment, PrimerFragment.getInstance(user));
        fragmentTransaction4.commit();
    }
    void abrirFragmentJuego3(){
        FragmentTransaction fragmentTransaction3 = fragmentManager.beginTransaction();
        fragmentTransaction3.add(R.id.idfragment, SopaDeLetrasFragment.getInstance());
        fragmentTransaction3.commit();
    }



    List<PreguntaImagen> recogerPreguntasImagen(){
        List<PreguntaImagen> pi = ddbb.preguntaImagenDAO().conseguirTodasPreguntaImagenes();

        return pi;
    }

    void volverMapa(int id){
        Intent i = new Intent(MainActivity2.this, MainActivity.class);
        i.putExtra("id", id);
        startActivity(i);
    }
}

