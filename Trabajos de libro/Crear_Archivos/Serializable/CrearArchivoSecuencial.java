package Serializable;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CrearArchivoSecuencial {

    private ObjectOutputStream salida;

    public void abrirArchivo() {
        try {
            salida = new ObjectOutputStream(
                    new FileOutputStream("clientes.ser"));
        } catch (IOException ioException) {
            System.err.println("Error al abrir el archivo.");
        }
    }

    public void agregarRegistros() {
        RegistroCuentaSerializable registro;
        int numeroCuenta = 0;
        String primerNombre;
        String apellidoPaterno;
        double saldo;
        Scanner entrada = new Scanner(System.in);
        System.out.printf("%s\n%s\n%s\n%s\n\n",
                "Para terminar de introducir datos, escriba el indicador de fin de archivo",
                "Cuando se le pida que introduzca los datos.",
                "En UNIX/Linux/Mac OS X escriba <ctrl> d y oprima Intro",
                "En Windows escriba <ctrl> z y oprima Intro");
        System.out.printf("%s\n%s",
                "Escriba el numero de cuenta (> 0), primer nombre, apellido y saldo.",
                "? ");
        while (entrada.hasNext()) {
            try {
                numeroCuenta = entrada.nextInt();
                primerNombre = entrada.next();
                apellidoPaterno = entrada.next();
                saldo = entrada.nextDouble();
                if (numeroCuenta > 0) {

                    registro = new RegistroCuentaSerializable(numeroCuenta, primerNombre, apellidoPaterno, saldo);
                    salida.writeObject(registro);
                } else {
                    System.out.println("El numero de cuenta debe ser mayor de 0.");
                }
            } catch (IOException ioException) {
                System.err.println("Error al escribir en el archivo.");
                return;
            } catch (NoSuchElementException elementException) {
                System.err.println("Entrada invalida. Intente de nuevo.");
                entrada.nextLine();
            }

            System.out.printf("%s %s\n%s", "Escriba el numero de cuenta (>0),",
                    "primer nombre, apellido y saldo.", "? ");
        }
    }

    public void cerrarArchivo() {
        try // cierra el archivo
        {
            if (salida != null) {
                salida.close();
            }
        } catch (IOException ioException) {
            System.err.println("Error al cerrar el archivo.");
            System.exit(1);
        }
    }
}
