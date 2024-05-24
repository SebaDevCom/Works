package Serializable;

class PruebaCrearArchivoSecuencial {

    public static void main(String args[]) {
        CrearArchivoSecuencial aplicacion = new CrearArchivoSecuencial();
        aplicacion.abrirArchivo();
        aplicacion.agregarRegistros();
        aplicacion.cerrarArchivo();
    } 
} 
