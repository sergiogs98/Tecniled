package com.example.tecniled;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.provider.BaseColumns;

import androidx.annotation.Nullable;

import com.example.tecniled.NombresBD.Grupos;
import com.example.tecniled.NombresBD.Focos;
import com.example.tecniled.NombresBD.Proyectos;

import com.example.tecniled.Grupo;
import com.example.tecniled.NombresBD;
import com.example.tecniled.Proyecto;

public class BDHelper extends SQLiteOpenHelper {

    private static final String NOMBRE_BASE_DATOS = "proyectos.bd";
    private static final int VERSION = 1;
    private final Context contexto;

    interface Tablas{
        String PROYECTO = "proyecto";
        String GRUPO = "grupo";
        String FOCO = "foco";
    }

    interface Referencias{
        String ID_GRUPO = String.format("REFERENCES %s(%s",
                Tablas.GRUPO, Grupos.ID);
        String ID_FOCO = String.format("REFERENCES %s(%s",
                Tablas.FOCO, Focos.ID);
        String ID_PROYECTO = String.format("REFERENCES %s(%s",
                Tablas.PROYECTO, Proyectos.ID);
    }

    public BDHelper(Context contexto) {
        super(contexto, NOMBRE_BASE_DATOS, null, VERSION);
        this.contexto = contexto;
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        if (!db.isReadOnly()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                db.setForeignKeyConstraintsEnabled(true);
            } else {
                db.execSQL("PRAGMA foreign_keys=ON");
            }
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT," +
                "%s TEXT NOT NULL,%s TEXT NOT NULL, %s DATETIME NOT NULL," +
                "%s TEXT, %s TEXT NOT NULL %s)",
                Tablas.PROYECTO, BaseColumns._ID,
                Proyectos.ID, Proyectos.NOMBRE, Proyectos.FECHA,
                Proyectos.OBSERVACIONES, Proyectos.ID_GRUPO, Referencias.ID_GRUPO));

        db.execSQL(String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT," +
                "%s TEXT NOT NULL, %s TEXT NOT NULL," +
                "%s TEXT NOT NULL, %s TEXT NOT NULL %s)",
                Tablas.GRUPO, BaseColumns._ID,
                Grupos.ID, Grupos.NOMBRE,
                Grupos.UBICACION, Grupos.ID_FOCO, Referencias.ID_FOCO));

        db.execSQL(String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT," +
                "%s TEXT NOT NULL, %s TEXT NOT NULL," +
                "%s INTEGER NOT NULL, %s INTEGER NOT NULL," +
                "%s TEXT NOT NULL",
                Tablas.FOCO, BaseColumns._ID,
                Focos.ID, Focos.NOMBRE,
                Focos.MESA_CONTROL, Focos.DMX,
                Focos.MARCA));
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
