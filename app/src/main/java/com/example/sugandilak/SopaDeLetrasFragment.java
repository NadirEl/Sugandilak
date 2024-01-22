package com.example.sugandilak;

import static android.graphics.Color.parseColor;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.lang.reflect.Field;


public class SopaDeLetrasFragment extends Fragment {

    int contarRojo = 0;
    boolean lepanto=false;
    boolean elorrio=false;
    boolean igandea=false;
    boolean jaia=false;
    boolean bataila=false;
    boolean sinbolo=false;
    boolean lehen=false;
    boolean errebonbilo=false;
    boolean urria=false;


    TextView uno_uno, uno_dos, uno_tres, uno_cuatro, uno_cinco, uno_seis, uno_siete, uno_ocho, uno_nueve, uno_diez, uno_once;
    TextView dos_uno, dos_dos, dos_tres, dos_cuatro, dos_cinco, dos_seis, dos_siete, dos_ocho, dos_nueve, dos_diez, dos_once;
    TextView tres_uno, tres_dos, tres_tres, tres_cuatro, tres_cinco, tres_seis, tres_siete, tres_ocho, tres_nueve, tres_diez, tres_once;
    TextView cuatro_uno, cuatro_dos, cuatro_tres, cuatro_cuatro, cuatro_cinco, cuatro_seis, cuatro_siete, cuatro_ocho, cuatro_nueve, cuatro_diez, cuatro_once;
    TextView cinco_uno, cinco_dos, cinco_tres, cinco_cuatro, cinco_cinco, cinco_seis, cinco_siete, cinco_ocho, cinco_nueve, cinco_diez, cinco_once;
    TextView seis_uno, seis_dos, seis_tres, seis_cuatro, seis_cinco, seis_seis, seis_siete, seis_ocho, seis_nueve, seis_diez, seis_once;
    TextView siete_uno, siete_dos, siete_tres, siete_cuatro, siete_cinco, siete_seis, siete_siete, siete_ocho, siete_nueve, siete_diez, siete_once;
    TextView ocho_uno, ocho_dos, ocho_tres, ocho_cuatro, ocho_cinco, ocho_seis, ocho_siete, ocho_ocho, ocho_nueve, ocho_diez, ocho_once;
    TextView nueve_uno, nueve_dos, nueve_tres, nueve_cuatro, nueve_cinco, nueve_seis, nueve_siete, nueve_ocho, nueve_nueve, nueve_diez, nueve_once;
    TextView diez_uno, diez_dos, diez_tres, diez_cuatro, diez_cinco, diez_seis, diez_siete, diez_ocho, diez_nueve, diez_diez, diez_once;
    TextView once_uno, once_dos, once_tres, once_cuatro, once_cinco, once_seis, once_siete, once_ocho, once_nueve, once_diez, once_once;



    TextView[]listaTv={uno_uno, uno_dos, uno_tres, uno_cuatro, uno_cinco, uno_seis, uno_siete, uno_ocho, uno_nueve, uno_diez, uno_once,
            dos_uno, dos_dos, dos_tres, dos_cuatro, dos_cinco, dos_seis, dos_siete, dos_ocho, dos_nueve, dos_diez, dos_once,
            tres_uno, tres_dos, tres_tres, tres_cuatro, tres_cinco, tres_seis, tres_siete, tres_ocho, tres_nueve, tres_diez, tres_once,
            cuatro_uno, cuatro_dos, cuatro_tres, cuatro_cuatro, cuatro_cinco, cuatro_seis, cuatro_siete, cuatro_ocho, cuatro_nueve, cuatro_diez, cuatro_once,
            cinco_uno, cinco_dos, cinco_tres, cinco_cuatro, cinco_cinco, cinco_seis, cinco_siete, cinco_ocho, cinco_nueve, cinco_diez, cinco_once,
            seis_uno, seis_dos, seis_tres, seis_cuatro, seis_cinco, seis_seis, seis_siete, seis_ocho, seis_nueve, seis_diez, seis_once,
            siete_uno, siete_dos, siete_tres, siete_cuatro, siete_cinco, siete_seis, siete_siete, siete_ocho, siete_nueve, siete_diez, siete_once,
            ocho_uno, ocho_dos, ocho_tres, ocho_cuatro, ocho_cinco, ocho_seis, ocho_siete, ocho_ocho, ocho_nueve, ocho_diez, ocho_once,
            nueve_uno, nueve_dos, nueve_tres, nueve_cuatro, nueve_cinco, nueve_seis, nueve_siete, nueve_ocho, nueve_nueve, nueve_diez, nueve_once,
            diez_uno, diez_dos, diez_tres, diez_cuatro, diez_cinco, diez_seis, diez_siete, diez_ocho, diez_nueve, diez_diez, diez_once,
            once_uno, once_dos, once_tres, once_cuatro, once_cinco, once_seis, once_siete, once_ocho, once_nueve, once_diez, once_once};


