package com.example.sugandilak;

import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sugandilak.EntidadesDB.AudioApp;
import com.example.sugandilak.EntidadesDB.Imagen;
import com.example.sugandilak.EntidadesDB.Texto;
import com.google.android.material.card.MaterialCardView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import pl.droidsonroids.gif.GifImageView;


public class ExplicacionFragment extends Fragment {

    //textView donde esta el texto
    TextView id_explicaciones;
    //el componente del gif
    GifImageView id_gif;
    //componente de la imagen de la muñeca sin hablar
    ImageView sinhablar, imgview;
    //botones de inicar y saltar
    Button btn_iniciar, btn_skipp;
    //Inicializar el handler
    Handler handler = new Handler();
    //int para saber lo largo del texto
    int currentIndex = 0;
    // int para guardar la duracion del audio
    int duration = 0;
    MediaPlayer mediaPlayer;
    MaterialCardView mc;
    int contador = 0;
    //arrays del texto, las imagenes y los audios
    List<Texto> textos = new ArrayList<>();
    List<Imagen> img = new ArrayList<>();
    List<AudioApp> audios = new ArrayList<>();
    //id que depende de la ubicacion
    int id;


    public ExplicacionFragment() {
        // Required empty public constructor
    }

    //recogemos las lista y el id
    public static ExplicacionFragment getInstance(List<Texto> textos, List<Imagen> img, List<AudioApp> audios, int id) {
        ExplicacionFragment fragment = new ExplicacionFragment();
        Bundle args = new Bundle();
        args.putInt("id", id);
        args.putSerializable("textos", (Serializable) textos);
        args.putSerializable("img", (Serializable) img);
        args.putSerializable("audios", (Serializable) audios);
        fragment.setArguments(args);
        return fragment;
    }

