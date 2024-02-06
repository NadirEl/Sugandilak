package com.example.sugandilak.EntidadesDB;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao
public interface VideoDAO {

    //selecciona todos los videos
    @Query("select * from Video")
    List<Video> conseguirVideo();

    //inserta video
    @Insert
    void insertarVideo(Video v);

    //borra todos los videos
    @Query("DELETE FROM Video")
    void deleteAllVideo();
}
