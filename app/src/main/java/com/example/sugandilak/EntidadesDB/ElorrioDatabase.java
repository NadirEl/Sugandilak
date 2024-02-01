package com.example.sugandilak.EntidadesDB;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import com.example.sugandilak.EntidadesDB.Ubicacion;
import com.example.sugandilak.EntidadesDB.UbicacionDAO;

@Database(entities = {Ubicacion.class}, version=1, exportSchema = false)
public abstract class ElorrioDatabase extends RoomDatabase{

    public abstract UbicacionDAO ubicacionDAO();
    public abstract AudiosDAO audioDAO();

    public abstract TextoDAO textoDAO();

    private static final String DATABASE_NAME = "elorrio-db";

    private static ElorrioDatabase INSTANCE;


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
