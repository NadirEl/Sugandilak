package com.example.sugandilak.EntidadesDB;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "Audios",
        foreignKeys = @ForeignKey(entity = Ubicacion.class,
                parentColumns = "id_ubicacion",
                childColumns = "id_ubicacion"))
public class Audios {

    @PrimaryKey
    @ColumnInfo(name = "id_ubicacion")
    public int id_ubicacion;

    @ColumnInfo(name = "id_audio")
    public int id_audio;

    public Audios(int id_ubicacion, int id_audio) {
        this.id_ubicacion = id_ubicacion;
        this.id_audio = id_audio;
    }
    public Audios() {

    }

    public int getId_ubicacion() {
        return id_ubicacion;
    }

    public void setId_ubicacion(int id_ubicacion) {
        this.id_ubicacion = id_ubicacion;
    }

    public int getId_audio() {
        return id_audio;
    }

    public void setId_audio(int id_audio) {
        this.id_audio = id_audio;
    }
}
