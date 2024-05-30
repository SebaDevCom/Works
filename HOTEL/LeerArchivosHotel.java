package HOTEL;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LeerArchivosHotel {

    public void readFacturas() {
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("Facturas.ser"))) {
            System.out.println("Facturas almacenadas:");
            while (true) {
                try {
                    Factura factura = (Factura) input.readObject();
                    System.out.println(factura);
                } catch (EOFException eofException) {
                    break;
                } catch (ClassNotFoundException e) {
                    System.err.println("Clase no encontrada al leer el archivo.");
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo de facturas: " + e.toString());
        }
    }
}
