package com.example.sugandilak.EntidadesDB;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao
public interface AudioDAO {

    @Query("select * from AudioApp where id_ubicacion LIKE :id")
    List<AudioApp> conseguirTodosAudios(int id);

    @Insert
    void insertarAudio(AudioApp a);


    @Query("DELETE FROM AudioApp")
    void deleteAllAudio();



}
