package com.example.sugandilak.EntidadesDB;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;
@Dao
public interface UbicacionDAO {

    @Query("select * from Ubicacion")
    public List<Ubicacion> conseguirTodasUbicaciones();
}