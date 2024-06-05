package Isma;

class Circulo extends FiguraGeometrica{
    private double radio;

    public Circulo(String nombre, String color, int numero, double radio){
        super(nombre, color, numero);
        this.radio = radio;
    }
    public void setRadio(double radio){
        this.radio = radio;
    }
    public double getRadio(){
        return radio;
    }


    public double calcularArea(){
        return Math.PI*Math.pow(radio,2);
    }
    
}
