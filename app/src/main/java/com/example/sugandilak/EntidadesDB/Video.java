package com.example.sugandilak.EntidadesDB;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "Video",
        foreignKeys = @ForeignKey(entity = Ubicacion.class,
                parentColumns = "id_ubicacion",
                childColumns = "id_ubicacion"))
public class Video {

    @PrimaryKey
    @ColumnInfo(name = "id_ubicacion")
    public int id_ubicacion;

    @ColumnInfo(name = "id_video")
    public int id_video;

    public Video(int id_ubicacion, int id_video) {
        this.id_ubicacion = id_ubicacion;
        this.id_video = id_video;
    }

    public int getId_ubicacion() {
        return id_ubicacion;
    }

    public void setId_ubicacion(int id_ubicacion) {
        this.id_ubicacion = id_ubicacion;
    }

    public int getId_video() {
        return id_video;
    }

    public void setId_video(int id_video) {
        this.id_video = id_video;
    }

    public Video() {

    }
}