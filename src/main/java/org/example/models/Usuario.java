package org.example.models;

public abstract class Usuario {
    private static int idActual;

    private int id;
    private String nombre;
    private int DNI;
    private Direccion direccion;

    public Usuario(String nombre, int DNI, Direccion direccion) {
        this.nombre = nombre;
        this.DNI = DNI;
        this.direccion = direccion;
        this.id = idActual++;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDNI() {
        return DNI;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public int obtenerUltimoConsumo(int anio, int bimestre){
        return 0;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", DNI=" + DNI +
                ", direccion=" + direccion +
                '}';
    }
}
