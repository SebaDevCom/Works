package HOTEL;

public class HabitacionIndividual extends Habitacion {

    private int ventilador;

    public HabitacionIndividual(String tipo, int numHabitacion, double precio, String planta, int disponibilidad, int ventilador) {
        super(tipo, precio, planta, disponibilidad);
        this.ventilador = ventilador;
    }

    public int getVentilador() {
        return ventilador;
    }

    public void setVentilador(int ventilador) {
        this.ventilador = ventilador;
    }

    @Override
    public void reservarHabitacion() {
        setDisponibilidad(getDisponibilidad() - 1);
    }

    @Override
    public double calcularCostoTotal() {
        return getPrecio();
    }

    public String toString(){
        return super.toString() +". Incluye como extra " + this.getVentilador() + " ventilador.";
    }
}
