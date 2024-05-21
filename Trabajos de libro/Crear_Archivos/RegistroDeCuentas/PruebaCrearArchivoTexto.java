package RegistroDeCuentas;
public class PruebaCrearArchivoTexto {

    public static void main(String args[]) {
        CrearArchivoTexto aplicacion = new CrearArchivoTexto();
        aplicacion.abrirArchivo();
        aplicacion.agregarRegistros();
        aplicacion.cerrarArchivo();
    } 
} 
