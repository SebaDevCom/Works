public class try_catch_finally {

    public static void main(String args[]) {
        try {
            lanzaExcepcion();
        } catch (Exception excepcion) {
            System.err.println("La excepcion se manejo en main");
        }
        noLanzaExcepcion();
    }

    public static void lanzaExcepcion() throws Exception {
        try {
            System.out.println("Metodo lanzaExcepcion");
            throw new Exception();
        } catch (Exception excepcion) {
            System.err.println("La excepcion se manejo en el metodo lanzaExcepcion");
            throw excepcion;
        } finally {
            System.err.println("Se ejecuto finally en lanzaExcepcion"); 
        }

    }

    public static void noLanzaExcepcion() {
        try {
            System.out.println("Metodo noLanzaExcepcion");
        } catch (Exception excepcion) {
            System.err.println(excepcion);
        }

        {
            System.err.println("Se ejecuto F inally en noLanzaExcepcion");
        }

        System.out.println("Fin del metodo noLanzaExcepcion");
    }
}
