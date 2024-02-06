package com.example.sugandilak.EntidadesDB;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "Imagen",
        foreignKeys = @ForeignKey(entity = Ubicacion.class,
                parentColumns = "id_ubicacion",
                childColumns = "id_ubicacion"))
public class Imagen implements Serializable {

    //foreignkey de la tabla ubicacion
    @ColumnInfo(name = "id_ubicacion")
    public int id_ubicacion;
    //primarykey de las imagenes
    @PrimaryKey(autoGenerate = true)
    public int id_imagen;
    //id con el que se saca la imagen
    @ColumnInfo(name = "imagen")
    public int imagen;

    //constructor de Imagen
    public Imagen(int id_ubicacion, int imagen) {
        this.id_ubicacion = id_ubicacion;
        this.imagen = imagen;
    }
    //constructor vacio
    public Imagen( ) {

    }

    //los getters y setters
    public int getId_ubicacion() {
        return id_ubicacion;
    }

    public void setId_ubicacion(int id_ubicacion) {
        this.id_ubicacion = id_ubicacion;
    }

    public int getId_imagen() {
        return id_imagen;
    }

    public void setId_imagen(int id_imagen) {
        this.id_imagen = id_imagen;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
