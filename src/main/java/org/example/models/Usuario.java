package org.example.models;

import java.util.Objects;

public abstract class Usuario {
    private Medidor medidor;
    private int nroUsuario;
    private String calle;
    private int altura;
    private int piso;
    private String depto;
    private int codigoPostal;
    private String localidad;
    private String provincia;

    public boolean equals(Usuario usuario) {
        return altura == usuario.altura
                && piso == usuario.piso
                && codigoPostal == usuario.codigoPostal
                && Objects.equals(calle, usuario.calle)
                && Objects.equals(depto, usuario.depto)
                && Objects.equals(localidad, usuario.localidad)
                && Objects.equals(provincia, usuario.provincia);
    }
    public Usuario(String calle, int altura, int piso, String depto, int codigoPostal, String localidad, String provincia) {
        this.calle = calle;
        this.altura = altura;
        this.piso = piso;
        this.depto = depto;
        this.codigoPostal = codigoPostal;
        this.localidad = localidad;
        this.provincia = provincia;
    }

    public String getCalle() {
        return calle;
    }

    public int getAltura() {
        return altura;
    }

    public int getPiso() {
        return piso;
    }

    public String getDepto() {
        return depto;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public String getLocalidad() {
        return localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public int getNroUsuario(){
        return nroUsuario;
    }

    public void setNroUsuario(int nroUsuario) {
        this.nroUsuario = nroUsuario;
    }

    public int obtenerUltimoConsumo(int anio, int bimestre) {
        return 0;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + nroUsuario +
                ", calle='" + calle + '\'' +
                ", altura=" + altura +
                ", piso=" + piso +
                ", depto='" + depto + '\'' +
                ", codigoPostal=" + codigoPostal +
                ", localidad='" + localidad + '\'' +
                ", provincia='" + provincia + '\'' +
                '}';
    }
}
