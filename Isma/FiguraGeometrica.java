package Isma;

abstract class FiguraGeometrica {

    protected String nombre;
    protected String color;
    protected int numero;

    public FiguraGeometrica(String nombre, String color, int numero) {
        this.nombre = nombre;
        this.color = color;
        this.numero = numero;
    }

    public abstract double calcularArea();

    public String getNombre() {
        return nombre;
    }
    public String getColor(){
        return color;
    }
    public int getNumero(){
        return numero;
    }
}
