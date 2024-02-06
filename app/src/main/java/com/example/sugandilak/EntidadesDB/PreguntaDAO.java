package com.example.sugandilak.EntidadesDB;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao
public interface PreguntaDAO {

    @Insert
    void insertarPregunta(Pregunta p);

    @Query("DELETE FROM Pregunta")
    void deleteAllPregunta();

    @Query("select * from Pregunta")
    List<Pregunta> conseguirTodasPreguntas();


}
