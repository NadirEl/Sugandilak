package com.example.sugandilak.EntidadesDB;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Pantalla")
public class Pantalla {

    public Pantalla(int id, @NonNull String imgMapa) {
        this.id = id;
        this.imgMapa = imgMapa;
    }

    @PrimaryKey
    @NonNull
    @ColumnInfo(name="id")

    private final int id;

    @NonNull
    @ColumnInfo(name="audio")
    private final String imgMapa;

    public int getId() {
        return id;
    }

    @NonNull
    public String getImgMapa() {
        return imgMapa;
    }


}
