package com.example.sugandilak.EntidadesDB;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;
@Dao
public interface UbicacionDAO {

    //selecciona todas las ubicaciones
    @Query("select * from Ubicacion")
    List<Ubicacion> conseguirTodasUbicaciones();

    //inserta la ubicacion
    @Insert
    void insertarUbicacion(Ubicacion ubi);

    //borra las ubicaciones
    @Query("DELETE FROM Ubicacion")
    void deleteAllUbicacion();


}
