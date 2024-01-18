package com.example.sugandilak;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.res.ResourcesCompat;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.card.MaterialCardView;

public class Pantalla2VidaDeSanValentin extends AppCompatActivity implements View.OnLongClickListener {

    private MaterialCardView card1, card2, card3, card4, card5, card6, card7, card8, card9;
    private ImageView img1, img2, img3, img4, img5, img6, img7, img8, img9;
    private MaterialCardView recogida;
    private MediaPlayer audioVidaBerriotxoa;
    private SeekBar seekBar;
    private Handler handler = new Handler();
    private ImageButton play, next10, back10;
    TextView minPrin, minFinal;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2_vida_de_san_valentin);

        audioVidaBerriotxoa = MediaPlayer.create(this, R.raw.berriotxoa);
        seekBar = findViewById(R.id.seekBar);
        play = findViewById(R.id.idButPlay);
        next10 = findViewById(R.id.idButMas10);
        back10 = findViewById(R.id.idButMenos10);

        minPrin = findViewById(R.id.idTvPrin);
        minFinal = findViewById(R.id.idTvFin);

        setupSeekBar();

        card1 = findViewById(R.id.idCardOp1);
        card2 = findViewById(R.id.idCardOp2);
        card3 = findViewById(R.id.idCardOp3);
        card4 = findViewById(R.id.idCardOp4);
        card5 = findViewById(R.id.idCardOp5);
        card6 = findViewById(R.id.idCardOp6);
        card7 = findViewById(R.id.idCardOp7);
        card8 = findViewById(R.id.idCardOp8);
        card9 = findViewById(R.id.idCardOp9);

        card1.setOnLongClickListener(this);
        card2.setOnLongClickListener(this);
        card3.setOnLongClickListener(this);
        card4.setOnLongClickListener(this);
        card5.setOnLongClickListener(this);
        card6.setOnLongClickListener(this);
        card7.setOnLongClickListener(this);
        card8.setOnLongClickListener(this);
        card9.setOnLongClickListener(this);

        img1 = findViewById(R.id.idImgCam1);
        img2 = findViewById(R.id.idImgCam2);
        img3 = findViewById(R.id.idImgCam3);
        img4 = findViewById(R.id.idImgCam4);
        img5 = findViewById(R.id.idImgCam5);
        img6 = findViewById(R.id.idImgCam6);
        img7 = findViewById(R.id.idImgCam7);
        img8 = findViewById(R.id.idImgCam8);
        img9 = findViewById(R.id.idImgCam9);


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
                play.setImageDrawable(getDrawable(R.drawable.play));
            }
        });
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (audioVidaBerriotxoa.isPlaying()) {
                    audioVidaBerriotxoa.pause();
                    play.setImageDrawable(getDrawable(R.drawable.play));
                } else {
                    audioVidaBerriotxoa.start();
                    play.setImageDrawable(getDrawable(R.drawable.pause));
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
    protected void onDestroy() {
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
                    ImageView imagenSoltar = findViewById(R.id.idImgOp1);
                    ImageView imgCamino = (ImageView) v;
                    imgCamino.setImageDrawable(imagenSoltar.getDrawable());
                    recogida.setVisibility(View.INVISIBLE);
                    MaterialCardView cardCamino = findViewById(R.id.idCardCam1);
                    int colorCorrecta = getColor(R.color.green);
                    cardCamino.setStrokeColor(colorCorrecta);

                } else if (v.getId() == R.id.idImgCam2 && recogida.getId() == R.id.idCardOp2) {
                    ImageView imagenSoltar = findViewById(R.id.idImgOp2);
                    ImageView imgCamino = (ImageView) v;
                    imgCamino.setImageDrawable(imagenSoltar.getDrawable());
                    recogida.setVisibility(View.INVISIBLE);
                    MaterialCardView cardCamino = findViewById(R.id.idCardCam2);
                    int colorCorrecta = getColor(R.color.green);
                    cardCamino.setStrokeColor(colorCorrecta);

                } else if (v.getId() == R.id.idImgCam3 && recogida.getId() == R.id.idCardOp3) {
                    ImageView imagenSoltar = findViewById(R.id.idImgOp3);
                    ImageView imgCamino = (ImageView) v;
                    imgCamino.setImageDrawable(imagenSoltar.getDrawable());
                    recogida.setVisibility(View.INVISIBLE);
                    MaterialCardView cardCamino = findViewById(R.id.idCardCam3);
                    int colorCorrecta = getColor(R.color.green);
                    cardCamino.setStrokeColor(colorCorrecta);

                } else if (v.getId() == R.id.idImgCam4 && recogida.getId() == R.id.idCardOp4) {
                    ImageView imagenSoltar = findViewById(R.id.idImgOp4);
                    ImageView imgCamino = (ImageView) v;
                    imgCamino.setImageDrawable(imagenSoltar.getDrawable());
                    recogida.setVisibility(View.INVISIBLE);
                    MaterialCardView cardCamino = findViewById(R.id.idCardCam4);
                    int colorCorrecta = getColor(R.color.green);
                    cardCamino.setStrokeColor(colorCorrecta);

                } else if (v.getId() == R.id.idImgCam5 && recogida.getId() == R.id.idCardOp5) {
                    ImageView imagenSoltar = findViewById(R.id.idImgOp5);
                    ImageView imgCamino = (ImageView) v;
                    imgCamino.setImageDrawable(imagenSoltar.getDrawable());
                    recogida.setVisibility(View.INVISIBLE);
                    MaterialCardView cardCamino = findViewById(R.id.idCardCam5);
                    int colorCorrecta = getColor(R.color.green);
                    cardCamino.setStrokeColor(colorCorrecta);

                } else if (v.getId() == R.id.idImgCam6 && recogida.getId() == R.id.idCardOp6) {
                    ImageView imagenSoltar = findViewById(R.id.idImgOp6);
                    ImageView imgCamino = (ImageView) v;
                    imgCamino.setImageDrawable(imagenSoltar.getDrawable());
                    recogida.setVisibility(View.INVISIBLE);
                    MaterialCardView cardCamino = findViewById(R.id.idCardCam6);
                    int colorCorrecta = getColor(R.color.green);
                    cardCamino.setStrokeColor(colorCorrecta);

                } else if (v.getId() == R.id.idImgCam7 && recogida.getId() == R.id.idCardOp7) {
                    ImageView imagenSoltar = findViewById(R.id.idImgOp7);
                    ImageView imgCamino = (ImageView) v;
                    imgCamino.setImageDrawable(imagenSoltar.getDrawable());
                    recogida.setVisibility(View.INVISIBLE);
                    MaterialCardView cardCamino = findViewById(R.id.idCardCam7);
                    int colorCorrecta = getColor(R.color.green);
                    cardCamino.setStrokeColor(colorCorrecta);

                } else if (v.getId() == R.id.idImgCam8 && recogida.getId() == R.id.idCardOp8) {
                    ImageView imagenSoltar = findViewById(R.id.idImgOp8);
                    ImageView imgCamino = (ImageView) v;
                    imgCamino.setImageDrawable(imagenSoltar.getDrawable());
                    recogida.setVisibility(View.INVISIBLE);
                    MaterialCardView cardCamino = findViewById(R.id.idCardCam8);
                    int colorCorrecta = getColor(R.color.green);
                    cardCamino.setStrokeColor(colorCorrecta);

                } else if (v.getId() == R.id.idImgCam9 && recogida.getId() == R.id.idCardOp9) {
                    ImageView imagenSoltar = findViewById(R.id.idImgOp9);
                    ImageView imgCamino = (ImageView) v;
                    imgCamino.setImageDrawable(imagenSoltar.getDrawable());
                    recogida.setVisibility(View.INVISIBLE);
                    MaterialCardView cardCamino = findViewById(R.id.idCardCam9);
                    int colorCorrecta = getColor(R.color.green);
                    cardCamino.setStrokeColor(colorCorrecta);

                } else {

                }
        }
        return true;
    };
}
