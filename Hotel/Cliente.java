package Hotel;

class Cliente {
    private String nombre;
    private String rfc;
    private String direccion;

    public Cliente(String nombre, String rfc, String direccion) {
        this.nombre = nombre;
        this.rfc = rfc;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", RFC: " + rfc + ", Dirección: " + direccion;
    }

    
}
