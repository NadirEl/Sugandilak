package com.example.sugandilak.EntidadesDB;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "Video",
        foreignKeys = @ForeignKey(entity = Ubicacion.class,
                parentColumns = "id_ubicacion",
                childColumns = "id_ubicacion"))
public class Video implements Serializable {

    //foreignkey del id de ubicacion
    @ColumnInfo(name = "id_ubicacion")
    public int id_ubicacion;
    //primarykey del video, autogenerado
    @PrimaryKey(autoGenerate = true)
    public int id_video;
    //integer del video, con lo que lo mostramos
    @ColumnInfo(name = "video")
    public int video;

    //constructor del video
    public Video(int id_ubicacion, int video) {
        this.id_ubicacion = id_ubicacion;
        this.video = video;
    }
    //constructor vacio
    public Video() {

    }

    //getters y setters de la clase
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

    public int getVideo() {
        return video;
    }

    public void setVideo(int video) {
        this.video = video;
    }
}
