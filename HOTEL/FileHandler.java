package HOTEL;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class FileHandler {

    public static void saveClientes(List<Cliente> clientes) {
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("clientes.ser"))) {
            for (Cliente cliente : clientes) {
                output.writeObject(cliente);
            }
        } catch (IOException ioException) {
            System.err.println("Error al escribir en el archivo: " + ioException.getMessage());
        }
    }
}
