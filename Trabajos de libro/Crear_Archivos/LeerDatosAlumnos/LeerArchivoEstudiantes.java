package LeerDatosAlumnos;

import RegistroDeAlumnos.StudentsRegistration;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class LeerArchivoEstudiantes {

    private Scanner entrada;
    private int totalCalificaciones;
    private int totalRegistros;

    
    public void abrirArchivo() {
        try {
            entrada = new Scanner(new File("Alumnos.txt"));
        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("Error al abrir el archivo.");
            System.exit(1);
        }
    } 

    public void leerRegistros() {
 
        StudentsRegistration registro = new StudentsRegistration();
        System.out.printf(
                "%-12s%-15s%-20s%-10s%-15s\n", "NumControl",
                "Nombre", "Apellidos", "Semestre", "Calificacion");

        try {
            while (entrada.hasNext()) {
                registro.setNumControl(entrada.nextInt()); 
                registro.setNombre(entrada.next()); 
                registro.setApellidos(entrada.next());
                registro.setSemestre(entrada.next()); 
                registro.setCalificacion(entrada.nextInt()); 

                totalCalificaciones += registro.getCalificacion(); 
                totalRegistros++;

                System.out.printf("%-12d%-15s%-20s%-10s%-15d\n",
                        registro.getNumControl(), registro.getNombre(),
                        registro.getApellidos(), registro.getSemestre(),
                        registro.getCalificacion());
            }
        } catch (NoSuchElementException elementException) {
            System.err.println("El archivo no está bien formado.");
            entrada.close();
            System.exit(1);
        } catch (IllegalStateException stateException) {
            System.err.println("Error al leer del archivo.");
            System.exit(1);
        }

        double promedio = (double) totalCalificaciones / totalRegistros;
        System.out.println("El promedio del grupo es: " + promedio);
    } 


    public void cerrarArchivo() {
        if (entrada != null) {
            entrada.close(); 
        }
    } 
}
