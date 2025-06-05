package org.example.models;

import java.util.Date;

public class Factura {
    private Date fecha;
    private Usuario usuario;
    private Tarifa tarifa;
    private Medicion medicionAnterior;
    private Medicion medicionActual;
    private int consumo;
    private float montoTotal;
}
