package com.example.sugandilak.EntidadesDB;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "RecordCartas")
public class RecordCartas implements Serializable {

    //primarykey del record, autogenerado
    @PrimaryKey(autoGenerate = true)
    public int id_user;
    //string nombre de la persona
    @ColumnInfo(name = "nombre")
    public String nombre;

    //la puntuación que ha echo
    @ColumnInfo(name = "record")
    public int record;

    //constructor de la clase
    public RecordCartas(String nombre, int record) {
        this.nombre = nombre;
        this.record = record;
    }
    //constructor vacío
    public RecordCartas() {

    }

    //getters y setters de la clase
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