    //setteamos los id y los listeners
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_explicacion, container, false);
        mc = v.findViewById(R.id.idimgJ1);
        imgview = v.findViewById(R.id.idImg);
        btn_skipp = v.findViewById(R.id.skippButton);
        id_explicaciones = v.findViewById(R.id.id_explicaciones);
        id_explicaciones.setMovementMethod(new ScrollingMovementMethod());
        btn_iniciar = v.findViewById(R.id.btn_iniciar);
        id_gif = v.findViewById(R.id.id_gif);
        sinhablar = v.findViewById(R.id.imgsinhablar);

        btn_skipp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v2) {
                //se para el audio
                mediaPlayer.stop();
                //comprueba si hay imagenes
                if(img.size() == 0){
                    //si no hay, sigue con los textos
                    id_explicaciones.setText(textos.get(contador).getTexto());
                    currentIndex=textos.get(contador).getTexto().length();
                    btn_iniciar.setVisibility(View.VISIBLE);
                    btn_skipp.setEnabled(false);
                }else {
                    //comprueba si sigue habiendo imagenes
                    if (img.get(contador).getImagen() != 0) {
                        //si hay, la visualiza y para de hablar la muñeca
                        Drawable d = ContextCompat.getDrawable(getActivity().getApplicationContext(), img.get(contador).getImagen());
                        imgview.setImageDrawable(d);
                        mc.setVisibility(View.VISIBLE);
                        id_explicaciones.setVisibility(View.INVISIBLE);
                        id_gif.setVisibility(View.INVISIBLE);
                        sinhablar.setVisibility(View.VISIBLE);
                        btn_skipp.setEnabled(false);
                    } else {
                        //si no, sumamos el contador y sigue tanto el audio como el texto
                        contador++;
                        mostrarTexto();
                        empezarAudio();
                    }
                }


            }
        });

        btn_iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Dependiendo del id, abre diferentes juegos
                getActivity().getSupportFragmentManager().beginTransaction().remove(ExplicacionFragment.this).commit();
                switch(id){
                    case 1: ((MainActivity2) getActivity()).abrirFragmentJuego1();
                        break;

                    case 2:  ((MainActivity2) getActivity()).abrirFragmentJuego2();
                        break;

                    case 3:((MainActivity2) getActivity()).abrirFragmentJuego3();
                        break;
                    case 4:((MainActivity2) getActivity()).abrirUser();
                        break;
                    case 5:((MainActivity2) getActivity()).abrirFragmentVideo();
                        break;

                }


            }
        });

        //cuado haya imagen, tendran que clicarla
        mc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //comprueba si sigue habiendo imagnes
                if(contador == 9){
                    //si no, aparece el boton inciar
                    btn_iniciar.setVisibility(View.VISIBLE);
                    btn_skipp.setEnabled(false);
                }else {
                    // si sigue habiendo, muestra el texto y el audio siguiente
                    contador++;
                    mc.setVisibility(View.INVISIBLE);
                    id_explicaciones.setVisibility(View.VISIBLE);
                    id_gif.setVisibility(View.VISIBLE);
                    sinhablar.setVisibility(View.INVISIBLE);
                    btn_skipp.setEnabled(true);
                    mostrarTexto();
                    empezarAudio();
                }
            }
        });


        //en la ubicacion número 1, los textos se muestran normal
        if(id == 1){
            mostrarTexto();
        }else{
            mostrarTextoPorLetras();

        }

        empezarAudio();


        return v;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            textos = (ArrayList<Texto>) getArguments().getSerializable("textos");
            img = (ArrayList<Imagen>) getArguments().getSerializable("img");
            audios = (ArrayList<AudioApp>) getArguments().getSerializable("audios");
            id = getArguments().getInt("id");
        }

    }


    //función que muestra el texto entero, cuando le damos al boton saltar
    void mostrarTexto(){
        id_explicaciones.setText("");
        id_explicaciones.setText(textos.get(contador).getTexto());
    }

    //función con la que empieza el audio
    void empezarAudio(){
        //conseguimos el audio
        mediaPlayer = MediaPlayer.create(getActivity(), audios.get(contador).getAudio());
        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                //conseguimos la duración del audio, para saber la velocidad que tiene que ir al mostrar el texto
                duration = mp.getDuration();

            }
        });

        // cuando se completa el audio
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                //comprueba lo mismo que se diesemos al boton saltar
                if(img.size() == 0){
                    btn_iniciar.setVisibility(View.VISIBLE);
                    btn_skipp.setEnabled(false);
                }else {
                    if (img.get(contador) != null) {
                        Drawable d = ContextCompat.getDrawable(getActivity(), img.get(contador).getImagen());
                        imgview.setImageDrawable(d);
                        mc.setVisibility(View.VISIBLE);
                        id_explicaciones.setVisibility(View.INVISIBLE);
                        id_gif.setVisibility(View.INVISIBLE);
                        sinhablar.setVisibility(View.VISIBLE);
                        btn_skipp.setEnabled(false);
                    } else {
                        contador++;
                        mostrarTexto();
                        empezarAudio();
                    }
                }
            }
        });

        mediaPlayer.start();
    }

    //función que muestra el texto como una maquina de escribir
    void mostrarTextoPorLetras() {

        String texto = textos.get(contador).getTexto();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                // Verifica si hay más letras para mostrar
                if (currentIndex < texto.length()) {
                    // Obtén la letra actual y agrégala al texto
                    String letraActual = String.valueOf(texto.charAt(currentIndex));
                    id_explicaciones.setText(id_explicaciones.getText() + letraActual);

                    // Incrementa el índice para la próxima letra
                    currentIndex++;

                    // Programa la próxima actualización en medio segundo
                    handler.postDelayed(this, duration/texto.length()-20);
                } else {
                    // Cuando se ha mostrado todo el texto, muestra el botón

                    id_gif.setVisibility(View.INVISIBLE);
                    sinhablar.setVisibility(View.VISIBLE);
                }
            }
        }, 500);
    }
}