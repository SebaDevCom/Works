package HOTEL;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class FileReader {

    public void readFacturas() {
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("Facturas.ser"))) {
            System.out.println("Facturas almacenadas:");
            while (true) {
                Factura factura;
                try {
                    factura = (Factura) input.readObject();
                } catch (ClassNotFoundException e) {
                    System.err.println("Clase no encontrada al leer el archivo.");
                    continue;
                }
                
                if (factura != null) {
                    System.out.println(factura);
                } else {
                    break; 
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo de facturas: " + e.getMessage());
        }
    }
}

