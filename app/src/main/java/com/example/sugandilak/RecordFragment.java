package com.example.sugandilak;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.sugandilak.EntidadesDB.RecordCartas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class RecordFragment extends Fragment {

    List<RecordCartas> records = new ArrayList<>();
    TextView puntuaciones;
    Button salir;


    public RecordFragment() {
        // Required empty public constructor
    }
    public static RecordFragment getInstance(List<RecordCartas> listar) {
        RecordFragment fragment = new RecordFragment();
        Bundle args = new Bundle();
        args.putSerializable("record", (Serializable) listar);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            records = (ArrayList<RecordCartas>) getArguments().getSerializable("record");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_record, container, false);
        puntuaciones = v.findViewById(R.id.idpuntuaciones);
        salir = v.findViewById(R.id.idSalirClasificacion);
        clasificacion();
        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity2) getActivity()).volverMapa(4);
            }
        });
        return v;
    }

    void clasificacion(){
        for(int i = 0; i<records.size(); i++){
            int num = i+1;
            puntuaciones.setText(puntuaciones.getText()+"\n"+num+". "+ records.get(i).getNombre()+": "+records.get(i).getRecord());
        }
    }
}