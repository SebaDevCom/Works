package LeerDatosAlumnos;

public class PruebaDeLeer {

    public static void main(String args[]) {
        LeerArchivoEstudiantes aplicacion = new LeerArchivoEstudiantes();
        aplicacion.abrirArchivo();
        aplicacion.leerRegistros();
        aplicacion.cerrarArchivo();
    } 
}

