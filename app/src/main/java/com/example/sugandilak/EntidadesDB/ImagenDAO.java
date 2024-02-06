package com.example.sugandilak.EntidadesDB;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao
public interface ImagenDAO {

    //insertar una imagen
    @Insert
    void insertarImagen(Imagen im);

    //seleccionar las imagenes segun el id de la ubicacion
    @Query("select * from Imagen where id_ubicacion LIKE :id")
    List<Imagen> conseguirImagenesPorId(int id);

    //borrar toda la tabla de Imagen
    @Query("DELETE FROM Imagen")
    void deleteAllImagenes();


}
