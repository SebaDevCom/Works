package HOTEL;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class FileHandler {

    private ObjectOutputStream output;

    public void openFile(String filename) {
        try {
            output = new ObjectOutputStream(new FileOutputStream(filename));
        } catch (IOException ioException) {
            System.err.println("Error al abrir el archivo...");
        }
    }

    public void addRecords(Factura[] facturas, int numFacturas) {
        try {
            for (int i = 0; i < numFacturas; i++) {
                output.writeObject(facturas[i]);
            }
        } catch (IOException ioException) {
            System.err.println("Error al escribir en el archivo...");
        }
    }

    public void closeFile() {
        try {
            if (output != null) {
                output.close();
            }
        } catch (IOException ioException) {
            System.err.println("Error al cerrar el archivo.");
            System.exit(1);
        }
    }
}
