package com.example.sugandilak.EntidadesDB;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao
public interface VideoDAO {

    @Query("select * from Video")
    List<Video> conseguirVideo();

    @Insert
    void insertarVideo(Video v);

    @Query("DELETE FROM Video")
    void deleteAllVideo();
}
