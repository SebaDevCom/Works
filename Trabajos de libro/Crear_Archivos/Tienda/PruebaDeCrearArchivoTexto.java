package Tienda;

public class PruebaDeCrearArchivoTexto {
    public static void main(String[] args) {
        CrearArchivosTexto app = new CrearArchivosTexto();
        app.abrirArchivo();
        app.agregarRegistros();
        app.cerrarArchivo();
    }
}
