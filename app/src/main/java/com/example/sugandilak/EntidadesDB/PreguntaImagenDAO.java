package com.example.sugandilak.EntidadesDB;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao
public interface PreguntaImagenDAO {

    @Insert
    void insertarPreguntaImagen(PreguntaImagen pi);

    @Query("select * from PreguntaImagen")
    List<PreguntaImagen> conseguirTodasPreguntaImagenes();

    @Query("DELETE FROM PreguntaImagen")
    void deleteAllPreguntaImagen();
}
