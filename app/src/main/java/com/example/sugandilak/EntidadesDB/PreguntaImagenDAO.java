package com.example.sugandilak.EntidadesDB;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao
public interface PreguntaImagenDAO {

    //inserta preguntaImagen
    @Insert
    void insertarPreguntaImagen(PreguntaImagen pi);

    //selecciona todas las preguntaImagen
    @Query("select * from PreguntaImagen")
    List<PreguntaImagen> conseguirTodasPreguntaImagenes();

    //borra toda la tabla de preguntaImagen
    @Query("DELETE FROM PreguntaImagen")
    void deleteAllPreguntaImagen();
}
