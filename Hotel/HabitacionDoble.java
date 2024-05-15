package HOTEL;

public class HabitacionDoble extends Habitacion {

    private int tv;

    public HabitacionDoble(String tipo, int numHabitacion, double precio, String planta, int disponibilidad, int tv) {
        super(tipo, precio, planta, disponibilidad);
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

    public String toString(){
        return super.toString() + ". Incluye como extra " + this.getTv() + " televiciones.";
    }
}
