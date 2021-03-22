package com.example.tecniled;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

public class OperacionesBaseDatos {

    private static BDHelper baseDatos;

    public void insertarProyecto(Proyecto proyecto){
        SQLiteDatabase db = baseDatos.getWritableDatabase();

        //Generar PK
        String idProyecto = NombresBD.Proyectos.generarIdProyecto();

        ContentValues valores = new ContentValues();
        valores.put(NombresBD.Proyectos.ID, idProyecto);
        valores.put(NombresBD.Proyectos.NOMBRE, proyecto.nombre);
        valores.put(NombresBD.Proyectos.FECHA, proyecto.fecha);
        valores.put(NombresBD.Proyectos.OBSERVACIONES, proyecto.observaciones);
        valores.put(NombresBD.Proyectos.ID_GRUPO, proyecto.idGrupo);

        // Insertamos el proyecto
        db.insertOrThrow(BDHelper.Tablas.PROYECTO, null, valores);

        db.close();
    }

    public void insertarGrupo(Grupo grupo){
        SQLiteDatabase db = baseDatos.getWritableDatabase();

        //Generar PK
        String idGrupo = NombresBD.Grupos.generarIdGrupo();

        ContentValues valores = new ContentValues();
        valores.put(NombresBD.Grupos.ID, idGrupo);
        valores.put(NombresBD.Grupos.NOMBRE, grupo.nombre);
        valores.put(NombresBD.Grupos.UBICACION, grupo.ubicacion);
        valores.put(NombresBD.Grupos.ID_FOCO, grupo.idFoco);

        // Insertamos el proyecto
        db.insertOrThrow(BDHelper.Tablas.GRUPO, null, valores);

        db.close();
    }

    public static void insertarFoco(Foco foco){
        SQLiteDatabase db = baseDatos.getWritableDatabase();

        //Generar PK
        String idFoco = NombresBD.Focos.generarIdFoco();

        ContentValues valores = new ContentValues();
        valores.put(NombresBD.Focos.ID, idFoco);
        valores.put(NombresBD.Focos.NOMBRE, foco.nombre);
        valores.put(NombresBD.Focos.MARCA, foco.marca);
        valores.put(NombresBD.Focos.MESA_CONTROL, foco.direccion);
        valores.put(NombresBD.Focos.DMX, foco.canales);

        // Insertamos el proyecto
        db.insertOrThrow(BDHelper.Tablas.FOCO, null, valores);

        db.close();
    }
}
