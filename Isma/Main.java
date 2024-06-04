package Isma;

public class Main {

    public static void main(String[] args) {
        Cuadrado cuadrado1 = new Cuadrado("Cuadrado 1", "rojo", 2, 10.0);
        mostrarArea(cuadrado1);

        Circulo circulo1 = new Circulo("Circulo1", "verde", 5, 8.0);
        mostrarArea(circulo1);
    }

    private static void mostrarArea(FiguraGeometrica figura) {
        System.out.println("El área del " + figura.getNombre()  +" es: " + figura.calcularArea()+ " de color: "+ figura.getColor()+ " con numero: "+ figura.getNumero());
    }
}
 