package com.example.sugandilak.EntidadesDB;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "AudioApp",
        foreignKeys = @ForeignKey(entity = Ubicacion.class,
                parentColumns = "id_ubicacion",
                childColumns = "id_ubicacion"))
public class AudioApp implements Serializable {

    //foreignkey de la tabla ubicación
    @ColumnInfo(name = "id_ubicacion")
    public int id_ubicacion;
    //la primarykey del audio, autogenerado
    @PrimaryKey(autoGenerate = true)
    public int id_audio;

    //el integer del audio, con lo que lo ejecutaremos
    @ColumnInfo(name = "audio")
    public int audio;

    //constructor del audio
    public AudioApp(int id_ubicacion, int audio) {
        this.id_ubicacion = id_ubicacion;
        this.audio = audio;
    }
    //constructor vacío
    public AudioApp() {

    }

    //getters y setters de los atributos de los audios
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

    public int getAudio() {
        return audio;
    }

    public void setAudio(int audio) {
        this.audio = audio;
    }
}
