package HOTEL;

import java.util.List;

public class Reader {

    public static void main(String[] args) {
        List<Cliente> clientes = FileReader.loadClientes();
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }
}