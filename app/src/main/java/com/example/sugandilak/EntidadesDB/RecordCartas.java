package com.example.sugandilak.EntidadesDB;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "RecordCartas",
        foreignKeys = @ForeignKey(entity = Ubicacion.class,
                parentColumns = "id_ubicacion",
                childColumns = "id_ubicacion"))
public class RecordCartas implements Serializable {

    @ColumnInfo(name = "id_ubicacion")
    public int id_ubicacion;
    @PrimaryKey(autoGenerate = true)
    public int id_user;
    @ColumnInfo(name = "nombre")
    public String nombre;

    @ColumnInfo(name = "record")
    public int record;

    public RecordCartas(int id_ubicacion, String nombre, int record) {
        this.id_ubicacion = id_ubicacion;
        this.nombre = nombre;
        this.record = record;
    }
    public RecordCartas() {

    }

    public int getId_ubicacion() {
        return id_ubicacion;
    }

    public void setId_ubicacion(int id_ubicacion) {
        this.id_ubicacion = id_ubicacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getRecord() {
        return record;
    }

    public void setRecord(int record) {
        this.record = record;
    }
}
