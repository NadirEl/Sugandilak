package com.example.sugandilak.EntidadesDB;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao
public interface AudioDAO {

    //recoger audios segunel id de la ubicacion
    @Query("select * from AudioApp where id_ubicacion LIKE :id")
    List<AudioApp> conseguirTodosAudios(int id);


    //insertar audio
    @Insert
    void insertarAudio(AudioApp a);


    //borrar toda lo que hay en la tabla de audio
    @Query("DELETE FROM AudioApp")
    void deleteAllAudio();



}
