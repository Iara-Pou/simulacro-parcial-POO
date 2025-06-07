package org.example.models;

public class UsuarioIndustrial extends Usuario{
    String razonSocial;
    String cuit;
    String IIBB;
    String condicionFiscal;

    public UsuarioIndustrial(String nombre, int DNI, String calle, int altura, int piso, String depto, int codigoPostal, String localidad, String provincia, String razonSocial, String cuit, String IIBB, String condicionFiscal) {
        super(nombre, DNI, calle, altura, piso, depto, codigoPostal, localidad, provincia);
        this.razonSocial = razonSocial;
        this.cuit = cuit;
        this.IIBB = IIBB;
        this.condicionFiscal = condicionFiscal;
    }
}
