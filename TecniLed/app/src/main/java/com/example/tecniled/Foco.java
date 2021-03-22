package com.example.tecniled;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Foco implements Serializable {
    public String idFoco;
    public String nombre;
    public String marca;
    public int direccion;
    public int canales;

    // Contructor

    public Foco(String idFoco, String nombre, String marca, int direccion, int canales) {
        this.idFoco = idFoco;
        this.nombre = nombre;
        this.marca = marca;
        this.direccion = direccion;
        this.canales = canales;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @NonNull
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @NonNull
    @Override
    public String toString() {
        return nombre + "," + marca + "," + direccion + "," + canales + ";";
    }

    // Getters y setters
}
