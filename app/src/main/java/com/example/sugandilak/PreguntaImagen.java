package com.example.sugandilak;

import java.io.Serializable;

public class PreguntaImagen implements Serializable {

    private int idImagen;
    private String respuesta;

    public PreguntaImagen(int idImagen, String respuesta) {
        this.idImagen = idImagen;
        this.respuesta = respuesta;
    }

    public PreguntaImagen() {
    }

    public int getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(int idImagen) {
        this.idImagen = idImagen;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
}
