package com.example.sugandilak.EntidadesDB;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
@Dao
public interface AudiosDAO {

    @Query("select * from Audios")
    public List<String> conseguirTodosAudios();

    @Insert
    void insertarAudio(int audio);


    @Query("DELETE FROM Audios")
    void deleteAllAudio();


    @Query("select * from Ubicacion")
    public List<Ubicacion> conseguirTodasUbicaciones();

    @Insert
    void insertarUbicacion(int ubi);


    @Query("DELETE FROM Ubicacion")
    void deleteAllUbicacion();


}
