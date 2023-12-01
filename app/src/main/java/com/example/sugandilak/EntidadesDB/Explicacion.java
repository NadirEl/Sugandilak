package com.example.sugandilak.EntidadesDB;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Explicacion")

public class Explicacion {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name="id")
    private final int id;

    @NonNull
    @ColumnInfo(name="audio")
    private final String audio;

    @NonNull
    @ColumnInfo(name="texto")
    private final String texto;


    public int getId() {
        return id;
    }



    public String getAudio() {
        return audio;
    }



    public String getTexto() {
        return texto;
    }



    public Explicacion(@NonNull int id, @NonNull String audio, @NonNull String texto) {
        this.id = id;
        this.audio = audio;
        this.texto = texto;
    }
}
