package Tienda;

public class RegistroDeProductos {
    private int numproc;
    private String nom;
    private String tipo;
    private double precio;

    public RegistroDeProductos(){
        this(0, "", "", 0.0);
    }

    public RegistroDeProductos(int numproc, String nom, String tipo, double precio){
        this.numproc = numproc;
        this.nom = nom;
        this.tipo = tipo;
        this.precio = precio;
    }

    public void SetNumoproc(int numproc){
        this.numproc = numproc;
    }

    public int getNumproc(){
        return numproc;
    }

    public void SetNom(String nom){
        this.nom = nom;
    }

    public String getNom(){
        return nom;
    }

    public void SetTipo(String tipo){
        this.tipo = tipo;
    }

    public String getTipo(){
        return tipo;
    }

    public void SetPrecio(double precio){
        this.precio = precio;
    }

    public double getPrecio(){
        return precio;
    }

}
