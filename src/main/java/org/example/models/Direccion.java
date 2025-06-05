package org.example.models;

import java.util.Objects;

public class Direccion {
    private String calle;
    private int altura;
    private int piso;
    private String depto;
    private int codigoPostal;
    private String localidad;
    private String provincia;

    public Direccion(String calle, int altura, int piso, String depto, int codigoPostal, String localidad, String provincia) {
        this.calle = calle;
        this.altura = altura;
        this.piso = piso;
        this.depto = depto;
        this.codigoPostal = codigoPostal;
        this.localidad = localidad;
        this.provincia = provincia;
    }

    public Direccion() {
    }

    @Override
    public String toString() {
        return "Direccion{" +
                "calle='" + calle + '\'' +
                ", altura=" + altura +
                ", piso=" + piso +
                ", depto=" + depto +
                ", codigoPostal=" + codigoPostal +
                ", localidad='" + localidad + '\'' +
                ", provincia='" + provincia + '\'' +
                '}';
    }


    @Override
    public int hashCode() {
        return Objects.hash(calle, altura, piso, depto, codigoPostal, localidad, provincia);
    }

}
