package Serializable;

import java.io.Serializable;

public class RegistroCuentaSerializable implements Serializable {

    private int cuenta;
    private String primerNombre;

    private String apellidoPaterno;
    private double saldo;

    public RegistroCuentaSerializable() {
        this(0, "", "", 0.0);
    }

    public RegistroCuentaSerializable(
            int cta, String nombre, String apellido, double sal) {
        establecerCuenta(cta);
        establecerPrimerNombre(nombre);
        establecerApellidoPaterno(apellido);
        establecerSaldo(sal);
    }

    public void establecerCuenta(int cta) {
        cuenta = cta;
    }

    public int obtenerCuenta() {
        return cuenta;
    }

    public void establecerPrimerNombre(String nombre) {
        primerNombre = nombre;
    }

    public String obtenerPrimerNombre() {
        return primerNombre;
    }

    public void establecerApellidoPaterno(String apellido) {
        apellidoPaterno = apellido;
    }

    public String obtenerApellidoPaterno() {
        return apellidoPaterno;
    }

    public void establecerSaldo(double sal) {
        saldo = sal;

    }

    public double obtenerSaldo() {
        return saldo;
    }
}
