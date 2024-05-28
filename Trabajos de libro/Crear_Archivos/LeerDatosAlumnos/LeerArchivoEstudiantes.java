package LeerDatosAlumnos;

import RegistroDeAlumnos.StudentsRegistration;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;

public class LeerArchivoEstudiantes {

    private ObjectInputStream entrada;
    private int totalCalificaciones;
    private int totalRegistros;
    private PrintWriter salida;

    public void abrirArchivo() {
        try {
            entrada = new ObjectInputStream(new FileInputStream("Alumnos.ser"));
            salida = new PrintWriter(new FileWriter("CopiaDeEstudiantes.text"));
        } catch (IOException ioException) {
            System.err.println("Error al abrir el archivo.");
            System.exit(1);
        }
    }

    public void leerRegistros() {
        System.out.printf(
                "%-12s%-15s%-20s%-10s%-15s\n", "NumControl",
                "Nombre", "Apellidos", "Semestre", "Calificacion");
        salida.printf(
                "%-12s%-15s%-20s%-10s%-15s\n", "NumControl",
                "Nombre", "Apellidos", "Semestre", "Calificacion");

        try {
            while (true) {
                StudentsRegistration registro = (StudentsRegistration) entrada.readObject();

                totalCalificaciones += registro.getCalificacion();
                totalRegistros++;

                System.out.printf("%-12d%-15s%-20s%-10s%-15d\n",
                        registro.getNumControl(), registro.getNombre(),
                        registro.getApellidos(), registro.getSemestre(),
                        registro.getCalificacion());
                salida.printf("%-12d%-15s%-20s%-10s%-15d\n",
                        registro.getNumControl(), registro.getNombre(),
                        registro.getApellidos(), registro.getSemestre(),
                        registro.getCalificacion());
            }
         } catch (EOFException eofException) {
     } catch (ClassNotFoundException classNotFoundException) {
            System.err.println("No se pudo crear el objeto...");
 } catch (IOException ioException) {
            System.err.println("Error al leer del archivo...");
        } finally {
            cerrarArchivo();
        }

        if (totalRegistros > 0) {
            double promedio = (double) totalCalificaciones / totalRegistros;
            System.out.println("El promedio del grupo es: " + promedio);
            salida.println("El promedio del grupo es: " + promedio);
        } else {
            System.out.println("No se encontraron registros...");
            salida.println("No se encontraron registros...");
        }
    }

    public void cerrarArchivo() {
        try {
            if (entrada != null) {
                entrada.close();
            }
            if (salida != null) {
                salida.close();
            }
        } catch (IOException ioException) {
            System.err.println("Error al cerrar el archivo...");
            System.exit(1);
        }
    }
}
