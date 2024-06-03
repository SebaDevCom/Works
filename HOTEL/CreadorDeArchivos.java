package HOTEL;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CreadorDeArchivos {

    private BufferedWriter writer;

    public void openFile(String fileName) {
        try {
            writer = new BufferedWriter(new FileWriter(fileName));
        } catch (IOException ioException) {
            System.err.println("Error al abrir el archivo " + fileName);
        }
    }

    public void addRecord(Factura factura) {
        try {
            if (writer != null) {
                writer.write(factura.toString());
                writer.newLine(); 
            }
        } catch (IOException ioException) {
            System.err.println("Error al escribir en el archivo " + factura.getCliente().getRfc());
        }
    }

    public void closeFile() {
        try {
            if (writer != null) {
                writer.close();
            }
        } catch (IOException ioException) {
            System.err.println("Error al cerrar el archivo.");
        }
    }
}
