package com.example.sugandilak.EntidadesDB;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Juego")

public class Juego {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name="id")
    private final int id;

    @NonNull
    @ColumnInfo(name="titulo")
    private final String titulo;

    @NonNull
    @ColumnInfo(name="explicacion")
    private final String explicacion;


    public int getId() {
        return id;
    }



    public String getTitulo() {
        return titulo;
    }



    public String getExplicacion() {
        return explicacion;
    }



    public Juego(@NonNull int id, @NonNull String titulo, @NonNull String explicacion) {
        this.id = id;
        this.titulo = titulo;
        this.explicacion = explicacion;
    }
}
