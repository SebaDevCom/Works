package Hotel;

class Factura {

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
