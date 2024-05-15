package Loops;

public class test {

    public static void main(String[] args) {

        System.out.println("Bucle Con For: ");
        System.out.println();

        int i; //Siempre tenemos que declarar la variable
        for (i = 0; i < 20; i++) { //Siempre tenemos que declarar la variable con la condicion
            System.out.println("Linea: " + i); // Aqui es necesario para mirar los resultados
        }

        System.out.println();
        System.out.println("Bucle While: 2");
        System.out.println();

        int contador = 0;
        while (contador < 20) {
            System.out.println("Linea: " + contador);
            contador++;
        }

        System.out.println();
        System.out.println("Bucle do-while: 3");
        System.out.println();

        int contadoor = 0;
        do {
            System.out.println("Linea: " + contadoor);
            contadoor++;
        } while (contadoor < 20);

    }
}
