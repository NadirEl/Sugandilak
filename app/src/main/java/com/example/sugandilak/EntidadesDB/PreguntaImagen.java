package com.example.sugandilak.EntidadesDB;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.io.Serializable;
@Entity(tableName = "PreguntaImagen")
public class PreguntaImagen implements Serializable {

    @PrimaryKey(autoGenerate = true)
    public int id_preguntaImagen;
    public int id_imagen;
    public String respuesta;

    public PreguntaImagen(int id_imagen, String respuesta) {
        this.id_imagen = id_imagen;
        this.respuesta = respuesta;
    }

    public PreguntaImagen() {
    }

    public int getIdImagen() {
        return id_imagen;
    }

    public void setIdImagen(int idImagen) {
        this.id_imagen = id_imagen;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public int getId_preguntaImagen() {
        return id_preguntaImagen;
    }

    public void setId_preguntaImagen(int id_preguntaImagen) {
        this.id_preguntaImagen = id_preguntaImagen;
    }

    public int getId_imagen() {
        return id_imagen;
    }

    public void setId_imagen(int id_imagen) {
        this.id_imagen = id_imagen;
    }
}
