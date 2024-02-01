package com.example.sugandilak.EntidadesDB;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

@Dao
public interface VideoDAO {

    @Query("select * from Video")
    public List<Ubicacion> conseguirVideo();
}
