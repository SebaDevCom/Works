package HOTEL;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CreadorDeArchivos {

    public void addRecord(Factura factura) {
        String fileName = "Factura_" + factura.getCliente().getRfc() + ".txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(factura.toString());
        } catch (IOException ioException) {
            System.err.println("Error al escribir en el archivo " + fileName);
        }
    }
}
