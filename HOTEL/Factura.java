package HOTEL;

import java.io.Serializable;

class Factura implements Serializable {

    private Cliente cliente;
    private Habitacion habitacion;
<<<<<<< HEAD
    private int diahosp;

    public Factura(Cliente cliente, Habitacion habitacion, String diahosp) {
        this.cliente = cliente;
        this.habitacion = habitacion;
        this.diahosp = diahosp;
=======
    private int dias; 
    private double total; 

    public Factura(Cliente cliente, Habitacion habitacion, int dias) {
        this.cliente = cliente;
        this.habitacion = habitacion;
        this.dias = dias;
        this.total = habitacion.getPrecio() * dias; 
>>>>>>> f02796aba6911657ea7be042e26144684a6697de
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public double getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "Cliente - " + cliente + ", " + habitacion.getTipo() + ", Días: " + dias + ", Total: " + total;
    }
}