    public SopaDeLetrasFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static SopaDeLetrasFragment getInstance() {
        SopaDeLetrasFragment fragment = new SopaDeLetrasFragment();
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
        View view = inflater.inflate(R.layout.fragment_sopa_de_letras, container, false);

        int contarRojo=0;

        Field[] fields = R.id.class.getFields();

        idAllViews();

        TextView [] listaTv = toArrayAllViews();

        setAllOnClick(listaTv);

        return view;
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {

        public void onClick(View view) {

            if (((ColorDrawable) view.getBackground()).getColor() == parseColor("#FFFFFFFF")) {
                view.setBackgroundColor(parseColor("#FA8072"));
                contarRojo++;
                Log.d("Suma", "Valor es: " + contarRojo);
            } else {
                view.setBackgroundColor(parseColor("#FFFFFFFF"));
                contarRojo--;
                Log.d("Resta", "Valor es: " + contarRojo);
            }

            comprobarPalabras();

        }

    };

    public void setAllOnClick(TextView [] listaTv) {

        TextView tv;



        for(int i=0; i<=120;i++){

            tv = listaTv[i];
            tv.setOnClickListener(onClickListener);
            tv.setBackgroundColor(parseColor("#FFFFFFFF"));

        }



    }

    public void comprobarPalabras(){

        //palabara: LEPANTO 1_!-1_7
        if(
                (lepanto==false&&
                        ((ColorDrawable) uno_uno.getBackground()).getColor()!=parseColor("#FFFFFFFF")&&
                        ((ColorDrawable) uno_dos.getBackground()).getColor()!=parseColor("#FFFFFFFF")&&
                        ((ColorDrawable) uno_tres.getBackground()).getColor()!=parseColor("#FFFFFFFF")&&
                        ((ColorDrawable) uno_cuatro.getBackground()).getColor()!=parseColor("#FFFFFFFF")&&
                        ((ColorDrawable) uno_cinco.getBackground()).getColor()!=parseColor("#FFFFFFFF")&&
                        ((ColorDrawable) uno_seis.getBackground()).getColor()!=parseColor("#FFFFFFFF")&&
                        ((ColorDrawable) uno_siete.getBackground()).getColor()!=parseColor("#FFFFFFFF")

                )&&(

                        (
                                (contarRojo==7)
                        )||
                                (
                                        (elorrio==true)&&
                                                (contarRojo==6)
                                )

                )

        ){
            uno_uno.setBackgroundColor(parseColor("#00ff00"));
            uno_uno.setClickable(false);
            uno_dos.setBackgroundColor(parseColor("#00ff00"));
            uno_dos.setClickable(false);
            uno_tres.setBackgroundColor(parseColor("#00ff00"));
            uno_tres.setClickable(false);
            uno_cuatro.setBackgroundColor(parseColor("#00ff00"));
            uno_cuatro.setClickable(false);
            uno_cinco.setBackgroundColor(parseColor("#00ff00"));
            uno_cinco.setClickable(false);
            uno_seis.setBackgroundColor(parseColor("#00ff00"));
            uno_seis.setClickable(false);
            uno_siete.setBackgroundColor(parseColor("#00ff00"));
            uno_siete.setClickable(false);

            contarRojo=0;
            lepanto=true;
        }

        //palabara: ELORRIO 1_2-7_2
        if(

                (elorrio==false&&
                        ((ColorDrawable) uno_dos.getBackground()).getColor()!=parseColor("#FFFFFFFF")&&
                        ((ColorDrawable) dos_dos.getBackground()).getColor()!=parseColor("#FFFFFFFF")&&
                        ((ColorDrawable) tres_dos.getBackground()).getColor()!=parseColor("#FFFFFFFF")&&
                        ((ColorDrawable) cuatro_dos.getBackground()).getColor()!=parseColor("#FFFFFFFF")&&
                        ((ColorDrawable) cinco_dos.getBackground()).getColor()!=parseColor("#FFFFFFFF")&&
                        ((ColorDrawable) seis_dos.getBackground()).getColor()!=parseColor("#FFFFFFFF")&&
                        ((ColorDrawable) siete_dos.getBackground()).getColor()!=parseColor("#FFFFFFFF")
                )&&(
                        (
                                (contarRojo==7)
                        )||
                                (

                                        (lepanto==true&&sinbolo==true)&&
                                                (contarRojo==5)

                                )||(
                                (lepanto==true||sinbolo==true)&&
                                        (contarRojo==6)

                        )
                )

        ){
            uno_dos.setBackgroundColor(parseColor("#00ff00"));
            uno_dos.setClickable(false);
            dos_dos.setBackgroundColor(parseColor("#00ff00"));
            dos_dos.setClickable(false);
            tres_dos.setBackgroundColor(parseColor("#00ff00"));
            tres_dos.setClickable(false);
            cuatro_dos.setBackgroundColor(parseColor("#00ff00"));
            cuatro_dos.setClickable(false);
            cinco_dos.setBackgroundColor(parseColor("#00ff00"));
            cinco_dos.setClickable(false);
            seis_dos.setBackgroundColor(parseColor("#00ff00"));
            seis_dos.setClickable(false);
            siete_dos.setBackgroundColor(parseColor("#00ff00"));
            siete_dos.setClickable(false);

            elorrio=true;
            contarRojo=0;
        }

        //palabara: JAIA 2_9-5_9
        if(
                (jaia==false&&
                        ((ColorDrawable) dos_nueve.getBackground()).getColor()!=parseColor("#FFFFFFFF")&&
                        ((ColorDrawable) tres_nueve.getBackground()).getColor()!=parseColor("#FFFFFFFF")&&
                        ((ColorDrawable) cuatro_nueve.getBackground()).getColor()!=parseColor("#FFFFFFFF")&&
                        ((ColorDrawable) cinco_nueve.getBackground()).getColor()!=parseColor("#FFFFFFFF")
                )&&(
                        (
                                (contarRojo==4)
                        )||
                                (
                                        (bataila==true)&&
                                                (contarRojo==3)
                                )


                )

        ){
            dos_nueve.setBackgroundColor(parseColor("#00ff00"));
            dos_nueve.setClickable(false);
            tres_nueve.setBackgroundColor(parseColor("#00ff00"));
            tres_nueve.setClickable(false);
            cuatro_nueve.setBackgroundColor(parseColor("#00ff00"));
            cuatro_nueve.setClickable(false);
            cinco_nueve.setBackgroundColor(parseColor("#00ff00"));
            cinco_nueve.setClickable(false);

            jaia=true;
            contarRojo=0;
        }

        //palabara: IGANDEA 3_3-9_3
        if((igandea==false&&
                ((ColorDrawable) tres_tres.getBackground()).getColor()!=parseColor("#FFFFFFFF")&&
                ((ColorDrawable) cuatro_tres.getBackground()).getColor()!=parseColor("#FFFFFFFF")&&
                ((ColorDrawable) cinco_tres.getBackground()).getColor()!=parseColor("#FFFFFFFF")&&
                ((ColorDrawable) seis_tres.getBackground()).getColor()!=parseColor("#FFFFFFFF")&&
                ((ColorDrawable) siete_tres.getBackground()).getColor()!=parseColor("#FFFFFFFF")&&
                ((ColorDrawable) ocho_tres.getBackground()).getColor()!=parseColor("#FFFFFFFF")&&
                ((ColorDrawable) nueve_tres.getBackground()).getColor()!=parseColor("#FFFFFFFF")

        )&&(
                (
                        (contarRojo==7)
                )||
                        (
                                (sinbolo==true)&&
                                        (contarRojo==6)
                        )


        )
        ){
            tres_tres.setBackgroundColor(parseColor("#00ff00"));
            tres_tres.setClickable(false);
            cuatro_tres.setBackgroundColor(parseColor("#00ff00"));
            cuatro_tres.setClickable(false);
            cinco_tres.setBackgroundColor(parseColor("#00ff00"));
            cinco_tres.setClickable(false);
            seis_tres.setBackgroundColor(parseColor("#00ff00"));
            seis_tres.setClickable(false);
            siete_tres.setBackgroundColor(parseColor("#00ff00"));
            siete_tres.setClickable(false);
            ocho_tres.setBackgroundColor(parseColor("#00ff00"));
            ocho_tres.setClickable(false);
            nueve_tres.setBackgroundColor(parseColor("#00ff00"));
            nueve_tres.setClickable(false);

            igandea=true;
            contarRojo=0;
        }

        //palabara: BATAILA 4_5-4_11
        if((bataila==false&&
                ((ColorDrawable) cuatro_cinco.getBackground()).getColor()!=parseColor("#FFFFFFFF")&&
                ((ColorDrawable) cuatro_seis.getBackground()).getColor()!=parseColor("#FFFFFFFF")&&
                ((ColorDrawable) cuatro_siete.getBackground()).getColor()!=parseColor("#FFFFFFFF")&&
                ((ColorDrawable) cuatro_ocho.getBackground()).getColor()!=parseColor("#FFFFFFFF")&&
                ((ColorDrawable) cuatro_nueve.getBackground()).getColor()!=parseColor("#FFFFFFFF")&&
                ((ColorDrawable) cuatro_diez.getBackground()).getColor()!=parseColor("#FFFFFFFF")&&
                ((ColorDrawable) cuatro_once.getBackground()).getColor()!=parseColor("#FFFFFFFF")
        )&&(
                (
                        (contarRojo==7)
                )||
                        (
                                (jaia==true&&lehen==true)&&
                                        (contarRojo==5)
                        )||(
                        (jaia==true||lehen==true)&&
                                (contarRojo==6)
                )

        ) ){
            cuatro_cinco.setBackgroundColor(parseColor("#00ff00"));
            cuatro_cinco.setClickable(false);
            cuatro_seis.setBackgroundColor(parseColor("#00ff00"));
            cuatro_seis.setClickable(false);
            cuatro_siete.setBackgroundColor(parseColor("#00ff00"));
            cuatro_siete.setClickable(false);
            cuatro_ocho.setBackgroundColor(parseColor("#00ff00"));
            cuatro_ocho.setClickable(false);
            cuatro_nueve.setBackgroundColor(parseColor("#00ff00"));
            cuatro_nueve.setClickable(false);
            cuatro_diez.setBackgroundColor(parseColor("#00ff00"));
            cuatro_diez.setClickable(false);
            cuatro_once.setBackgroundColor(parseColor("#00ff00"));
            cuatro_once.setClickable(false);

            bataila=true;
            contarRojo=0;
        }

        //palabara: LEHEN 4_10-8_10
        if((lehen==false&&
                ((ColorDrawable) cuatro_diez.getBackground()).getColor()!=parseColor("#FFFFFFFF")&&
                ((ColorDrawable) cinco_diez.getBackground()).getColor()!=parseColor("#FFFFFFFF")&&
                ((ColorDrawable) seis_diez.getBackground()).getColor()!=parseColor("#FFFFFFFF")&&
                ((ColorDrawable) siete_diez.getBackground()).getColor()!=parseColor("#FFFFFFFF")&&
                ((ColorDrawable) ocho_diez.getBackground()).getColor()!=parseColor("#FFFFFFFF")
        )&&(
                (
                        (contarRojo==5)
                )||
                        (
                                (bataila==true)&&
                                        (contarRojo==4)
                        )
        )
        ){
            cuatro_diez.setBackgroundColor(parseColor("#00ff00"));
            cuatro_diez.setClickable(false);
            cinco_diez.setBackgroundColor(parseColor("#00ff00"));
            cinco_diez.setClickable(false);
            seis_diez.setBackgroundColor(parseColor("#00ff00"));
            seis_diez.setClickable(false);
            siete_diez.setBackgroundColor(parseColor("#00ff00"));
            siete_diez.setClickable(false);
            ocho_diez.setBackgroundColor(parseColor("#00ff00"));
            ocho_diez.setClickable(false);

            lehen=true;
            contarRojo=0;
        }

        //palabara: SINBOLO 6_1-6_7
        if((sinbolo==false&&
                ((ColorDrawable) seis_uno.getBackground()).getColor()!=parseColor("#FFFFFFFF")&&
                ((ColorDrawable) seis_dos.getBackground()).getColor()!=parseColor("#FFFFFFFF")&&
                ((ColorDrawable) seis_tres.getBackground()).getColor()!=parseColor("#FFFFFFFF")&&
                ((ColorDrawable) seis_cuatro.getBackground()).getColor()!=parseColor("#FFFFFFFF")&&
                ((ColorDrawable) seis_cinco.getBackground()).getColor()!=parseColor("#FFFFFFFF")&&
                ((ColorDrawable) seis_seis.getBackground()).getColor()!=parseColor("#FFFFFFFF")&&
                ((ColorDrawable) seis_siete.getBackground()).getColor()!=parseColor("#FFFFFFFF")
        )&&(
                (
                        (contarRojo==7)
                )||
                        (
                                (igandea==true&&elorrio==true)&&
                                        (contarRojo==5)
                        )||(
                        (igandea==true||elorrio==true)&&
                                (contarRojo==6)
                )

        )
        ){
            seis_uno.setBackgroundColor(parseColor("#00ff00"));
            seis_uno.setClickable(false);
            seis_dos.setBackgroundColor(parseColor("#00ff00"));
            seis_dos.setClickable(false);
            seis_tres.setBackgroundColor(parseColor("#00ff00"));
            seis_tres.setClickable(false);
            seis_cuatro.setBackgroundColor(parseColor("#00ff00"));
            seis_cuatro.setClickable(false);
            seis_cinco.setBackgroundColor(parseColor("#00ff00"));
            seis_cinco.setClickable(false);
            seis_seis.setBackgroundColor(parseColor("#00ff00"));
            seis_seis.setClickable(false);
            seis_siete.setBackgroundColor(parseColor("#00ff00"));
            seis_siete.setClickable(false);

            sinbolo=true;
            contarRojo=0;
        }

        //palabara: ERREBONBILO 10_1-10_11
        if(errebonbilo==false&&
                ((ColorDrawable) diez_uno.getBackground()).getColor()!=parseColor("#FFFFFFFF")&&
                ((ColorDrawable) diez_dos.getBackground()).getColor()!=parseColor("#FFFFFFFF")&&
                ((ColorDrawable) diez_tres.getBackground()).getColor()!=parseColor("#FFFFFFFF")&&
                ((ColorDrawable) diez_cuatro.getBackground()).getColor()!=parseColor("#FFFFFFFF")&&
                ((ColorDrawable) diez_cinco.getBackground()).getColor()!=parseColor("#FFFFFFFF")&&
                ((ColorDrawable) diez_seis.getBackground()).getColor()!=parseColor("#FFFFFFFF")&&
                ((ColorDrawable) diez_siete.getBackground()).getColor()!=parseColor("#FFFFFFFF")&&
                ((ColorDrawable) diez_ocho.getBackground()).getColor()!=parseColor("#FFFFFFFF")&&
                ((ColorDrawable) diez_nueve.getBackground()).getColor()!=parseColor("#FFFFFFFF")&&
                ((ColorDrawable) diez_diez.getBackground()).getColor()!=parseColor("#FFFFFFFF")&&
                ((ColorDrawable) diez_once.getBackground()).getColor()!=parseColor("#FFFFFFFF")&&
                (contarRojo==11)
        ){
            diez_uno.setBackgroundColor(parseColor("#00ff00"));
            diez_uno.setClickable(false);
            diez_dos.setBackgroundColor(parseColor("#00ff00"));
            diez_dos.setClickable(false);
            diez_tres.setBackgroundColor(parseColor("#00ff00"));
            diez_tres.setClickable(false);
            diez_cuatro.setBackgroundColor(parseColor("#00ff00"));
            diez_cuatro.setClickable(false);
            diez_cinco.setBackgroundColor(parseColor("#00ff00"));
            diez_cinco.setClickable(false);
            diez_seis.setBackgroundColor(parseColor("#00ff00"));
            diez_seis.setClickable(false);
            diez_siete.setBackgroundColor(parseColor("#00ff00"));
            diez_siete.setClickable(false);
            diez_ocho.setBackgroundColor(parseColor("#00ff00"));
            diez_ocho.setClickable(false);
            diez_nueve.setBackgroundColor(parseColor("#00ff00"));
            diez_nueve.setClickable(false);
            diez_diez.setBackgroundColor(parseColor("#00ff00"));
            diez_diez.setClickable(false);
            diez_once.setBackgroundColor(parseColor("#00ff00"));
            diez_once.setClickable(false);

            errebonbilo=true;
            contarRojo=0;
        }

        //palabara: URRIA 11_7-11_11
        if(urria==false&&
                ((ColorDrawable) once_siete.getBackground()).getColor()!=parseColor("#FFFFFFFF")&&
                ((ColorDrawable) once_ocho.getBackground()).getColor()!=parseColor("#FFFFFFFF")&&
                ((ColorDrawable) once_nueve.getBackground()).getColor()!=parseColor("#FFFFFFFF")&&
                ((ColorDrawable) once_diez.getBackground()).getColor()!=parseColor("#FFFFFFFF")&&
                ((ColorDrawable) once_once.getBackground()).getColor()!=parseColor("#FFFFFFFF")&&
                (contarRojo==5)
        ){
            once_siete.setBackgroundColor(parseColor("#00ff00"));
            once_siete.setClickable(false);
            once_ocho.setBackgroundColor(parseColor("#00ff00"));
            once_ocho.setClickable(false);
            once_nueve.setBackgroundColor(parseColor("#00ff00"));
            once_nueve.setClickable(false);
            once_diez.setBackgroundColor(parseColor("#00ff00"));
            once_diez.setClickable(false);
            once_once.setBackgroundColor(parseColor("#00ff00"));
            once_once.setClickable(false);

            urria=true;
            contarRojo=0;
        }

        if(
                lepanto==true&&elorrio==true&&igandea==true&&jaia==true&&bataila==true&&
                        sinbolo==true&&lehen==true&&errebonbilo==true&&urria==true
        ){
            //Intent intent = new Intent(SopaDeLetrasFragment.this, MainActivity.class);
            //intent.putExtra("id", 3);
           // startActivity(intent);
        }




    }

    public TextView[] toArrayAllViews () {
        TextView[]listaTv={uno_uno, uno_dos, uno_tres, uno_cuatro, uno_cinco, uno_seis, uno_siete, uno_ocho, uno_nueve, uno_diez, uno_once,
                dos_uno, dos_dos, dos_tres, dos_cuatro, dos_cinco, dos_seis, dos_siete, dos_ocho, dos_nueve, dos_diez, dos_once,
                tres_uno, tres_dos, tres_tres, tres_cuatro, tres_cinco, tres_seis, tres_siete, tres_ocho, tres_nueve, tres_diez, tres_once,
                cuatro_uno, cuatro_dos, cuatro_tres, cuatro_cuatro, cuatro_cinco, cuatro_seis, cuatro_siete, cuatro_ocho, cuatro_nueve, cuatro_diez, cuatro_once,
                cinco_uno, cinco_dos, cinco_tres, cinco_cuatro, cinco_cinco, cinco_seis, cinco_siete, cinco_ocho, cinco_nueve, cinco_diez, cinco_once,
                seis_uno, seis_dos, seis_tres, seis_cuatro, seis_cinco, seis_seis, seis_siete, seis_ocho, seis_nueve, seis_diez, seis_once,
                siete_uno, siete_dos, siete_tres, siete_cuatro, siete_cinco, siete_seis, siete_siete, siete_ocho, siete_nueve, siete_diez, siete_once,
                ocho_uno, ocho_dos, ocho_tres, ocho_cuatro, ocho_cinco, ocho_seis, ocho_siete, ocho_ocho, ocho_nueve, ocho_diez, ocho_once,
                nueve_uno, nueve_dos, nueve_tres, nueve_cuatro, nueve_cinco, nueve_seis, nueve_siete, nueve_ocho, nueve_nueve, nueve_diez, nueve_once,
                diez_uno, diez_dos, diez_tres, diez_cuatro, diez_cinco, diez_seis, diez_siete, diez_ocho, diez_nueve, diez_diez, diez_once,
                once_uno, once_dos, once_tres, once_cuatro, once_cinco, once_seis, once_siete, once_ocho, once_nueve, once_diez, once_once};

        return listaTv;
    }

    public void idAllViews() {
        uno_uno = getActivity().findViewById(R.id.idSP1_1);
        uno_dos = getActivity().findViewById(R.id.idSP1_2);
        uno_tres = getActivity().findViewById(R.id.idSP1_3);
        uno_cuatro = getActivity().findViewById(R.id.idSP1_4);
        uno_cinco = getActivity().findViewById(R.id.idSP1_5);
        uno_seis = getActivity().findViewById(R.id.idSP1_6);
        uno_siete = getActivity().findViewById(R.id.idSP1_7);
        uno_ocho = getActivity().findViewById(R.id.idSP1_8);
        uno_nueve = getActivity().findViewById(R.id.idSP1_9);
        uno_diez = getActivity().findViewById(R.id.idSP1_10);
        uno_once = getActivity().findViewById(R.id.idSP1_11);

        dos_uno = getActivity().findViewById(R.id.idSP2_1);
        dos_dos = getActivity().findViewById(R.id.idSP2_2);
        dos_tres = getActivity().findViewById(R.id.idSP2_3);
        dos_cuatro = getActivity().findViewById(R.id.idSP2_4);
        dos_cinco = getActivity().findViewById(R.id.idSP2_5);
        dos_seis = getActivity().findViewById(R.id.idSP2_6);
        dos_siete = getActivity().findViewById(R.id.idSP2_7);
        dos_ocho = getActivity().findViewById(R.id.idSP2_8);
        dos_nueve = getActivity().findViewById(R.id.idSP2_9);
        dos_diez = getActivity().findViewById(R.id.idSP2_10);
        dos_once = getActivity().findViewById(R.id.idSP2_11);

        tres_uno = getActivity().findViewById(R.id.idSP3_1);
        tres_dos = getActivity().findViewById(R.id.idSP3_2);
        tres_tres = getActivity().findViewById(R.id.idSP3_3);
        tres_cuatro = getActivity().findViewById(R.id.idSP3_4);
        tres_cinco = getActivity().findViewById(R.id.idSP3_5);
        tres_seis = getActivity().findViewById(R.id.idSP3_6);
        tres_siete = getActivity().findViewById(R.id.idSP3_7);
        tres_ocho = getActivity().findViewById(R.id.idSP3_8);
        tres_nueve = getActivity().findViewById(R.id.idSP3_9);
        tres_diez = getActivity().findViewById(R.id.idSP3_10);
        tres_once = getActivity().findViewById(R.id.idSP3_11);

        cuatro_uno = getActivity().findViewById(R.id.idSP4_1);
        cuatro_dos = getActivity().findViewById(R.id.idSP4_2);
        cuatro_tres = getActivity().findViewById(R.id.idSP4_3);
        cuatro_cuatro = getActivity().findViewById(R.id.idSP4_4);
        cuatro_cinco = getActivity().findViewById(R.id.idSP4_5);
        cuatro_seis = getActivity().findViewById(R.id.idSP4_6);
        cuatro_siete = getActivity().findViewById(R.id.idSP4_7);
        cuatro_ocho = getActivity().findViewById(R.id.idSP4_8);
        cuatro_nueve = getActivity().findViewById(R.id.idSP4_9);
        cuatro_diez = getActivity().findViewById(R.id.idSP4_10);
        cuatro_once = getActivity().findViewById(R.id.idSP4_11);

        cinco_uno = getActivity().findViewById(R.id.idSP5_1);
        cinco_dos = getActivity().findViewById(R.id.idSP5_2);
        cinco_tres = getActivity().findViewById(R.id.idSP5_3);
        cinco_cuatro = getActivity().findViewById(R.id.idSP5_4);
        cinco_cinco = getActivity().findViewById(R.id.idSP5_5);
        cinco_seis = getActivity().findViewById(R.id.idSP5_6);
        cinco_siete = getActivity().findViewById(R.id.idSP5_7);
        cinco_ocho = getActivity().findViewById(R.id.idSP5_8);
        cinco_nueve = getActivity().findViewById(R.id.idSP5_9);
        cinco_diez = getActivity().findViewById(R.id.idSP5_10);
        cinco_once = getActivity().findViewById(R.id.idSP5_11);

        seis_uno = getActivity().findViewById(R.id.idSP6_1);
        seis_dos = getActivity().findViewById(R.id.idSP6_2);
        seis_tres = getActivity().findViewById(R.id.idSP6_3);
        seis_cuatro = getActivity().findViewById(R.id.idSP6_4);
        seis_cinco = getActivity().findViewById(R.id.idSP6_5);
        seis_seis = getActivity().findViewById(R.id.idSP6_6);
        seis_siete = getActivity().findViewById(R.id.idSP6_7);
        seis_ocho = getActivity().findViewById(R.id.idSP6_8);
        seis_nueve = getActivity().findViewById(R.id.idSP6_9);
        seis_diez = getActivity().findViewById(R.id.idSP6_10);
        seis_once = getActivity().findViewById(R.id.idSP6_11);

        siete_uno = getActivity().findViewById(R.id.idSP7_1);
        siete_dos = getActivity().findViewById(R.id.idSP7_2);
        siete_tres = getActivity().findViewById(R.id.idSP7_3);
        siete_cuatro = getActivity().findViewById(R.id.idSP7_4);
        siete_cinco = getActivity().findViewById(R.id.idSP7_5);
        siete_seis = getActivity().findViewById(R.id.idSP7_6);
        siete_siete = getActivity().findViewById(R.id.idSP7_7);
        siete_ocho = getActivity().findViewById(R.id.idSP7_8);
        siete_nueve = getActivity().findViewById(R.id.idSP7_9);
        siete_diez = getActivity().findViewById(R.id.idSP7_10);
        siete_once = getActivity().findViewById(R.id.idSP7_11);

        ocho_uno = getActivity().findViewById(R.id.idSP8_1);
        ocho_dos = getActivity().findViewById(R.id.idSP8_2);
        ocho_tres = getActivity().findViewById(R.id.idSP8_3);
        ocho_cuatro = getActivity().findViewById(R.id.idSP8_4);
        ocho_cinco = getActivity().findViewById(R.id.idSP8_5);
        ocho_seis = getActivity().findViewById(R.id.idSP8_6);
        ocho_siete = getActivity().findViewById(R.id.idSP8_7);
        ocho_ocho = getActivity().findViewById(R.id.idSP8_8);
        ocho_nueve = getActivity().findViewById(R.id.idSP8_9);
        ocho_diez = getActivity().findViewById(R.id.idSP8_10);
        ocho_once = getActivity().findViewById(R.id.idSP8_11);

        nueve_uno = getActivity().findViewById(R.id.idSP9_1);
        nueve_dos = getActivity().findViewById(R.id.idSP9_2);
        nueve_tres = getActivity().findViewById(R.id.idSP9_3);
        nueve_cuatro = getActivity().findViewById(R.id.idSP9_4);
        nueve_cinco = getActivity().findViewById(R.id.idSP9_5);
        nueve_seis = getActivity().findViewById(R.id.idSP9_6);
        nueve_siete = getActivity().findViewById(R.id.idSP9_7);
        nueve_ocho = getActivity().findViewById(R.id.idSP9_8);
        nueve_nueve = getActivity().findViewById(R.id.idSP9_9);
        nueve_diez = getActivity().findViewById(R.id.idSP9_10);
        nueve_once = getActivity().findViewById(R.id.idSP9_11);

        diez_uno = getActivity().findViewById(R.id.idSP10_1);
        diez_dos = getActivity().findViewById(R.id.idSP10_2);
        diez_tres = getActivity().findViewById(R.id.idSP10_3);
        diez_cuatro = getActivity().findViewById(R.id.idSP10_4);
        diez_cinco = getActivity().findViewById(R.id.idSP10_5);
        diez_seis = getActivity().findViewById(R.id.idSP10_6);
        diez_siete = getActivity().findViewById(R.id.idSP10_7);
        diez_ocho = getActivity().findViewById(R.id.idSP10_8);
        diez_nueve = getActivity().findViewById(R.id.idSP10_9);
        diez_diez = getActivity().findViewById(R.id.idSP10_10);
        diez_once = getActivity().findViewById(R.id.idSP10_11);

        once_uno = getActivity().findViewById(R.id.idSP11_1);
        once_dos = getActivity().findViewById(R.id.idSP11_2);
        once_tres = getActivity().findViewById(R.id.idSP11_3);
        once_cuatro = getActivity().findViewById(R.id.idSP11_4);
        once_cinco = getActivity().findViewById(R.id.idSP11_5);
        once_seis = getActivity().findViewById(R.id.idSP11_6);
        once_siete = getActivity().findViewById(R.id.idSP11_7);
        once_ocho = getActivity().findViewById(R.id.idSP11_8);
        once_nueve = getActivity().findViewById(R.id.idSP11_9);
        once_diez = getActivity().findViewById(R.id.idSP11_10);
        once_once = getActivity().findViewById(R.id.idSP11_11);

    }
}