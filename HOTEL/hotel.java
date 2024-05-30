package HOTEL;

import java.util.InputMismatchException;
import java.util.Scanner;

public class hotel {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Habitacion[] habitacionesDisponibles = {
            new HabitacionIndividual("Habitacion Individual", 300, 100, "Baja", 1, 1),
            new HabitacionDoble("Habitacion Doble", 310, 200, "Media", 3, 1),
            new HabitacionSuite("Habitacion Suite", 320, 300, "Alta", 4, "1")
        };

        Factura[] facturas = new Factura[10];
        int opcion = 0;
        int numFacturas = 0;

        CreadorDeArchivos fileHandler = new CreadorDeArchivos();

        while (true) {
            try {
                System.out.println("""
                                   
                                   \u2580\u2588\u2580 \u2591\u2588\u2580\u2580\u2580\u2588 \u2591\u2588\u2580\u2580\u2580\u2588 
                                   \u2591\u2588\u2500 \u2591\u2588\u2500\u2500\u2591\u2588 \u2500\u2580\u2580\u2580\u2584\u2584 
                                   \u2584\u2588\u2584 \u2591\u2588\u2584\u2584\u2584\u2588 \u2591\u2588\u2584\u2584\u2584\u2588 \u00a9 2024""" //
                //
                //
                );
                                        System.out.println();
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
                                if (numHabitacion < 1 || numHabitacion > habitacionesDisponibles.length) {
                                    throw new ArrayIndexOutOfBoundsException("Número de habitación inválido.");
                                }

                                Habitacion habitacionSeleccionada = habitacionesDisponibles[numHabitacion - 1];
                                if (habitacionSeleccionada.getDisponibilidad() > 0) {
                                    scanner.nextLine(); 

                                    String nombreCliente;
                                    while (true) {
                                        System.out.print("Ingrese el nombre del cliente: ");
                                        nombreCliente = scanner.nextLine();
                                        if (!nombreCliente.matches("[\\p{L}\\s]+")) {
                                            System.out.println("Error: El nombre del cliente debe contener solo letras y espacios.");
                                        } else {
                                            break;
                                        }
                                    }

                                    String rfcCliente;
                                    while (true) {
                                        System.out.print("Ingrese el RFC del cliente: ");
                                        rfcCliente = scanner.nextLine();
                                        if (!rfcCliente.matches("[a-zA-Z0-9]+")) {
                                            System.out.println("Error: El RFC del cliente debe contener solo letras y números...");
                                        } else {
                                            break;
                                        }
                                    }

                                    String direccionCliente;
                                    while (true) {
                                        System.out.print("Ingrese la dirección del cliente: ");
                                        direccionCliente = scanner.nextLine();
                                        if (!direccionCliente.matches("[\\p{L}0-9\\s#]+")) {
                                            System.out.println("Error: La dirección del cliente debe contener solo letras, números y caracteres especiales permitidos...");
                                        } else {
                                            break;
                                        }
                                    }

                                    Cliente cliente = new Cliente(nombreCliente, rfcCliente, direccionCliente);
                                    Factura factura = new Factura(cliente, habitacionSeleccionada);

                                    facturas[numFacturas++] = factura;
                                    habitacionSeleccionada.reservarHabitacion();

                                    System.out.println("Habitación reservada con éxito!");
                                    System.out.println("Factura generada: " + factura);
                                    datosValidos = true;
                                } else {
                                    System.out.println("Habitación no disponible... ¡Seleccione otra!");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Entrada inválida... ¡Intente nuevamente!");
                                scanner.nextLine(); 
                            } catch (ArrayIndexOutOfBoundsException e) {
                                System.out.println("Número de habitación inválido... ¡Intente nuevamente!");
                                scanner.nextLine(); 
                            }
                        } while (!datosValidos);
                    }
                    case 2 -> {
                        System.out.println("Información de habitaciones:");
                        for (Habitacion habitacion : habitacionesDisponibles) {
                            System.out.println(habitacion);
                        }
                    }
                    case 3 -> {
                        System.out.println("Facturas generadas:");
                        for (int i = 0; i < numFacturas; i++) {
                            System.out.println(facturas[i]);
                        }
                    }
                    case 4 -> {
                        System.out.println("Guardando facturas, bye :3");
                        fileHandler.openFile();
                        fileHandler.addRecords(facturas, numFacturas);
                        fileHandler.closeFile();
                        System.out.println("Confirmo, ya se guardaron xD.");
                        scanner.close();
                        System.exit(0);
                    }
                    default -> System.out.println("Opción no válida... ¡Intente nuevamente!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida... ¡Intente nuevamente!");
                scanner.nextLine(); 
            }
        }
    }
}
