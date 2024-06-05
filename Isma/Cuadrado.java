package Isma;

class Cuadrado extends FiguraGeometrica {

    private double lado;

    public Cuadrado(String nombre, String color , int numero, double lado) {
        super(nombre, color , numero);
        this.lado = lado;
    }

    @Override
    public double calcularArea() {
        return Math.pow(lado, 2);
    }
}