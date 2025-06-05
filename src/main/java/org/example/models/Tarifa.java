package org.example.models;

public abstract class Tarifa {
    private float valorKwh;
    private float iva;
    public abstract float calcularTarifa(int consumo);
}
