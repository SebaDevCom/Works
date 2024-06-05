package HOTEL;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LeerArchivosHotel {

    public void readFacturas() {
        File folder = new File(".");
        File[] listOfFiles = folder.listFiles((dir, name) -> name.startsWith("Factura_") && name.endsWith(".txt"));

        if (listOfFiles != null && listOfFiles.length > 0) {
            System.out.println("Facturas almacenadas:");
            for (File file : listOfFiles) {
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        System.out.println(line);
                    }
                    System.out.println(); 
                } catch (IOException e) {
                    System.err.println("Error al leer el archivo de facturas: " + file.getName());
                }
            }
        } else {
            System.out.println("No se encontraron archivos de facturas.");
        }
    }
}
