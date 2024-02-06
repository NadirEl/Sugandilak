package com.example.sugandilak.EntidadesDB;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao
public interface ImagenDAO {

    @Insert
    void insertarImagen(Imagen im);

    @Query("select * from Imagen where id_ubicacion LIKE :id")
    List<Imagen> conseguirImagenesPorId(int id);

    @Query("DELETE FROM Imagen")
    void deleteAllImagenes();


}
