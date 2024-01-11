package com.example.sugandilak;

import android.content.ClipData;
import android.content.ClipDescription;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.DragEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Pantalla2VidaDeSanValentin extends AppCompatActivity implements View.OnLongClickListener {

    private ImageView imas;
    private ImageView imas2, imas3, imas4, imas5, imas6, imas7, imas8, imas9;
    private TextView tv, tv2, tv3, tv4, tv5, tv6, tv7, tv8, tv9;
    private ImageView recogida;
    private MediaPlayer mediaPlayer1;
    private MediaPlayer mediaPlayer2;
    private MediaPlayer mediaPlayer3;
    private MediaPlayer currentMediaPlayer;
    private ImageView imageView;
    private SeekBar seekBar;
    private Handler handler = new Handler();
    private Button changeAudioButton1;
    private Button changeAudioButton2;
    private Button changeAudioButton3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2_vida_de_san_valentin);

        mediaPlayer1 = MediaPlayer.create(this, R.raw.berriotxoa1);
        mediaPlayer2 = MediaPlayer.create(this, R.raw.berriotxoa2);
        mediaPlayer3 = MediaPlayer.create(this, R.raw.berriotxoa3);

        currentMediaPlayer = mediaPlayer1; // Initially, set the first MediaPlayer
        imageView = findViewById(R.id.imageView);
        seekBar = findViewById(R.id.seekBar);
        changeAudioButton1 = findViewById(R.id.id_changeaudio1);
        changeAudioButton2 = findViewById(R.id.id_changeaudio2);
        changeAudioButton3 = findViewById(R.id.id_changeaudio3);

        setupSeekBar();

        imas = findViewById(R.id.idImagensiu);
        imas2 = findViewById(R.id.idImagensiu2);
        imas3 = findViewById(R.id.idImagensiu3);
        imas4 = findViewById(R.id.idImagensiu4);
        imas5 = findViewById(R.id.idImagensiu5);
        imas6 = findViewById(R.id.idImagensiu6);
        imas7 = findViewById(R.id.idImagensiu7);
        imas8 = findViewById(R.id.idImagensiu8);
        imas9 = findViewById(R.id.idImagensiu9);

        tv = findViewById(R.id.idtv1);
        tv2 = findViewById(R.id.idtv2);
        tv3 = findViewById(R.id.idtv3);
        tv4 = findViewById(R.id.idtv4);
        tv5 = findViewById(R.id.idtv5);
        tv6 = findViewById(R.id.idtv6);
        tv7 = findViewById(R.id.idtv7);
        tv8 = findViewById(R.id.idtv8);
        tv9 = findViewById(R.id.idtv9);

        imas.setOnLongClickListener(this);
        imas2.setOnLongClickListener(this);
        imas3.setOnLongClickListener(this);
        imas4.setOnLongClickListener(this);
        imas5.setOnLongClickListener(this);
        imas6.setOnLongClickListener(this);
        imas7.setOnLongClickListener(this);
        imas8.setOnLongClickListener(this);
        imas9.setOnLongClickListener(this);

        tv.setOnDragListener(drag);
        tv2.setOnDragListener(drag);
        tv3.setOnDragListener(drag);
        tv4.setOnDragListener(drag);
        tv5.setOnDragListener(drag);
        tv6.setOnDragListener(drag);
        tv7.setOnDragListener(drag);
        tv8.setOnDragListener(drag);
        tv9.setOnDragListener(drag);

        changeAudioButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle button click
            }
        });

        changeAudioButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle button click
            }
        });

        changeAudioButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentMediaPlayer.isPlaying()) {
                    currentMediaPlayer.pause();
                } else {
                    currentMediaPlayer.start();
                    updateSeekBar();
                }
            }
        });
    }

    private void setupSeekBar() {
        seekBar.setMax(currentMediaPlayer.getDuration());

        currentMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                seekBar.setMax(currentMediaPlayer.getDuration());
                currentMediaPlayer.start();
                updateSeekBar();
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    currentMediaPlayer.seekTo(progress);
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

    private void changeMediaPlayerPosition(int position) {
        if (currentMediaPlayer != null) {
            currentMediaPlayer.seekTo(position);
        }
    }

    private Runnable updateSeekBarRunnable = new Runnable() {
        @Override
        public void run() {
            updateSeekBar();
        }
    };

    private void updateSeekBar() {
        seekBar.setProgress(currentMediaPlayer.getCurrentPosition());
        handler.postDelayed(updateSeekBarRunnable, 100);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mediaPlayer1.release();
        mediaPlayer2.release();
        mediaPlayer3.release();
        handler.removeCallbacks(updateSeekBarRunnable);
    }

    @Override
    public boolean onLongClick(View v) {
        recogida = (ImageView) v;
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
                if (v.getId() == R.id.idtv1 && recogida.getId() == R.id.idImagensiu) {
                    v.setBackground(recogida.getDrawable());
                    recogida.setVisibility(View.GONE);
                    Toast toast1 =
                            Toast.makeText(getApplicationContext(),
                                    "Tu opcion esta correcta", Toast.LENGTH_SHORT);

                    toast1.show();
                } else if (v.getId() == R.id.idtv2 && recogida.getId() == R.id.idImagensiu2) {
                    v.setBackground(recogida.getDrawable());
                    recogida.setVisibility(View.GONE);
                    Toast toast1 =
                            Toast.makeText(getApplicationContext(),
                                    "Tu opcion   esta correcta", Toast.LENGTH_SHORT);

                    toast1.show();
                } else if (v.getId() == R.id.idtv3 && recogida.getId() == R.id.idImagensiu3) {
                    v.setBackground(recogida.getDrawable());
                    recogida.setVisibility(View.GONE);
                    Toast toast1 =
                            Toast.makeText(getApplicationContext(),
                                    "Tu opcion   esta correcta", Toast.LENGTH_SHORT);

                    toast1.show();
                } else if (v.getId() == R.id.idtv4 && recogida.getId() == R.id.idImagensiu4) {
                    v.setBackground(recogida.getDrawable());
                    recogida.setVisibility(View.GONE);
                    Toast toast1 =
                            Toast.makeText(getApplicationContext(),
                                    "Tu opcion   esta correcta", Toast.LENGTH_SHORT);

                    toast1.show();
                } else if (v.getId() == R.id.idtv5 && recogida.getId() == R.id.idImagensiu5) {
                    v.setBackground(recogida.getDrawable());
                    recogida.setVisibility(View.GONE);
                    Toast toast1 =
                            Toast.makeText(getApplicationContext(),
                                    "Tu opcion   esta correcta", Toast.LENGTH_SHORT);

                    toast1.show();
                } else if (v.getId() == R.id.idtv6 && recogida.getId() == R.id.idImagensiu6) {
                    v.setBackground(recogida.getDrawable());
                    recogida.setVisibility(View.GONE);
                    Toast toast1 =
                            Toast.makeText(getApplicationContext(),
                                    "Tu opcion   esta correcta", Toast.LENGTH_SHORT);

                    toast1.show();
                } else if (v.getId() == R.id.idtv7 && recogida.getId() == R.id.idImagensiu7) {
                    v.setBackground(recogida.getDrawable());
                    recogida.setVisibility(View.GONE);
                    Toast toast1 =
                            Toast.makeText(getApplicationContext(),
                                    "Tu opcion   esta correcta", Toast.LENGTH_SHORT);

                    toast1.show();
                } else if (v.getId() == R.id.idtv8 && recogida.getId() == R.id.idImagensiu8) {
                    v.setBackground(recogida.getDrawable());
                    recogida.setVisibility(View.GONE);
                    Toast toast1 =
                            Toast.makeText(getApplicationContext(),
                                    "Tu opcion   esta correcta", Toast.LENGTH_SHORT);

                    toast1.show();
                } else if (v.getId() == R.id.idtv9 && recogida.getId() == R.id.idImagensiu9) {
                    v.setBackground(recogida.getDrawable());
                    recogida.setVisibility(View.GONE);
                    Toast toast1 =
                            Toast.makeText(getApplicationContext(),
                                    "Tu opcion   esta correcta", Toast.LENGTH_SHORT);

                    toast1.show();
                } else {
                    Toast toast1 =
                            Toast.makeText(getApplicationContext(),
                                    "Tu opcion  nooo esta correcta", Toast.LENGTH_SHORT);

                    toast1.show();
                }
        }
        return true;
    };
}
