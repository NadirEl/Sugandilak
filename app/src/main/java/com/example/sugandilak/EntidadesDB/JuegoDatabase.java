package com.example.sugandilak.EntidadesDB;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Juego.class}, version = 1, exportSchema = false)
public abstract class JuegoDatabase extends RoomDatabase {

    // Exposición de DAOs
    public abstract JuegoDao JuegoDao();

    private static final String DATABASE_NAME = "Juego-db";

    private static volatile JuegoDatabase INSTANCE;

    private static final int THREADS = 4;

    public static final ExecutorService dbExecutor = Executors.newFixedThreadPool(THREADS);

    public static JuegoDatabase getInstance(final Context context) {
        if (INSTANCE == null) {
            synchronized (JuegoDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                                    context.getApplicationContext(), JuegoDatabase.class,
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

                Juego juego1 = new Juego(1, "AAA", "Placeholder1");
                Juego juego2 = new Juego(2, "BBB", "Placeholder2");

                dao.insert(juego1);
                dao.insert(juego2);
            });
        }
    };*/

}
