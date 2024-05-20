package HOTEL;

import java.util.InputMismatchException;
import java.util.Scanner;

public class hotel {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Habitacion[] habitacionesDisponibles = {
                new HabitacionIndividual("Habitacion Individual", 300, 100, "Baja", 0, 1),
                new HabitacionDoble("Habitacion Doble", 310, 200, "Media", 2, 2),
                new HabitacionSuite("Habitacion Suite", 320, 300, "Alta", 3, "1")
            };

            Factura[] facturas = new Factura[10];

            int opcion = 0;
            int numFacturas = 0;
            do {
                try {
                    System.out.println("Hotel los tilinos");
                    System.out.println("Menú:");
                    System.out.println("1) Reservar Habitación");
                    System.out.println("2) Mostrar información de habitaciones");
                    System.out.println("3) Facturas");
                    System.out.println("4) Salir");
                    System.out.print("Ingrese su opción: ");
                    opcion = scanner.nextInt();

                    switch (opcion) {
                        case 1 -> {
                            boolean datosValidos = false;
                            do {
                                try {
                                    System.out.println("Habitaciones Disponibles:");
                                    for (int i = 0; i < habitacionesDisponibles.length; i++) {
                                        System.out.println((i + 1) + ") " + habitacionesDisponibles[i].getTipo() + ": " + habitacionesDisponibles[i].getDisponibilidad() + " Disponibles");
                                    }
                                    System.out.print("Seleccione el número de la habitación que desea reservar: ");
                                    int numHabitacion = scanner.nextInt();
                                    Habitacion habitacionSeleccionada = habitacionesDisponibles[numHabitacion - 1];
                                    if (habitacionSeleccionada.getDisponibilidad() > 0) {
                                        System.out.println("El costo total es: $" + habitacionSeleccionada.calcularCostoTotal());
                                        scanner.nextLine(); 
                                        String nombreCliente;
                                        boolean nombreValido = false;
                                        do {
                                            System.out.print("Ingrese el nombre del cliente: ");
                                            nombreCliente = scanner.nextLine();
                                            if (!nombreCliente.matches("[\\p{L}\\s]+")) {
                                                System.out.println("Error: El nombre del cliente debe contener solo letras y espacios.");
                                            } else {
                                                nombreValido = true;
                                            }
                                        } while (!nombreValido);
                                        
                                        String rfcCliente;
                                        boolean rfcValido = false;
                                        do {
                                            System.out.print("Ingrese el RFC del cliente: ");
                                            rfcCliente = scanner.nextLine();
                                            if (!rfcCliente.matches("[a-zA-Z0-9]+")) {
                                                System.out.println("Error: El RFC del cliente debe contener solo letras y números.");
                                            } else {
                                                rfcValido = true;
                                            }
                                        } while (!rfcValido);
                                        
                                        String direccionCliente;
                                        boolean direccionValida = false;
                                        do {
                                            System.out.print("Ingrese la dirección del cliente: ");
                                            direccionCliente = scanner.nextLine();
                                            if (!direccionCliente.matches("[\\p{L}0-9\\s#]+")) {
                                                System.out.println("Error: La dirección del cliente debe contener solo letras, números y caracteres especiales permitidos.");
                                            } else {
                                                direccionValida = true;
                                            }
                                        } while (!direccionValida);

                                        System.out.println("¡Registro exitoso, hasta luego!");


                                        Cliente cliente = new Cliente(nombreCliente, rfcCliente, direccionCliente);
                                        facturas[numFacturas] = new Factura(cliente, habitacionSeleccionada);
                                        numFacturas++;
                                        habitacionSeleccionada.reservarHabitacion();
                                        datosValidos = true; 
                                    } else {
                                        System.out.println("Lo sentimos no hay disponibilidad para esta habitación.");
                                        datosValidos = true; 
                                    }
                                } catch (IllegalArgumentException e) {
                                    System.out.println("Error: " + e.getMessage());
                                }
                            } while (!datosValidos);
                        }
                        case 2 -> {
                            System.out.println("Información de habitaciones:");
                            for (Habitacion habitacion : habitacionesDisponibles) {
                                System.out.println(habitacion.toString());
                            }
                        }
                        case 3 -> {
                            System.out.println("Facturas:");
                            for (int i = 0; i < numFacturas; i++) {
                                System.out.println("Factura " + (i + 1) + ":");
                                System.out.println(facturas[i]);
                            }
                        }
                        case 4 ->
                            System.out.println("Saliendo...");
                        default ->
                            System.out.println("Opción inválida...");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Debe ingresar una opción valida...");
                    scanner.nextLine();
                    opcion = 0;
                }
            } while (opcion != 4);
        }
    }
}