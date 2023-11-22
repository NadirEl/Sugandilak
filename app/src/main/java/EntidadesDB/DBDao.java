package EntidadesDB;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DBDao {
    @Query("SELECT * FROM Juego")
    LiveData<List<Juego>> getAll();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Juego juego);
}
