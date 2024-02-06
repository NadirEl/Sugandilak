package com.example.sugandilak.EntidadesDB;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao
public interface PreguntaDAO {

    //inserta la pregunta
    @Insert
    void insertarPregunta(Pregunta p);

    //borra toda la tabla de pregunta
    @Query("DELETE FROM Pregunta")
    void deleteAllPregunta();

    //selecciona todas las preguntas
    @Query("select * from Pregunta")
    List<Pregunta> conseguirTodasPreguntas();


}
