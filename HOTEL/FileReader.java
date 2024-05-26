package HOTEL;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class FileReader {

    @SuppressWarnings("unchecked")
    public static List<Cliente> loadClientes() {
        List<Cliente> clientes = new ArrayList<>();
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("clientes.ser"))) {
            Object obj;
            while ((obj = input.readObject()) != null) {
                if (obj instanceof Cliente) {
                    clientes.add((Cliente) obj);
                }
            }
        } catch (IOException ioException) {
            if (ioException instanceof java.io.EOFException) {
            } else {
                System.err.println("Error al leer el archivo: ");
                ioException.printStackTrace();
            }
        } catch (ClassNotFoundException classNotFoundException) {
            System.err.println("Clase no encontrada: " + classNotFoundException.getMessage());
        }
        return clientes;
    }
}
