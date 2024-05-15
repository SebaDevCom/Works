package Hotel;

import java.util.InputMismatchException;
import java.util.Scanner;

public class hotel {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Habitacion[] habitacionesDisponibles = {
                new HabitacionIndividual("Habitacion Individual", 300, 100, "Baja", 1, 1),
                new HabitacionDoble("Habitacion Doble", 310, 200, "Media", 2, 1),
                new HabitacionSuite("Habitacion Suite", 320, 300, "Alta", 3, "Quinsall")
            };

            Factura[] facturas = new Factura[10];

            int opcion = 0;
            int numFacturas = 0;
            do {
                try {
                    System.out.println("Hotel los tilinos");
                    System.out.println("Menu:");
                    System.out.println("1) Reservar Habitación");
                    System.out.println("2) Facturas");
                    System.out.println("3) Salir");
                    System.out.print("Ingrese su opción: ");
                    opcion = scanner.nextInt();

                    switch (opcion) {
                        case 1 -> {
                            System.out.println("Habitaciones Disponibles:");
                            for (int i = 0; i < habitacionesDisponibles.length; i++) {
                                System.out.println((i + 1) + ") " + habitacionesDisponibles[i].getTipo() + ": " + habitacionesDisponibles[i].getDisponibilidad() + " Disponibles");
                            }
                            System.out.print("Seleccione el número de la habitación que desea reservar: ");
                            int numHabitacion = scanner.nextInt();
                            Habitacion habitacionSeleccionada = habitacionesDisponibles[numHabitacion - 1];
                            if (habitacionSeleccionada.getDisponibilidad() > 0) {
                                System.out.println("El costo total es: $" + habitacionSeleccionada.calcularCostoTotal());
                                System.out.print("Ingrese el nombre del cliente: ");
                                String nombreCliente = scanner.next();
                                if (!nombreCliente.matches("[a-zA-Z]+")) {
                                    throw new IllegalArgumentException("El nombre del cliente debe contener solo letras.");
                                }
                                System.out.print("Ingrese el RFC del cliente: ");
                                String rfcCliente = scanner.next();
                                if (!rfcCliente.matches("[a-zA-Z0-9]+")) {
                                    throw new IllegalArgumentException("El RFC del cliente debe contener solo letras y números.");
                                }
                                System.out.print("Ingrese la dirección del cliente: ");
                                String direccionCliente = scanner.next();
                                if (!direccionCliente.matches("[a-zA-Z0-9\\s]+")) {
                                    throw new IllegalArgumentException("La dirección del cliente debe contener solo letras, números.");
                                }
                                Cliente cliente = new Cliente(nombreCliente, rfcCliente, direccionCliente);
                                facturas[numFacturas] = new Factura(cliente, habitacionSeleccionada);
                                numFacturas++;
                                habitacionSeleccionada.reservarHabitacion();
                            } else {
                                System.out.println("Lo sentimos no hay disponibilidad para esta habitación.");
                            }
                        }
                        case 2 -> {
                            System.out.println("Facturas:");
                            for (int i = 0; i < numFacturas; i++) {
                                System.out.println("Factura " + (i + 1) + ":");
                                System.out.println(facturas[i]);
                            }
                        }
                        case 3 ->
                            System.out.println("Saliendo...");
                        default ->
                            System.out.println("Opción inválida...");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Debe ingresar ");
                    scanner.nextLine();
                    opcion = 0;
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            } while (opcion != 3);
        }
    }
}
