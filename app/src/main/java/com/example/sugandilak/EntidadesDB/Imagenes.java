package com.example.sugandilak.EntidadesDB;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "Imagenes",
        foreignKeys = @ForeignKey(entity = Ubicacion.class,
                parentColumns = "id_ubicacion",
                childColumns = "id_ubicacion"))
public class Imagenes {

    @PrimaryKey
    @ColumnInfo(name = "id_ubicacion")
    public int id_ubicacion;

    @ColumnInfo(name = "id_imagen")
    public int id_imagen;

    public Imagenes(int id_ubicacion, int id_imagen) {
        this.id_ubicacion = id_ubicacion;
        this.id_imagen = id_imagen;
    }
}
