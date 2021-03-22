package com.example.tecniled;

/* Clase que establece los nombres a usar en la base de datos */

import java.util.UUID;

public class NombresBD {

    interface ColumnasFoco{
        String ID = "id";
        String NOMBRE = "nombre";
        String MARCA = "marca";
        String MESA_CONTROL = "mesa_control";
        String DMX = "dmx";
    }

    interface ColumnasGrupo{
        String ID = "id";
        String NOMBRE = "nombre";
        String UBICACION = "ubicacion";
        String ID_FOCO = "id_foco";
    }

    interface ColumnasProyecto{
        String ID = "id";
        String NOMBRE = "nombre";
        String FECHA = "fecha";
        String OBSERVACIONES = "observaciones";
        String ID_GRUPO = "id_grupo";
    }

    public static class Focos implements ColumnasFoco{
        public static String generarIdFoco(){
            return "FOCO - " + UUID.randomUUID().toString();
        }
    }

    public static class Grupos implements ColumnasGrupo{
        public static String generarIdGrupo(){
            return "GRUPO - " + UUID.randomUUID().toString();
        }
    }

    public static class Proyectos implements ColumnasProyecto{
        public static String generarIdProyecto(){
            return "PROYECTO - " + UUID.randomUUID().toString();
        }
    }
}
