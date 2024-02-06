package com.example.sugandilak.EntidadesDB;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;
@Dao
public interface TextoDAO {

    @Query("select * from Texto where id_ubicacion LIKE :id")
    List<Texto> conseguirTextosPorId(int id);

    @Insert
    void insertarTexto(Texto t);

    @Query("DELETE FROM Texto")
    void deleteAllTexto();

}

