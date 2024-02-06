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

import com.example.sugandilak.EntidadesDB.ElorrioDatabase;
import com.example.sugandilak.EntidadesDB.Video;

import java.util.ArrayList;
import java.util.List;

public class VideoActivity extends AppCompatActivity {
    VideoView videoView;
    Button btn;
    ElorrioDatabase ddbb;
    List<Video> videos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        videoView = findViewById(R.id.videoView);
        btn = findViewById(R.id.bnt_v);
        ddbb = ElorrioDatabase.getInstance(this);

        videos = ddbb.videoDAO().conseguirVideo();


        // Ruta del video
        String path = "android.resource://" + getPackageName() + "/" + videos.get(0).getVideo();

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
                Intent i = new Intent(VideoActivity.this, LaberintoActivity.class);
                startActivity(i);
            }
        });

        // Ocultar el botón al inicio
        btn.setVisibility(View.INVISIBLE);
    }
}
