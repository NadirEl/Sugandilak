package com.example.sugandilak;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class Video extends AppCompatActivity {
    VideoView videoView;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        videoView = findViewById(R.id.videoView);
        btn = findViewById(R.id.bnt_v);

        // Ruta del video
        String path = "android.resource://" + getPackageName() + "/" + R.raw.video;

        // Configuración del VideoView
        videoView.setVideoURI(Uri.parse(path));
        videoView.setMediaController(new MediaController(this));
        videoView.requestFocus();

        // Iniciar el video
        videoView.start();

        // Establecer un listener para detectar la finalización del video
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                // Mostrar el botón al finalizar el video
                btn.setVisibility(View.VISIBLE);
            }
        });

        // Configurar el listener del botón
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Iniciar la siguiente actividad al hacer clic en el botón
                Intent i = new Intent(Video.this, Laberinto.class);
                startActivity(i);
            }
        });

        // Ocultar el botón al inicio
        btn.setVisibility(View.INVISIBLE);
    }
}
