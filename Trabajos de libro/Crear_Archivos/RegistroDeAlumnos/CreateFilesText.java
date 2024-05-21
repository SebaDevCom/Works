package RegistroDeAlumnos;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CreateFilesText {

    private Formatter exit;

    public void openFile() {
        try {
            exit = new Formatter("Alumnos.txt");
        } catch (SecurityException securityException) {
            System.out.println("No tienes acceso de escritura a este archivo...");
            System.exit(1);
        } catch (FileNotFoundException filesException) {
            System.err.println("Error al crear archivo...");
            System.exit(1);
        }
    }

    public void addRecords() {
        // students
        StudentsRegistration registro = new StudentsRegistration();
        Scanner teclado = new Scanner(System.in);
        System.out.printf("%s\n%s\n%s\n%s\n\n",
                "Para terminar la entrada, escriba el indicador de fin de archivo ",
                "cuando se le pida que escriba los datos de entrada.",
                "En UNIX/Linux/Mac OS X escriba <ctrl> d y oprima Intro",
                "En Windows escriba <ctrl> z y oprima Intro");
        System.out.printf("%s\n%s\n%s\n",
                "Escriba la matricula del alumno ¡Mayor que 0!, Nombre, Apellidos, Semestre",
                "Calificacion del alumno", "?");

        while (teclado.hasNext()) {
            try {
                registro.setNumControl(teclado.nextInt());
                registro.setNombre(teclado.next());
                registro.setApellidos(teclado.next());
                registro.setSemestre(teclado.next());
                registro.setCalificacion(teclado.nextInt());
                if (registro.getNumControl() > 0) {
                    exit.format("%d %s %s %s %d\n", registro.getNumControl(),
                            registro.getNombre(), registro.getApellidos(),
                            registro.getSemestre(), registro.getCalificacion());
                } else {
                    System.out.println("¡El numero de control debe ser mayor a 0!");
                }
            } catch (FormatterClosedException formatterClosedException) {
                System.err.println("Error: no se pudo escribir en el archivo...");
                return;
            } catch (NoSuchElementException elementException) {
                System.err.println("Entrada invalida, intente de nuevo...");
                teclado.nextLine(); // clear the invalid input
            }
            System.out.printf("%s\n%s",
                    "Escriba la matricula del alumno ¡Mayor que 0!, Nombre, Apellidos, Semestre, Calificación",
                    "?");
        }
    }

    public void cerrarArchivo() {
        if (exit != null) {
            exit.close();
        }
    }

    public static void main(String[] args) {
        CreateFilesText app = new CreateFilesText();
        app.openFile();
        app.addRecords();
        app.cerrarArchivo();
    }
}
