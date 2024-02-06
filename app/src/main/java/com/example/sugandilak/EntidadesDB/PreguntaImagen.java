package com.example.sugandilak.EntidadesDB;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.io.Serializable;
@Entity(tableName = "PreguntaImagen")
public class PreguntaImagen implements Serializable {

    //primarykey de la preguntaImagen, autogenerado
    @PrimaryKey(autoGenerate = true)
    public int id_preguntaImagen;
    //id con la que conseguimos la imagen
    public int id_imagen;
    //string de la respuesta de la imagen
    public String respuesta;

    //constructor de preguntaImagen
    public PreguntaImagen(int id_imagen, String respuesta) {
        this.id_imagen = id_imagen;
        this.respuesta = respuesta;
    }

    //constructor vacio
    public PreguntaImagen() {
    }

    //getters y setters de preguntaImagen
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
