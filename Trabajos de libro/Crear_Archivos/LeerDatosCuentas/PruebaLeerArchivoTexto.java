package LeerDatosCuentas;
public class PruebaLeerArchivoTexto {

    public static void main(String args[]) {
        LeerArchivoTexto aplicacion = new LeerArchivoTexto();
        aplicacion.abrirArchivo();
        aplicacion.leerRegistros();
        aplicacion.cerrarArchivo();
    } 
}
