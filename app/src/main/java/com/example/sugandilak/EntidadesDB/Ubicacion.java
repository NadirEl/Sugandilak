package com.example.sugandilak.EntidadesDB;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Ubicacion")
public class Ubicacion {

    @ColumnInfo(name = "id_ubicacion")
    @PrimaryKey(autoGenerate = true)
    int id;
    @ColumnInfo(name = "name_ubicacion")
    String nombre;

    @ColumnInfo(name = "longitud")
    int longitud;
    @ColumnInfo(name = "latitud")
    int latitud;

    public Ubicacion() {
    }

    public Ubicacion(int id, String nombre, int longitud, int latitud) {
        this.id = id;
        this.nombre = nombre;
        this.longitud = longitud;
        this.latitud = latitud;
    }

    public int getId() {
        return id;
    }

    public void setId(int i) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public int getLatitud() {
        return latitud;
    }

    public void setLatitud(int latitud) {
        this.latitud = latitud;
    }


}
