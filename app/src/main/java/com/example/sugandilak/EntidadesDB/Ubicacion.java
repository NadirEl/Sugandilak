package com.example.sugandilak.EntidadesDB;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "Ubicacion")
public class Ubicacion implements Serializable {

    //primarykey de ubicacion
    @PrimaryKey
    @ColumnInfo(name = "id_ubicacion")
    public int id_ubicacion;

    //el nombre de la ubicacion
    @ColumnInfo(name = "nombre_ubicacion")
    public String nombre_ubicacion;

    //la latitud de la ubicacion
    @ColumnInfo(name = "latitud")
    public double latitud;
    //la longitud de la ubicacion
    @ColumnInfo(name = "longitud")
    public double longitud;

    //constructor de ubicación
    public Ubicacion(int id_ubicacion, String nombre_ubicacion, double latitud, double longitud) {
        this.id_ubicacion = id_ubicacion;
        this.nombre_ubicacion = nombre_ubicacion;
        this.latitud = latitud;
        this.longitud = longitud;
    }
    //constructor vacío
    public Ubicacion() {

    }
    //getters y setters de la clase

    public int getId_ubicacion() {
        return id_ubicacion;
    }

    public void setId_ubicacion(int id_ubicacion) {
        this.id_ubicacion = id_ubicacion;
    }

    public String getNombre_ubicacion() {
        return nombre_ubicacion;
    }

    public void setNombre_ubicacion(String nombre_ubicacion) {
        this.nombre_ubicacion = nombre_ubicacion;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }
}
