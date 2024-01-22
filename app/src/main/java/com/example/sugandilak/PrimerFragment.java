package com.example.sugandilak;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Collections;

public class PrimerFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    private ImageButton el0, el1, el2, el3, el4, el5, el6, el7, el8, el9, el10, el11, el12, el13, el14, el15;
    private Button reiniciar, salir;
    private int imagenes[];
    private ImageButton[] botonera = new ImageButton[16];
    private int fondo;
    private ArrayList<Integer> arrayBarajado;
    private ImageButton primero;
    private int numeroPrimero, numeroSegundo;
    private boolean bloqueo = false;
    private final Handler handler = new Handler();
    private int aciertos = 0;
    private int puntuacion = 0;
    private TextView textoPuntuacion;

    public PrimerFragment() {
        // Required empty public constructor
    }


    public static PrimerFragment getInstance() {
        PrimerFragment fragment = new PrimerFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cargarImagenes();

    }

    public void cargarImagenes() {
        imagenes = new int[]{
                R.drawable.carta1,
                R.drawable.carta2,
                R.drawable.carta3,
                R.drawable.carta4,
                R.drawable.carta5,
                R.drawable.carta6,
                R.drawable.carta7,
                R.drawable.carta8,
        };

        fondo = R.drawable.cartavuelta;
    }

    public ArrayList<Integer> barajar(int longitud) {
        ArrayList<Integer> resultadoA = new ArrayList<>();
        for (int i = 0; i < longitud; i++)
            resultadoA.add(i % longitud / 2);
        Collections.shuffle(resultadoA);
        return resultadoA;
    }





    public void comprobar(int i, final ImageButton imgb) {

        if(primero==null){//ningún botón ha sido pulsado
            //el botón primero será el que acabamos de pulsar
            primero = imgb;
            /*le asignamos la imagen del vector imágenes situada
            en la posición vectorBarajado[i], que tendrá un valor entre 0 y 7*/
            primero.setScaleType(ImageView.ScaleType.CENTER_CROP);
            primero.setImageResource(imagenes[arrayBarajado.get(i)]);
            //bloqueamos el botón
            primero.setEnabled(false);
            //almacenamos el valor de vectorBarajado[i]
            numeroPrimero=arrayBarajado.get(i);
        }else{//ya hay un botón descubierto
            //bloqueamos todos los demás
            bloqueo=true;
            //el botón segundo será el que acabamos de pulsar
            /*le asignamos la imagen del vector imágenes situada
            en la posición vectorBarajado[i], que tendrá un valor entre 0 y 7*/
            imgb.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imgb.setImageResource(imagenes[arrayBarajado.get(i)]);
            //bloqueamos el botón
            imgb.setEnabled(false);
            //almacenamos el valor de vectorBarajado[i]
            numeroSegundo=arrayBarajado.get(i);
            //if(primero.getDrawable().getConstantState().equals(imgb.getDrawable().getConstantState())){
            if(numeroPrimero==numeroSegundo){//si coincide el valor los dejamos destapados
                //reiniciamos
                primero=null;
                bloqueo=false;
                //aumentamos los aciertos y la puntuación
                aciertos++;
                puntuacion++;
                textoPuntuacion.setText("Puntuación: " + puntuacion);
                //al llegar a8 aciertos se ha ganado el juego
                if(aciertos==8){
                    System.out.println("Has ganado");

                }
            }else{//si NO coincide el valor los volvemos a tapar al cabo de un segundo
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //les ponemos la imagen de fondo
                        primero.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        primero.setImageResource(R.drawable.cartavuelta);
                        imgb.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        imgb.setImageResource(R.drawable.cartavuelta);
                        //los volvemos a habilitar
                        primero.setEnabled(true);
                        imgb.setEnabled(true);
                        //reiniciamos la variables auxiliaares
                        primero = null;
                        bloqueo = false;
                        //restamos uno a la puntuación
                        if (puntuacion > 0) {
                            puntuacion--;
                            textoPuntuacion.setText("Puntuación: " + puntuacion);
                        }
                    }
                }, 1000);//al cabo de un segundo
            }
        }

    }
    public void iniciar() {
        arrayBarajado = barajar(imagenes.length*2);


        //MOSTRAMOS LA IMAGEN
        for(int i=0; i<botonera.length; i++) {
            botonera[i].setScaleType(ImageView.ScaleType.CENTER_CROP);
            botonera[i].setImageResource(imagenes[arrayBarajado.get(i)]);
        }

        //Y EN UN SEGUNDO LA OCULTAMOS
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < botonera.length; i++) {
                    botonera[i].setScaleType(ImageView.ScaleType.CENTER_CROP);
                    botonera[i].setImageResource(fondo);
                }
            }
        }, 1000);

        //AÑADIMOS LOS EVENTOS A LOS BOTONES DEL JUEGO
        for(int i=0; i <arrayBarajado.size(); i++){
            final int j=i;
            botonera[i].setEnabled(true);
            botonera[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(!bloqueo)
                        comprobar(j, botonera[j]);
                }
            });
        }
        aciertos=0;
        puntuacion=0;
        textoPuntuacion.setText("Puntuación: " + puntuacion);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_primer, container, false);
        el0 = (ImageButton) view.findViewById(R.id.boton00);
        botonera[0] = el0;
        el1 = (ImageButton) view.findViewById(R.id.boton01);
        botonera[1] = el1;
        el2 = (ImageButton) view.findViewById(R.id.boton02);
        botonera[2] = el2;
        el3 = (ImageButton) view.findViewById(R.id.boton03);
        botonera[3] = el3;
        el4 = (ImageButton) view.findViewById(R.id.boton04);
        botonera[4] = el4;
        el5 = (ImageButton) view.findViewById(R.id.boton05);
        botonera[5] = el5;
        el6 = (ImageButton) view.findViewById(R.id.boton06);
        botonera[6] = el6;
        el7 = (ImageButton) view.findViewById(R.id.boton07);
        botonera[7] = el7;
        el8 = (ImageButton) view.findViewById(R.id.boton08);
        botonera[8] = el8;
        el9 = (ImageButton) view.findViewById(R.id.boton09);
        botonera[9] = el9;
        el10 = (ImageButton) view.findViewById(R.id.boton10);
        botonera[10] = el10;
        el11 = (ImageButton) view.findViewById(R.id.boton11);
        botonera[11] = el11;
        el12 = (ImageButton) view.findViewById(R.id.boton12);
        botonera[12] = el12;
        el13 = (ImageButton) view.findViewById(R.id.boton13);
        botonera[13] = el13;
        el14 = (ImageButton) view.findViewById(R.id.boton14);
        botonera[14] = el14;
        el15 = (ImageButton) view.findViewById(R.id.boton15);
        botonera[15] = el15;

        textoPuntuacion = (TextView)view.findViewById(R.id.textoPuntuacion);
        textoPuntuacion.setText("Puntuación: " + puntuacion);

        iniciar();

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // You can add any additional view-related setup here
    }
}
