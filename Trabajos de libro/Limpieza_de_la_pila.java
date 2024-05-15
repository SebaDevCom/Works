
public class Limpieza_de_la_pila {

    public static void main(String args[]) {
        try {
            lanzaExcepcion();
        } catch (Exception excepcion) {
            System.err.println("La excepcion se manejo en main");
        }
    }

    public static void lanzaExcepcion() throws Exception {
        try // lanza una excepción y la atrapa en main
        {
            System.out.println("Metodo lanzaExcepcion");
            throw new Exception();
        } catch (RuntimeException runtimeException) {
            System.err.println(
                    "La excepcion se manejo en el metodo lanzaExcepcion");
        } finally // el bloque finally siempre se ejecuta
        {
            System.err.println("Finally siempre se ejecuta");
        }
    }
}
