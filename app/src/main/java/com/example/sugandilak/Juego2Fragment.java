package com.example.sugandilak;

import static androidx.appcompat.content.res.AppCompatResources.getDrawable;
import static androidx.core.app.NotificationCompat.getColor;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.android.material.card.MaterialCardView;


public class Juego2Fragment extends Fragment implements View.OnLongClickListener{
    private MaterialCardView card1, card2, card3, card4, card5, card6, card7, card8, card9;
    private ImageView img1, img2, img3, img4, img5, img6, img7, img8, img9;
    private MaterialCardView recogida;
    private MediaPlayer audioVidaBerriotxoa;
    private SeekBar seekBar;
    private Handler handler = new Handler();
    private ImageButton play, next10, back10;
    TextView minPrin, minFinal;
    int contador = 0;

    public Juego2Fragment() {
        // Required empty public constructor
    }


    public static Juego2Fragment getInstance() {
        Juego2Fragment fragment = new Juego2Fragment();
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
        View v = inflater.inflate(R.layout.fragment_juego2, container, false);

        audioVidaBerriotxoa = MediaPlayer.create(getActivity(), R.raw.berriotxoa);
        seekBar = v.findViewById(R.id.seekBar);
        play = v.findViewById(R.id.idButPlay);
        next10 = v.findViewById(R.id.idButMas10);
        back10 = v.findViewById(R.id.idButMenos10);

        minPrin = v.findViewById(R.id.idTvPrin);
        minFinal = v.findViewById(R.id.idTvFin);

        setupSeekBar();

        card1 = v.findViewById(R.id.idCardOp1);
        card2 = v.findViewById(R.id.idCardOp2);
        card3 = v.findViewById(R.id.idCardOp3);
        card4 = v.findViewById(R.id.idCardOp4);
        card5 = v.findViewById(R.id.idCardOp5);
        card6 = v.findViewById(R.id.idCardOp6);
        card7 = v.findViewById(R.id.idCardOp7);
        card8 = v.findViewById(R.id.idCardOp8);
        card9 = v.findViewById(R.id.idCardOp9);

        card1.setOnLongClickListener(this);
        card2.setOnLongClickListener(this);
        card3.setOnLongClickListener(this);
        card4.setOnLongClickListener(this);
        card5.setOnLongClickListener(this);
        card6.setOnLongClickListener(this);
        card7.setOnLongClickListener(this);
        card8.setOnLongClickListener(this);
        card9.setOnLongClickListener(this);

        img1 = v.findViewById(R.id.idImgCam1);
        img2 = v.findViewById(R.id.idImgCam2);
        img3 = v.findViewById(R.id.idImgCam3);
        img4 = v.findViewById(R.id.idImgCam4);
        img5 = v.findViewById(R.id.idImgCam5);
        img6 = v.findViewById(R.id.idImgCam6);
        img7 = v.findViewById(R.id.idImgCam7);
        img8 = v.findViewById(R.id.idImgCam8);
        img9 = v.findViewById(R.id.idImgCam9);


        img1.setOnDragListener(drag);
        img2.setOnDragListener(drag);
        img3.setOnDragListener(drag);
        img4.setOnDragListener(drag);
        img5.setOnDragListener(drag);
        img6.setOnDragListener(drag);
        img7.setOnDragListener(drag);
        img8.setOnDragListener(drag);
        img9.setOnDragListener(drag);


        audioVidaBerriotxoa.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Drawable d = ContextCompat.getDrawable(getActivity().getApplicationContext(),R.drawable.play);
                play.setImageDrawable(d);
            }
        });
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (audioVidaBerriotxoa.isPlaying()) {
                    audioVidaBerriotxoa.pause();
                    Drawable d = ContextCompat.getDrawable(getActivity().getApplicationContext(),R.drawable.play);
                    play.setImageDrawable(d);
                } else {
                    audioVidaBerriotxoa.start();
                    Drawable d = ContextCompat.getDrawable(getActivity().getApplicationContext(),R.drawable.pause);
                    play.setImageDrawable(d);
                    updateSeekBar();
                }
            }
        });

        next10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                audioVidaBerriotxoa.seekTo(audioVidaBerriotxoa.getCurrentPosition()+10000);
                updateSeekBar();
            }
        });

        back10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                audioVidaBerriotxoa.seekTo(audioVidaBerriotxoa.getCurrentPosition()-10000);
                updateSeekBar();
            }
        });

        return v;
    }

    private void setupSeekBar() {
        seekBar.setMax(audioVidaBerriotxoa.getDuration());


        audioVidaBerriotxoa.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                seekBar.setMax(audioVidaBerriotxoa.getDuration());
                audioVidaBerriotxoa.start();
                minFinal.setText(String.valueOf(convertTime(audioVidaBerriotxoa.getDuration())));
                updateSeekBar();
            }
        });


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    minPrin.setText(String.valueOf(convertTime(progress)));
                    audioVidaBerriotxoa.seekTo(progress);
                }
            }


            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                handler.removeCallbacks(updateSeekBarRunnable);
            }


            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                updateSeekBar();
            }
        });
    }


    String convertTime(int duration) {
        String cadena = "";
        int minutos = duration / 60000;
        int segundos = (duration -(minutos*60000))/1000;
        String segundosS = String.valueOf(segundos);
        if(segundosS.length() == 1){
            segundosS = "0"+segundosS;
        }
        cadena = minutos+":"+segundosS;
        return cadena;
    };


    private Runnable updateSeekBarRunnable = new Runnable() {
        @Override
        public void run() {
            updateSeekBar();
        }
    };


    private void updateSeekBar() {
        minPrin.setText(String.valueOf(convertTime(audioVidaBerriotxoa.getCurrentPosition())));
        seekBar.setProgress(audioVidaBerriotxoa.getCurrentPosition());
        handler.postDelayed(updateSeekBarRunnable, 100);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        audioVidaBerriotxoa.release();
        handler.removeCallbacks(updateSeekBarRunnable);
    }


    @Override
    public boolean onLongClick(View v) {
        recogida = (MaterialCardView) v;
        ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());
        ClipData dragData = new ClipData(
                (CharSequence) v.getTag(),
                new String[]{ClipDescription.MIMETYPE_TEXT_PLAIN},
                item);
        View.DragShadowBuilder myShadow = new View.DragShadowBuilder(v);
        v.startDragAndDrop(dragData,
                myShadow,
                null,
                0
        );
        return true;
    }


    View.OnDragListener drag = (v, event) -> {

        int dragEvent = event.getAction();
        switch (dragEvent) {
            case DragEvent.ACTION_DROP:
                if (v.getId() == R.id.idImgCam1 && recogida.getId() == R.id.idCardOp1) {
                    ImageView imagenSoltar = getActivity().findViewById(R.id.idImgOp1);
                    ImageView imgCamino = (ImageView) v;
                    imgCamino.setImageDrawable(imagenSoltar.getDrawable());
                    recogida.setVisibility(View.INVISIBLE);
                    MaterialCardView cardCamino = getActivity().findViewById(R.id.idCardCam1);
                    int colorCorrecta = ContextCompat.getColor(getActivity().getApplicationContext(), R.color.green);
                    cardCamino.setStrokeColor(colorCorrecta);
                    contador++;

                } else if (v.getId() == R.id.idImgCam2 && recogida.getId() == R.id.idCardOp2) {
                    ImageView imagenSoltar = getActivity().findViewById(R.id.idImgOp2);
                    ImageView imgCamino = (ImageView) v;
                    imgCamino.setImageDrawable(imagenSoltar.getDrawable());
                    recogida.setVisibility(View.INVISIBLE);
                    MaterialCardView cardCamino = getActivity().findViewById(R.id.idCardCam2);
                    int colorCorrecta = ContextCompat.getColor(getActivity().getApplicationContext(), R.color.green);
                    cardCamino.setStrokeColor(colorCorrecta);
                    contador++;

                } else if (v.getId() == R.id.idImgCam3 && recogida.getId() == R.id.idCardOp3) {
                    ImageView imagenSoltar = getActivity().findViewById(R.id.idImgOp3);
                    ImageView imgCamino = (ImageView) v;
                    imgCamino.setImageDrawable(imagenSoltar.getDrawable());
                    recogida.setVisibility(View.INVISIBLE);
                    MaterialCardView cardCamino = getActivity().findViewById(R.id.idCardCam3);
                    int colorCorrecta = ContextCompat.getColor(getActivity().getApplicationContext(), R.color.green);
                    cardCamino.setStrokeColor(colorCorrecta);
                    contador++;

                } else if (v.getId() == R.id.idImgCam4 && recogida.getId() == R.id.idCardOp4) {
                    ImageView imagenSoltar = getActivity().findViewById(R.id.idImgOp4);
                    ImageView imgCamino = (ImageView) v;
                    imgCamino.setImageDrawable(imagenSoltar.getDrawable());
                    recogida.setVisibility(View.INVISIBLE);
                    MaterialCardView cardCamino = getActivity().findViewById(R.id.idCardCam4);
                    int colorCorrecta = ContextCompat.getColor(getActivity().getApplicationContext(), R.color.green);
                    cardCamino.setStrokeColor(colorCorrecta);
                    contador++;

                } else if (v.getId() == R.id.idImgCam5 && recogida.getId() == R.id.idCardOp5) {
                    ImageView imagenSoltar = getActivity().findViewById(R.id.idImgOp5);
                    ImageView imgCamino = (ImageView) v;
                    imgCamino.setImageDrawable(imagenSoltar.getDrawable());
                    recogida.setVisibility(View.INVISIBLE);
                    MaterialCardView cardCamino = getActivity().findViewById(R.id.idCardCam5);
                    int colorCorrecta = ContextCompat.getColor(getActivity().getApplicationContext(), R.color.green);
                    cardCamino.setStrokeColor(colorCorrecta);
                    contador++;

                } else if (v.getId() == R.id.idImgCam6 && recogida.getId() == R.id.idCardOp6) {
                    ImageView imagenSoltar = getActivity().findViewById(R.id.idImgOp6);
                    ImageView imgCamino = (ImageView) v;
                    imgCamino.setImageDrawable(imagenSoltar.getDrawable());
                    recogida.setVisibility(View.INVISIBLE);
                    MaterialCardView cardCamino = getActivity().findViewById(R.id.idCardCam6);
                    int colorCorrecta = ContextCompat.getColor(getActivity().getApplicationContext(), R.color.green);
                    cardCamino.setStrokeColor(colorCorrecta);
                    contador++;

                } else if (v.getId() == R.id.idImgCam7 && recogida.getId() == R.id.idCardOp7) {
                    ImageView imagenSoltar = getActivity().findViewById(R.id.idImgOp7);
                    ImageView imgCamino = (ImageView) v;
                    imgCamino.setImageDrawable(imagenSoltar.getDrawable());
                    recogida.setVisibility(View.INVISIBLE);
                    MaterialCardView cardCamino = getActivity().findViewById(R.id.idCardCam7);
                    int colorCorrecta = ContextCompat.getColor(getActivity().getApplicationContext(), R.color.green);
                    cardCamino.setStrokeColor(colorCorrecta);
                    contador++;

                } else if (v.getId() == R.id.idImgCam8 && recogida.getId() == R.id.idCardOp8) {
                    ImageView imagenSoltar = getActivity().findViewById(R.id.idImgOp8);
                    ImageView imgCamino = (ImageView) v;
                    imgCamino.setImageDrawable(imagenSoltar.getDrawable());
                    recogida.setVisibility(View.INVISIBLE);
                    MaterialCardView cardCamino = getActivity().findViewById(R.id.idCardCam8);
                    int colorCorrecta = ContextCompat.getColor(getActivity().getApplicationContext(), R.color.green);
                    cardCamino.setStrokeColor(colorCorrecta);
                    contador++;

                } else if (v.getId() == R.id.idImgCam9 && recogida.getId() == R.id.idCardOp9) {
                    ImageView imagenSoltar = getActivity().findViewById(R.id.idImgOp9);
                    ImageView imgCamino = (ImageView) v;
                    imgCamino.setImageDrawable(imagenSoltar.getDrawable());
                    recogida.setVisibility(View.INVISIBLE);
                    MaterialCardView cardCamino = getActivity().findViewById(R.id.idCardCam9);
                    int colorCorrecta = ContextCompat.getColor(getActivity().getApplicationContext(), R.color.green);
                    cardCamino.setStrokeColor(colorCorrecta);
                    contador++;

                } else {

                }
        }
        comprobar();
        return true;
    };

    void comprobar(){
        if(contador == 9){
            audioVidaBerriotxoa.stop();
            getActivity().getSupportFragmentManager().beginTransaction().remove(Juego2Fragment.this).commit();
            ((MainActivity2) getActivity()).volverMapa(2);
        }
    }
}