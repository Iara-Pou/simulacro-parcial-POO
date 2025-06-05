package org.example.dtos;

import org.example.models.Direccion;

public class UsuarioResidencialDTO {
    private String nombre;
    private int DNI;
    private Direccion direccion;

    public UsuarioResidencialDTO(String nombre, int DNI, Direccion direccion) {
        this.nombre = nombre;
        this.DNI = DNI;
        this.direccion = direccion;
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

    @Override
    public String toString() {
        return "UsuarioResidencialDTO{" +
                "nombre='" + nombre + '\'' +
                ", DNI=" + DNI +
                ", direccion=" + direccion +
                '}';
    }
}
