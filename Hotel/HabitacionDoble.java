package Works.Hotel;

public class HabitacionDoble extends Habitacion {

    private int tv;

    public HabitacionDoble(String tipo, int numHabitacion, double precio, String planta, int disponibilidad, int tv) {
        super(tipo, numHabitacion, precio, planta, disponibilidad);
        this.tv = tv;
    }

    public int getTv() {
        return tv;
    }

    public void setTv(int tv) {
        this.tv = tv;
    }

    @Override
    public void reservarHabitacion() {
        setDisponibilidad(getDisponibilidad() - 1);
    }

    @Override
    public double calcularCostoTotal() {
        return getPrecio();
    }
}
