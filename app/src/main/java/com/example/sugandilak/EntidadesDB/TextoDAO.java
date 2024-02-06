package com.example.sugandilak.EntidadesDB;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;
@Dao
public interface TextoDAO {

    //selecciona los textos segun el id de ubicacion
    @Query("select * from Texto where id_ubicacion LIKE :id")
    List<Texto> conseguirTextosPorId(int id);

    //inserta el texto
    @Insert
    void insertarTexto(Texto t);

    //borra todos los textos que hay en la tabla
    @Query("DELETE FROM Texto")
    void deleteAllTexto();

}

