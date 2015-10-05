package com.example.alejolaya.practica4;

/**
 * Created by USER on 04/10/2015.
 */
public class ListaBars {
    private int idImagenBars;
    private String TituloBars;
    private String SubTituloBars;

    public ListaBars(int idImagenBars, String tituloBars, String subTituloBars) {
        this.idImagenBars = idImagenBars;
        TituloBars = tituloBars;
        SubTituloBars = subTituloBars;
    }

    public int getIdImagenBars() {
        return idImagenBars;
    }

    public String getTituloBars() {
        return TituloBars;
    }

    public String getSubTituloBars() {
        return SubTituloBars;
    }
}
