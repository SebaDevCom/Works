import java.util.Scanner;

public class PruebaDemostracionFile {

    public static void main(String args[]) {
        Scanner entrada = new Scanner(System.in);
        DemostracionFile aplicacion = new DemostracionFile();
        System.out.print("Escriba aqui el nombre del archivo o directorio: ");
        aplicacion.analizarRuta(entrada.nextLine());
    }
}
