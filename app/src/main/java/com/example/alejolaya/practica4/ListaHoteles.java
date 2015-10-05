package com.example.alejolaya.practica4;

/**
 * Created by USER on 04/10/2015.
 */
public class ListaHoteles {
    private int idImagen;
    private String titulo;
    private String Subtitulo;

    public ListaHoteles(int idImagen, String titulo, String subtitulo) {
        this.idImagen = idImagen;
        this.titulo = titulo;
        Subtitulo = subtitulo;
    }

    public int getIdImagen() {
        return idImagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getSubtitulo() {
        return Subtitulo;
    }
}
