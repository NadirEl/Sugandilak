package com.example.sugandilak;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.sugandilak.EntidadesDB.PreguntaImagen;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FragmentPreguntaImagen extends Fragment implements View.OnClickListener{
    //lista de las preguntasImagenes
    List<PreguntaImagen> imagenes = new ArrayList<>();
    //los botones son las opciones
    Button morado, azul, verde;
    //imagen que se muestra
    ImageView imagen;
    //el contador que comprueba cuando terminan el juego
    int contador = 0;


    public FragmentPreguntaImagen() {
        // Required empty public constructor
    }

    //se recoge las preguntasImagenes
    public static FragmentPreguntaImagen getInstance(List<PreguntaImagen> imagenes) {
        FragmentPreguntaImagen fragment = new FragmentPreguntaImagen();
        Bundle args = new Bundle();
        args.putSerializable("imagenes", (Serializable) imagenes);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            imagenes = (ArrayList<PreguntaImagen>) getArguments().getSerializable("imagenes");
        }
    }

    //seteamos los ids
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_pregunta_imagen, container, false);
        morado = v.findViewById(R.id.idButMorado);
        morado.setOnClickListener(this);

        azul = v.findViewById(R.id.idButAzul);
        azul.setOnClickListener(this);

        verde = v.findViewById(R.id.idButVerde);
        verde.setOnClickListener(this);

        imagen = v.findViewById(R.id.idImElec);
        //se pone la primera imagen
        Drawable d = ContextCompat.getDrawable(getActivity().getApplicationContext(), imagenes.get(contador).getIdImagen());
        imagen.setImageDrawable(d);
        return v;
    }

    @Override
    public void onClick(View v) {

        // al clicar un boton, se consigue el view se ese boton, para saber cual a clicado
        Button b = (Button) v;
        //comprueba que el texto del boton es igual a la respuesta de la preguntaImagen
        if(b.getText().equals(imagenes.get(contador).getRespuesta())){
            //si esta bien suma el contador
            contador++;
            //comprueba si hay mas preguntaImagenes
            if(contador == imagenes.size()){
                //si termina va a la funccion volverMapa
                getActivity().getSupportFragmentManager().beginTransaction().remove(FragmentPreguntaImagen.this).commit();
                ((MainActivity2) getActivity()).volverMapa(1);
            }else{
                // si no, aparece la siguiente imagen
                Drawable d = ContextCompat.getDrawable(getActivity().getApplicationContext(),imagenes.get(contador).getIdImagen());
                imagen.setImageDrawable(d);
            }
        }

    }
}