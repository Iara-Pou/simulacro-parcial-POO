package org.example.models;

public class UsuarioIndustrial extends Usuario{
    String razonSocial;
    String cuit;
    String IIBB;
    String condicionFiscal;

    public UsuarioIndustrial(String nombre, int DNI, Direccion direccion, String razonSocial, String cuit, String IIBB, String condicionFiscal) {
        super(nombre, DNI, direccion);
        this.razonSocial = razonSocial;
        this.cuit = cuit;
        this.IIBB = IIBB;
        this.condicionFiscal = condicionFiscal;
    }
}
