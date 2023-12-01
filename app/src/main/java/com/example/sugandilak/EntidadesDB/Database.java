package com.example.sugandilak.EntidadesDB;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@androidx.room.Database(entities = {Explicacion.class,Pantalla.class},version = 1, exportSchema = false)
public abstract class Database extends RoomDatabase {

    // Exposición de DAOs
    public abstract ExplicacionDao ExplicacionDao();

    public abstract PantallaDao PantallaDao();

    private static final String DATABASE_NAME = "Central-db";

    private static volatile Database INSTANCE;

    private static final int THREADS = 4;

    public static final ExecutorService dbExecutor = Executors.newFixedThreadPool(THREADS);

    public static Database getInstance(final Context context) {
        if (INSTANCE == null) {
            synchronized (Database.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                                    context.getApplicationContext(), Database.class,
                                    DATABASE_NAME)
                            //.addCallback(mRoomCallback)
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    // Prepoblar base de datos con callback
   /* private static final RoomDatabase.Callback mRoomCallback = new Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            dbExecutor.execute(() -> {
                JuegoDao dao = INSTANCE.JuegoDao();

                Explicacion juego1 = new Explicacion(1, "AAA", "Placeholder1");
                Explicacion juego2 = new Explicacion(2, "BBB", "Placeholder2");

                dao.insert(juego1);
                dao.insert(juego2);
            });
        }
    };*/

}
