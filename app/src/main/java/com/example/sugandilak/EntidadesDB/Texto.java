package com.example.sugandilak.EntidadesDB;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "Texto",
        foreignKeys = @ForeignKey(entity = Ubicacion.class,
                parentColumns = "id_ubicacion",
                childColumns = "id_ubicacion"))
public class Texto implements Serializable {


    @ColumnInfo(name = "id_ubicacion")
    public int id_ubicacion;
    @PrimaryKey(autoGenerate = true)
    public int id_texto;
    @ColumnInfo(name = "texto")
    public String texto;

    public Texto(int id_ubicacion, String texto) {
        this.id_ubicacion = id_ubicacion;
        this.texto = texto;
    }
    public Texto() {

    }
    public int getId_ubicacion() {
        return id_ubicacion;
    }

    public void setId_ubicacion(int id_ubicacion) {
        this.id_ubicacion = id_ubicacion;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getId_texto() {
        return id_texto;
    }

    public void setId_texto(int id_texto) {
        this.id_texto = id_texto;
    }
}
