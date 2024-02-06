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

    List<PreguntaImagen> imagenes = new ArrayList<>();

    Button morado, azul, verde;
    ImageView imagen;
    int contador = 0;


    public FragmentPreguntaImagen() {
        // Required empty public constructor
    }

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
        Drawable d = ContextCompat.getDrawable(getActivity().getApplicationContext(), imagenes.get(contador).getIdImagen());
        imagen.setImageDrawable(d);
        return v;
    }

    @Override
    public void onClick(View v) {

        Button b = (Button) v;
        if(b.getText().equals(imagenes.get(contador).getRespuesta())){
            contador++;
            if(contador == imagenes.size()){
                getActivity().getSupportFragmentManager().beginTransaction().remove(FragmentPreguntaImagen.this).commit();
                ((MainActivity2) getActivity()).volverMapa(1);
            }else{
                Drawable d = ContextCompat.getDrawable(getActivity().getApplicationContext(),imagenes.get(contador).getIdImagen());
                imagen.setImageDrawable(d);
            }
        }

    }
}