package com.example.sugandilak.EntidadesDB;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

@Entity(tableName = "Ubicacion")
public class Ubicacion {

    @ColumnInfo(name = "id_ubicacion")
    @PrimaryKey(autoGenerate = true)
    @NonNull
    int id;
    @ColumnInfo(name = "name_ubicacion")
    String nombre;

    @ColumnInfo(name = "longitud")
    float longitud;
    @ColumnInfo(name = "latitud")
    float latitud;


    @Ignore
    public Ubicacion(int id, String nombre, float longitud, float latitud) {
        this.id = id;
        this.nombre = nombre;
        this.longitud = longitud;
        this.latitud = latitud;
    }

    public Ubicacion() {
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

    public float getLongitud() {
        return longitud;
    }

    public void setLongitud(float longitud) {
        this.longitud = longitud;
    }

    public float getLatitud() {
        return latitud;
    }

    public void setLatitud(float latitud) {
        this.latitud = latitud;
    }


}
