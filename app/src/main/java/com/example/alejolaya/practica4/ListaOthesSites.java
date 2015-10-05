package com.example.alejolaya.practica4;

/**
 * Created by USER on 04/10/2015.
 */
public class ListaOthesSites {
    private int idImagenOthers;
    private String TituloOthers;
    private String SubTituloOthers;

    public ListaOthesSites(int idImagenOthers, String tituloOthers, String subTituloOthers) {
        this.idImagenOthers = idImagenOthers;
        TituloOthers = tituloOthers;
        SubTituloOthers = subTituloOthers;
    }

    public int getIdImagenOthers() {
        return idImagenOthers;
    }

    public String getTituloOthers() {
        return TituloOthers;
    }

    public String getSubTituloOthers() {
        return SubTituloOthers;
    }
}
