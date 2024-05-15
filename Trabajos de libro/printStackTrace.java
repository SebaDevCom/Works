public class printStackTrace {
    public static void main(String args[]) {
        try {
            metodo1();
        } catch (Exception excepcion) {
            System.err.printf("%s\n\n", excepcion.getMessage());
            excepcion.printStackTrace();
            StackTraceElement[] elementosRastreo = excepcion.getStackTrace();
            System.out.println("\nRastreo de la pila de getStackTrace:");
            System.out.println("Clase\t\t\tArchivo\t\t\tLinea\tMetodo");
            for (StackTraceElement elemento : elementosRastreo) {
                System.out.printf("%s\t", elemento.getClassName());
                System.out.printf("%s\t", elemento.getFileName());
                System.out.printf("%s\t", elemento.getLineNumber());
                System.out.printf("%s\n", elemento.getMethodName());
            }
        }
    }

    public static void metodo1() throws Exception {
        metodo2();
    }

    public static void metodo2() throws Exception {
        metodo3();
    }

    public static void metodo3() throws Exception {
        throw new Exception("La excepcion se lanzo en metodo3");
    }
}
