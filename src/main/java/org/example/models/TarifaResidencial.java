package org.example.models;

public class TarifaResidencial extends Tarifa{
    private float contribucionesMunicipales;
    @Override
    public float calcularTarifa(int consumo) {
        return 0;
    }
}
