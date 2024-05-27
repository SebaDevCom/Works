package RegistroDeAlumnos;
import java.io.Serializable;

public class StudentsRegistration implements Serializable {
    private int numcontrol;
    private String nombre;
    private String apellidos;
    private String semestre;
    private int calificacion;
    private double promedio;

    public StudentsRegistration(int numcontrol,String nombre, String apellidos, String semestre, int calificacion, double promedio){
        this.numcontrol = numcontrol;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.semestre = semestre;
        this.calificacion = calificacion;
        this.promedio = promedio;
    }

    public void setNumControl(int numcontrol){
        this.numcontrol = numcontrol;
    }

    public int getNumControl(){
        return numcontrol;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return nombre;
    }

    public void setApellidos (String apellidos){
        this.apellidos = apellidos;
    }

    public String getApellidos(){
        return apellidos;
    }

    public void setSemestre(String semestre){
        this.semestre = semestre;
    }

    public String getSemestre(){
        return semestre;
    }

    public void setCalificacion (int calificacion){
        this.calificacion = calificacion;
    }

    public int getCalificacion(){
        return calificacion;
    }

    public void setPromedio(double promedio){
        this.promedio = promedio;
    }

    public double getPromedio(){
        return promedio;
    }

}