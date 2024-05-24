package Serializable.LeerArchivoSecuencia;

public class PruebaLeerArchivoSecuencial {

    public static void main(String args[]) {
        LeerArchivoSecuencial aplicacion = new LeerArchivoSecuencial();
        aplicacion.abrirArchivo();
        aplicacion.leerRegistros();
        aplicacion.cerrarArchivo();
    }
}