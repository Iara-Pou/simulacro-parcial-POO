package org.example.models;

public abstract class Usuario {
    private static int idActual;
    private int id;
    private String nombre;
    private int DNI;
    private String calle;
    private int altura;
    private int piso;
    private String depto;
    private int codigoPostal;
    private String localidad;
    private String provincia;


    public Usuario(String nombre, int DNI, String calle, int altura, int piso, String depto, int codigoPostal, String localidad, String provincia) {
        this.nombre = nombre;
        this.DNI = DNI;
        this.calle = calle;
        this.altura = altura;
        this.piso = piso;
        this.depto = depto;
        this.codigoPostal = codigoPostal;
        this.localidad = localidad;
        this.provincia = provincia;
        this.id = idActual++;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDNI() {
        return DNI;
    }

    public static int getIdActual() {
        return idActual;
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

    public int obtenerUltimoConsumo(int anio, int bimestre){
        return 0;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
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
