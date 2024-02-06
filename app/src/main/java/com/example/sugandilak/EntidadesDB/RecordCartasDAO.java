package com.example.sugandilak.EntidadesDB;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;
@Dao
public interface RecordCartasDAO {

    @Insert
    void insertarRecord(RecordCartas rc);

    @Query("select * from RecordCartas ORDER BY record DESC LIMIT 10")
    List<RecordCartas> mejores10();
}
