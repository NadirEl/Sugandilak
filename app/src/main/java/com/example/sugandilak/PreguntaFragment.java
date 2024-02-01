package com.example.sugandilak;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.sugandilak.EntidadesDB.Pregunta;

public class PreguntaFragment extends Fragment implements View.OnClickListener{
    private Pregunta pregunta;
    RadioGroup grupo;
    TextView tv;
    Button but;
    RadioButton op1, op2, op3;


    public PreguntaFragment() {
        // Required empty public constructor
    }
    public static PreguntaFragment getInstance(Pregunta pregunta) {
        PreguntaFragment fragment = new PreguntaFragment();
        Bundle args = new Bundle();
        args.putSerializable("pregunta", pregunta);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            pregunta = (Pregunta) getArguments().getSerializable("pregunta");

        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pregunta, container, false);
        grupo = view.findViewById(R.id.opciones);
        op1 = view.findViewById(R.id.rbop1);
        op1.setText(this.pregunta.getOpcion1());
        op2 = view.findViewById(R.id.rbop2);
        op2.setText(this.pregunta.getOpcion2());
        op3 = view.findViewById(R.id.rbop3);
        op3.setText(this.pregunta.getOpcion3());
        tv = view.findViewById(R.id.preguntatv);
        tv.setText(this.pregunta.getPregunta());
        but = view.findViewById(R.id.butpregunta);
        but.setOnClickListener(this);
        return view;
    }


    @Override
    public void onClick(View v) {
        boolean acertar = false;
        if(grupo.getCheckedRadioButtonId() !=-1){
            RadioButton select = getView().findViewById(grupo.getCheckedRadioButtonId());
            if(select.getText() == this.pregunta.getRespuesta()){
                acertar = true;
            }
            getActivity().getSupportFragmentManager().beginTransaction().remove(PreguntaFragment.this).commit();
            ((Laberinto) getActivity()).hola(acertar, this.pregunta.getId_pregunta());
        }
    }
}