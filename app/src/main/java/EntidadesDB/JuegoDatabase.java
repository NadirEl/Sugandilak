package EntidadesDB;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Juego.class}, version = 1, exportSchema = false)
public abstract class JuegoDatabase extends RoomDatabase {

    // Exposición de DAOs
    public abstract DBDao JuegoDao();

    private static final String DATABASE_NAME = "Juego-db";

    private static JuegoDatabase INSTANCE;

    private static final int THREADS = 4;

    public static final ExecutorService dbExecutor = Executors.newFixedThreadPool(THREADS);

    public static JuegoDatabase getInstance(final Context context) {
        if (INSTANCE == null) {
            synchronized (JuegoDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                                    context.getApplicationContext(), JuegoDatabase.class,
                                    DATABASE_NAME)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}
