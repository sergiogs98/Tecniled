package com.example.tecniled;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Grupo {
    public String idGrupo;
    public String nombre;
    public String ubicacion;
    public String idFoco;

    public Grupo(String idGrupo, String nombre, String ubicacion, String idFoco) {
        this.idGrupo = idGrupo;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.idFoco = idFoco;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    // Añade foco a un grupo
    //public void aniadirFoco(Foco foco){
        //listaFocos.add(foco);
    //}

    // Eliminar foco al grupo
    public void eliminarFoco(Foco foco){

    }

    // Existe foco??

    // Total de focos


    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        return super.equals(obj);
    }
}
