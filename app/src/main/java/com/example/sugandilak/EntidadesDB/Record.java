package com.example.sugandilak.EntidadesDB;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "Record",
        foreignKeys = @ForeignKey(entity = Ubicacion.class,
                parentColumns = "id_ubicacion",
                childColumns = "id_ubicacion"))
public class Record {

    @PrimaryKey
    @ColumnInfo(name = "id_ubicacion")
    public int id_ubicacion;

    @ColumnInfo(name = "nombre")
    public String nombre;

    @ColumnInfo(name = "record")
    public int record;

    public Record(int id_ubicacion, String nombre, int record) {
        this.id_ubicacion = id_ubicacion;
        this.nombre = nombre;
        this.record = record;
    }
}
