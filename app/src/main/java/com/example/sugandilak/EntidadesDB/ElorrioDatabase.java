package com.example.sugandilak.EntidadesDB;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Ubicacion.class, Record.class, Video.class, Pregunta.class, Texto.class, Audios.class, Imagenes.class}, version = 2)
public abstract class ElorrioDatabase extends RoomDatabase {

    private static ElorrioDatabase instance;

    public abstract UbicacionDAO ubicacionDAO();

    public static synchronized ElorrioDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            ElorrioDatabase.class, "elorrio_database")
                    .fallbackToDestructiveMigration()
                    .addMigrations(MIGRATION_1_2)
                    .build();
        }
        return instance;
    }

    public static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            // Aquí es donde puedes escribir código para realizar la migración
            // Por ejemplo, puedes ejecutar consultas SQL para modificar la estructura de la base de datos.
            // database.execSQL("ALTER TABLE tu_tabla ADD COLUMN nueva_columna TEXT");
        }
    };
}
