package com.example.sugandilak.EntidadesDB;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;
@Dao
public interface RecordCartasDAO {

    //inserta el record
    @Insert
    void insertarRecord(RecordCartas rc);

    //selecciona los 10 mejores del record de forma descendente
    @Query("select * from RecordCartas ORDER BY record DESC LIMIT 10")
    List<RecordCartas> mejores10();
}
