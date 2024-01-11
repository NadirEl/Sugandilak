package com.example.sugandilak.EntidadesDB;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

@Database(entities = {Ubicacion.class}, version=1)
public abstract class ElorrioDatabase extends RoomDatabase{

    public abstract UbicacionDAO ubicacionDAO();
}
