package com.example.sugandilak.EntidadesDB;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "Pregunta",
        foreignKeys = @ForeignKey(entity = Ubicacion.class,
                parentColumns = "id_ubicacion",
                childColumns = "id_ubicacion"))
public class Pregunta implements Serializable {

    //foreignkey de la tabla ubicacion
    @ColumnInfo(name = "id_ubicacion")
    public int id_ubicacion;
    //primarykey de la pregunta
    @PrimaryKey
    @ColumnInfo(name = "id_pregunta")
    public int id_pregunta;

    //string de la pregunta
    @ColumnInfo(name = "pregunta")
    public String pregunta;

    //respuesta de la pregunta
    @ColumnInfo(name = "respuesta")
    public String respuesta;

    //las 3 opciones de la pregunta
    @ColumnInfo(name = "opcion1")
    public String opcion1;

    @ColumnInfo(name = "opcion2")
    public String opcion2;

    @ColumnInfo(name = "opcion3")
    public String opcion3;

    //booleano que comprueba si esta contestada o no
    @ColumnInfo(name = "contestada")
    public boolean contestada;

    //getters y setters de pregunta
    public int getId_ubicacion() {
        return id_ubicacion;
    }

    public void setId_ubicacion(int id_ubicacion) {
        this.id_ubicacion = id_ubicacion;
    }

    public int getId_pregunta() {
        return id_pregunta;
    }

    public void setId_pregunta(int id_pregunta) {
        this.id_pregunta = id_pregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public String getOpcion1() {
        return opcion1;
    }

    public void setOpcion1(String opcion1) {
        this.opcion1 = opcion1;
    }

    public String getOpcion2() {
        return opcion2;
    }

    public void setOpcion2(String opcion2) {
        this.opcion2 = opcion2;
    }

    public String getOpcion3() {
        return opcion3;
    }

    public void setOpcion3(String opcion3) {
        this.opcion3 = opcion3;
    }

    public boolean isContestada() {
        return contestada;
    }

    public void setContestada(boolean contestada) {
        this.contestada = contestada;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    //constructor de pregunta
    public Pregunta(int id_ubicacion, int id_pregunta, String pregunta, String opcion1, String opcion2, String opcion3,String respuesta) {
        this.id_ubicacion = id_ubicacion;
        this.id_pregunta = id_pregunta;
        this.respuesta = respuesta;
        this.opcion1 = opcion1;
        this.opcion2 = opcion2;
        this.opcion3 = opcion3;
        this.pregunta = pregunta;
        this.contestada = false;
    }
    //constructor vacio
    public Pregunta() {

    }
}
