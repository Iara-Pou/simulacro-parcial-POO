package org.example.models;

public class UsuarioResidencial extends Usuario{
    private String nombre;
    private int DNI;
    public UsuarioResidencial(String nombre, int DNI, String calle, int altura, int piso, String depto, int codigoPostal, String localidad, String provincia) {
        super(calle, altura, piso, depto, codigoPostal, localidad, provincia);
        this.nombre = nombre;
        this.DNI = DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDNI() {
        return DNI;
    }
}
