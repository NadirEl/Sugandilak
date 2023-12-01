package com.example.sugandilak.EntidadesDB;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PantallaDao {
    @Query("SELECT * FROM Explicacion")
    LiveData<List<Pantalla>> getAll();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Pantalla pantalla);


}


