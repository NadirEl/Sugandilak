package com.example.sugandilak.EntidadesDB;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
@Dao
public interface TextoDAO {

    @Query("select * from Texto")
    public List<String> conseguirTodosTextos();

    @Insert
    void insertarTexto(String txt);


    @Query("DELETE FROM Texto")
    void deleteAllTexto();


    @Query("select * from Ubicacion")
    public List<Ubicacion> conseguirTodasUbicaciones();

    @Insert
    void insertarUbicacion(int ubi);


    @Query("DELETE FROM Ubicacion")
    void deleteAllUbicacion();


}

