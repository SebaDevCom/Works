package HOTEL;

public class HabitacionSuite extends Habitacion {
    private String bar;

    public HabitacionSuite(String tipo, int numHabitacion, double precio, String planta, int disponibilidad, String bar) {
        super(tipo, precio, planta, disponibilidad);
        this.bar = bar;
    }

    public String getBar() {
        return bar;
    }

    public void setBar(String bar) {
        this.bar = bar;
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
        return super.toString() + ". Incluye acceso a " + this.getBar() + " mini bar.";
    }
}