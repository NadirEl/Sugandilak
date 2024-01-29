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

import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;

import pl.droidsonroids.gif.GifImageView;


public class ExplicacionFragment extends Fragment {

    TextView id_explicaciones;
    GifImageView id_gif;
    ImageView sinhablar, imgview;
    Button btn_iniciar, btn_skipp;
    Handler handler = new Handler();
    int currentIndex = 0;
    int duration = 0;
    MediaPlayer mediaPlayer;
    MaterialCardView mc;
    int contador = 0;
    ArrayList<String> textos = new ArrayList<>();
    ArrayList<Integer> img = new ArrayList<>();
    ArrayList<Integer> audios = new ArrayList<>();
    int id;


    public ExplicacionFragment() {
        // Required empty public constructor
    }

    public static ExplicacionFragment getInstance(ArrayList<String> textos, ArrayList<Integer> img, ArrayList<Integer> audios, int id) {
        ExplicacionFragment fragment = new ExplicacionFragment();
        Bundle args = new Bundle();
        args.putInt("id", id);
        args.putSerializable("textos", textos);
        args.putSerializable("img", img);
        args.putSerializable("audios", audios);
        fragment.setArguments(args);
        return fragment;
    }

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
                mediaPlayer.stop();
                if(img.size() == 0){
                    id_explicaciones.setText(textos.get(contador));
                    currentIndex=textos.get(contador).length();
                    btn_iniciar.setVisibility(View.VISIBLE);
                    btn_skipp.setEnabled(false);
                }else {
                    if (img.get(contador) != null) {
                        Drawable d = ContextCompat.getDrawable(getActivity().getApplicationContext(), img.get(contador));
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

        btn_iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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

        mc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(contador == 9){
                    btn_iniciar.setVisibility(View.VISIBLE);
                    btn_skipp.setEnabled(false);
                }else {
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
            textos = (ArrayList<String>) getArguments().getSerializable("textos");
            img = (ArrayList<Integer>) getArguments().getSerializable("img");
            audios = (ArrayList<Integer>) getArguments().getSerializable("audios");
            id = getArguments().getInt("id");
        }

    }



    void mostrarTexto(){
        id_explicaciones.setText("");
        id_explicaciones.setText(textos.get(contador));
    }

    void empezarAudio(){
        mediaPlayer = MediaPlayer.create(getActivity(), audios.get(contador));
        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                duration = mp.getDuration();

            }
        });

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                if(img.size() == 0){
                    btn_iniciar.setVisibility(View.VISIBLE);
                    btn_skipp.setEnabled(false);
                }else {
                    if (img.get(contador) != null) {
                        Drawable d = ContextCompat.getDrawable(getActivity(), img.get(contador));
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

    void mostrarTextoPorLetras() {

        String texto = textos.get(contador);

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