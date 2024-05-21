package LeerDatosCuentas;

import RegistroDeCuentas.RegistroCuenta;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;



public class LeerArchivoTexto {

    private Scanner entrada;

    // permite al usuario abrir el archivo
    public void abrirArchivo() {
        try {
            entrada = new Scanner(new File("clientes.txt"));
        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("Error al abrir el archivo.");
            System.exit(1);
        }
    } 

    // lee registros del archivo
    public void leerRegistros() {
        // objeto que se va a escribir en la pantalla
        RegistroCuenta registro = new RegistroCuenta();
        System.out.printf(
                "%-9s%-15s%-18s%10s\n", "Cuenta",
                "Primer nombre", "Apellido paterno", "Saldo");

        try {
            while (entrada.hasNext()) {
                registro.establecerCuenta(entrada.nextInt()); // lee el número de cuenta
                registro.establecerPrimerNombre(entrada.next()); // lee el primer nombre
                registro.establecerApellidoPaterno(entrada.next()); // lee el apellido paterno
                registro.establecerSaldo(entrada.nextDouble()); // lee el saldo

                // muestra el contenido del registro
                System.out.printf("%-9d%-15s%-18s%10.2f\n",
                        registro.obtenerCuenta(), registro.obtenerPrimerNombre(),
                        registro.obtenerApellidoPaterno(), registro.obtenerSaldo());
            }
        } catch (NoSuchElementException elementException) {
            System.err.println("El archivo no está bien formado.");
            entrada.close();
            System.exit(1);
        } catch (IllegalStateException stateException) {
            System.err.println("Error al leer del archivo.");
            System.exit(1);
        }
    } 

    // cierra el archivo y termina la aplicación
    public void cerrarArchivo() {
        if (entrada != null) {
            entrada.close(); // cierra el archivo
        }
    } 
}