package Serializable.LeerArchivoSecuencia;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import Serializable.RegistroCuentaSerializable;

public class LeerArchivoSecuencial {

    private ObjectInputStream entrada;

    public void abrirArchivo() {
        try {
            entrada = new ObjectInputStream(
                    new FileInputStream("clientes.ser"));
        } catch (IOException ioException) {
            System.err.println("Error al abrir el archivo.");
        }
    }

    public void leerRegistros() {
        RegistroCuentaSerializable registro;
        System.out.printf("%-10s%-15s%-15s%10s\n", "Cuenta",
                "Primer nombre", "Apellido paterno", "Saldo");
        try {
            while (true) {
                registro = (RegistroCuentaSerializable) entrada.readObject();

                System.out.printf("%-10d%-15s%-15s%11.2f\n",
                        registro.obtenerCuenta(), registro.obtenerPrimerNombre(),
                        registro.obtenerApellidoPaterno(), registro.obtenerSaldo());
            }
        } catch (EOFException endOfFileException) {
            return;
        } catch (ClassNotFoundException classNotFoundException) {
            System.err.println("No se pudo crear el objeto.");
        } catch (IOException ioException) {
            System.err.println("Error al leer el archivo.");
        }

    }

    public void cerrarArchivo() {
        try // cierra el archivo y sale
        {
            if (entrada != null) {
                entrada.close();
            }
            System.exit(0);
        } catch (IOException ioException) {
            System.err.println("Error al cerrar el archivo.");
            System.exit(1);
        }
    }
}
