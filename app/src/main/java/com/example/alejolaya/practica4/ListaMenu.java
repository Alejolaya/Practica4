package com.example.alejolaya.practica4;

/**
 * Created by Alejandro Olaya on 02/10/2015.
 */
public class ListaMenu {

    private int idImagen;
    private String NameItem;
    private String SubItem;

    public ListaMenu(int idImagen, String nameItem, String subItem) {
        this.idImagen = idImagen;
        NameItem = nameItem;
        SubItem = subItem;
    }

    public int getIdImagen() {
        return idImagen;
    }

    public String getSubItem() {
        return SubItem;
    }

    public String

    getNameItem() {
        return NameItem;
    }
}
