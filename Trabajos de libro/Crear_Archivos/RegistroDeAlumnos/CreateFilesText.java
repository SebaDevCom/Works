package RegistroDeAlumnos;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CreateFilesText {

    private ObjectOutputStream output;

    public void openFile() {
        try {
            output = new ObjectOutputStream(new FileOutputStream("Alumnos.ser"));
            output = new ObjectOutputStream(new FileOutputStream("Copia.ser"));
        } catch (IOException ioException) {
            System.err.println("Error al abrir el archivo...");
        }
    }

    public void addRecords() {
        StudentsRegistration registro;
        String nombre;
        String apellidos;
        String semestre;
        int calificacion;
        Scanner teclado = new Scanner(System.in);
        System.out.printf("%s\n%s\n%s\n%s\n\n",
                "Para terminar la entrada, escriba el indicador de fin de archivo ",
                "cuando se le pida que escriba los datos de entrada.",
                "En UNIX/Linux/Mac OS X escriba <ctrl> d y oprima Intro",
                "En Windows escriba <ctrl> z y oprima Intro");
        System.out.printf("%s",
        "Escriba la matricula del alumno ¡Mayor que 0!, Nombre, Apellidos, Semestre, Calificación del alumno:");

        while (teclado.hasNext()) {
            try {
                int numControl = teclado.nextInt();
                if (numControl > 0) {
                    nombre = teclado.next();
                    apellidos = teclado.next();
                    semestre = teclado.next();
                    calificacion = teclado.nextInt();

                    registro = new StudentsRegistration(numControl, nombre, apellidos, semestre, calificacion, calificacion);
                    output.writeObject(registro);
                } else {
                    System.out.println("¡El número de control debe ser mayor a 0!");
                    teclado.nextLine();
                }
            } catch (IOException ioException) {
                System.err.println("Error al escribir en el archivo...");
                return;
            } catch (NoSuchElementException elementException) {
                System.err.println("Entrada inválida, intente de nuevo...");
                teclado.nextLine(); 
            }
            System.out.printf("%s",
                    "Escriba la matricula del alumno ¡Mayor que 0!, Nombre, Apellidos, Semestre, Calificación del alumno:");
        }
    }

    public void closeFile() {
        try {
            if (output != null) {
                output.close();
            }
        } catch (IOException ioException) {
            System.err.println("Error al cerrar el archivo.");
            System.exit(1);
        }
    }
}