package com.example.crud;
public class Perro {
    private int id;
    private String nombre;
    private String dueño;

    public Perro(int anInt, String string) {

    }

    public Perro(String nombre, String dueño) {
        this.nombre = nombre;
        this.dueño = dueño;
    }

    public Perro(int id, String nombre, String dueño) {
        this.id = id;
        this.nombre = nombre;
        this.dueño = dueño;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDueño() {
        return dueño;
    }

    public void setDueño(String dueño) {
        this.dueño = dueño;
    }
}



