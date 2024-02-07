package com.example.sugandilak;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;

public class FragmentBienvenida extends Fragment implements View.OnClickListener{
    //fragment que aparece la primera vez que instalamos el juego, que nos da una pequeña explicacion de en que consiste
    Button but;
    public FragmentBienvenida() {
        // Required empty public constructor
    }

    public static FragmentBienvenida newInstance() {
        FragmentBienvenida fragment = new FragmentBienvenida();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bienvenida, container, false);
        but = view.findViewById(R.id.idButSalirBienvenida);
        but.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        getActivity().getSupportFragmentManager().beginTransaction().remove(FragmentBienvenida.this).commit();

    }
}