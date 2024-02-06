package com.example.sugandilak.EntidadesDB;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Ubicacion.class, Video.class, AudioApp.class, Imagen.class, Pregunta.class, RecordCartas.class, Texto.class, PreguntaImagen.class}, version=1, exportSchema = false)
public abstract class ElorrioDatabase extends RoomDatabase{

    public abstract UbicacionDAO ubicacionDAO();
    public abstract AudioDAO audioDAO();
    public abstract TextoDAO textoDAO();
    public abstract VideoDAO videoDAO();
    public abstract ImagenDAO imagenDAO();
    public abstract PreguntaImagenDAO preguntaImagenDAO();
    public abstract PreguntaDAO preguntaDAO();
    public abstract RecordCartasDAO recordCartasDAO();

    private static final String DATABASE_NAME = "elorrio-db";

    private static volatile ElorrioDatabase INSTANCE;


    public static ElorrioDatabase getInstance(final Context context) {
        if (INSTANCE == null) {
            synchronized (ElorrioDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                                    context.getApplicationContext(), ElorrioDatabase.class,
                                    DATABASE_NAME)
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
