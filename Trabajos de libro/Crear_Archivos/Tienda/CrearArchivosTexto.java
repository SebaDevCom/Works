package Tienda;

import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.NoSuchElementException;
import java.util.Scanner;
public class CrearArchivosTexto{
    private Formatter salida;

    public void abrirArchivo(){
        try{
            salida = new Formatter("Productos.txt");
        }
        catch (SecurityException securityException){
            System.err.println("No tiene acceso de escritura a este archivo.");
            System.exit(1);
        }
        catch (FileNotFoundException filesNotFoundException){
            System.err.println("Error al crear archivo...");
            System.exit(1);
        }
    }

    public void agregarRegistros(){
        RegistroDeProductos registro = new RegistroDeProductos();
        Scanner teclado = new Scanner(System.in);
        System.out.printf("%s\n%s\n%s\n%s\n\n",
        "Para terminar de ingresar productos pude presionar los siguientes comandos ",
                "cuando se le pida que escriba los datos de entrada.",
                "En UNIX/Linux/Mac OS X escriba <ctrl> d y oprima Intro",
                "En Windows escriba <ctrl> z y oprima Intro");
                System.out.printf("%s\n%s",
                "Escriba el numero del producto (> 0), Nombre, Tipo y precio.", "?");

                while (teclado.hasNext())
                {
                    try {
                        registro.SetNumoproc(teclado.nextInt());
                        registro.SetNom(teclado.next());
                        registro.SetTipo(teclado.next());
                        registro.SetPrecio(teclado.nextDouble());
                        if (registro.getNumproc() > 0){
                            salida.format("%d %s %s %.2f\n", registro.getNumproc(),
                            registro.getNom(), registro.getTipo(),
                            registro.getPrecio());
                        }
                        else{
                            System.out.println(
                                "El numero del producto debe ser mayor que 0.");
                        }
                    }
                    catch (NoSuchElementException elementException){
                        System.err.println("Entrada invalida. Intenta de nueva");
                        teclado.nextLine();
                    }
                    System.out.printf("%s %s\n%s", "Escriba el numero del producto (> 0),", "Nombre del producto, Tipo del producto y precio.", "? ");
                }
    }

    public void cerrarArchivo(){
        if (salida != null){
            salida.close();
        }
    }
}