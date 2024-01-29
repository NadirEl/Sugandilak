package com.example.sugandilak.EntidadesDB;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "Pregunta",
        foreignKeys = @ForeignKey(entity = Ubicacion.class,
                parentColumns = "id_ubicacion",
                childColumns = "id_ubicacion"))
public class Pregunta {

    @PrimaryKey
    @ColumnInfo(name = "id_ubicacion")
    public int id_ubicacion;

    @ColumnInfo(name = "id_pregunta")
    public int id_pregunta;

    @ColumnInfo(name = "respuesta")
    public String respuesta;

    @ColumnInfo(name = "opcion1")
    public String opcion1;

    @ColumnInfo(name = "opcion2")
    public String opcion2;

    @ColumnInfo(name = "opcion3")
    public String opcion3;

    @ColumnInfo(name = "contestada")
    public boolean contestada;

    public Pregunta(int id_ubicacion, int id_pregunta, String respuesta, String opcion1, String opcion2, String opcion3, boolean contestada) {
        this.id_ubicacion = id_ubicacion;
        this.id_pregunta = id_pregunta;
        this.respuesta = respuesta;
        this.opcion1 = opcion1;
        this.opcion2 = opcion2;
        this.opcion3 = opcion3;
        this.contestada = contestada;
    }
}
