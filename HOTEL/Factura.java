package HOTEL;

import java.io.Serializable;

class Factura implements Serializable {

    private Cliente cliente;
    private Habitacion habitacion;

    public Factura(Cliente cliente, Habitacion habitacion) {
        this.cliente = cliente;
        this.habitacion = habitacion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    @Override
    public String toString() {
        return "Cliente - " + cliente + ", " + habitacion.getTipo() + ", Total: " + habitacion.getPrecio();
    }
}

