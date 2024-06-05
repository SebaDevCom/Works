package HOTEL;

import java.io.Serializable;

 class Factura implements Serializable {

    private Cliente cliente;
    private Habitacion habitacion;
    private int diahosp;

    public Factura(Cliente cliente, Habitacion habitacion, String diahosp) {
        this.cliente = cliente;
        this.habitacion = habitacion;
        this.diahosp = diahosp;
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

    @Override
    public String toString() {
        return "Cliente - " + cliente + ", " + habitacion.getTipo() + ", Total: " + habitacion.getPrecio();
    }
}
