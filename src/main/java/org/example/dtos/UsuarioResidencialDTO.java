package org.example.dtos;

public class UsuarioResidencialDTO {
    private String nombre;
    private int DNI;
    private String calle;
    private int altura;
    private int piso;
    private String depto;
    private int codigoPostal;
    private String localidad;
    private String provincia;


    public UsuarioResidencialDTO(String nombre, int DNI, String calle, int altura, int piso, String depto, int codigoPostal, String localidad, String provincia) {
        this.nombre = nombre;
        this.DNI = DNI;
        this.calle = calle;
        this.altura = altura;
        this.piso = piso;
        this.depto = depto;
        this.codigoPostal = codigoPostal;
        this.localidad = localidad;
        this.provincia = provincia;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDNI() {
        return DNI;
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

    @Override
    public String toString() {
        return "UsuarioResidencialDTO{" +
                "nombre='" + nombre + '\'' +
                ", DNI=" + DNI +
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
