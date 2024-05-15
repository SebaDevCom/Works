package HOTEL;

abstract class Habitacion {

    private static int contadorHabitaciones = 1;
    private String tipo;
    private int numHabitacion;
    private double precio;
    private String planta;
    private int disponibilidad;

    public Habitacion(String tipo, double precio, String planta, int disponibilidad) {
        this.tipo = tipo;
        this.numHabitacion = contadorHabitaciones++; 
        this.precio = precio;
        this.planta = planta;
        this.disponibilidad = disponibilidad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    public int getNumHabitacion() {
        return numHabitacion;
    }

    public void setNumHabitacion(int numHabitacion){
        this.numHabitacion = numHabitacion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio){
        this.precio = precio;
    }

    public String getPlanta() {
        return planta;
    }

    public void setPlanta(String planta){
        this.planta = planta;
    }

    public int getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(int disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public abstract void reservarHabitacion();

    public abstract double calcularCostoTotal();

    @Override
    public String toString() {
        return "Tipo: " + tipo + ", Planta: " + planta + ", Precio: $" + precio;
    }
}
