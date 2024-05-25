package RegistroDeAlumnos;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CreateFilesText {

    private ObjectOutputStream exit;

    public void openFile() {
        try {
            exit = new ObjectOutputStream(new FileOutputStream("Alumnos.ser"));
        } catch (IOException iOException) {
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
        System.out.printf("%s%s",
                "Escriba la matricula del alumno ¡Mayor que 0!, Nombre, Apellidos, Semestre,"," Calificacion del alumno:");

        while (teclado.hasNext()) {
            try {
                int NumControl = teclado.nextInt();
                if(NumControl > 0){ 
                NumControl = (NumControl);
                nombre = teclado.next();
                apellidos = (teclado.next());
                semestre = (teclado.next());
                calificacion = (teclado.nextInt());

                registro = new StudentsRegistration(NumControl, nombre);

                } else {
                    System.out.println("¡El numero de control debe ser mayor a 0!");
                    teclado.nextLine();
                }
            } catch (FormatterClosedException formatterClosedException) {
                System.err.println("Error: no se pudo escribir en el archivo...");
                return;
            } catch (NoSuchElementException elementException) {
                System.err.println("Entrada invalida, intente de nuevo...");
                teclado.nextLine();
            }
            System.out.printf("%s",
                    "Escriba la matricula del alumno ¡Mayor que 0!, Nombre, Apellidos, Semestre, Calificación:");
        }
    }

    public void cerrarArchivo() {
        if (exit != null) {
            exit.close();
        }
    }
}