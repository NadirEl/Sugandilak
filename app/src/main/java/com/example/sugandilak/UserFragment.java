package com.example.sugandilak;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class UserFragment extends Fragment {

    Button but;
    EditText userEdit;

    public UserFragment() {
        // Required empty public constructor
    }

    public static UserFragment getInstance() {
        UserFragment fragment = new UserFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_user, container, false);
        but = v.findViewById(R.id.idButUser);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = userEdit.getText().toString();

                if(!user.equals("")){
                    ((MainActivity2) getActivity()).abrirFragmentJuego4(user);
                }

            }
        });

        userEdit = v.findViewById(R.id.idUser);

        return v;
    }
}