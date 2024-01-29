package com.example.sugandilak.EntidadesDB;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Ubicacion")
public class Ubicacion {

    @PrimaryKey
    @ColumnInfo(name = "id_ubicacion")
    public int id_ubicacion;

    @ColumnInfo(name = "nombre_ubicacion")
    public String nombre_ubicacion;

    @ColumnInfo(name = "latitud")
    public double latitud;

    @ColumnInfo(name = "longitud")
    public double longitud;

    public Ubicacion(int id_ubicacion, String nombre_ubicacion, double latitud, double longitud) {
        this.id_ubicacion = id_ubicacion;
        this.nombre_ubicacion = nombre_ubicacion;
        this.latitud = latitud;
        this.longitud = longitud;
    }
}
