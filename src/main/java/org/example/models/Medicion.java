package org.example.models;

import java.util.Date;

public class Medicion {
    private Date fechaLectura;
    private int anio;
    private int bimestre;
    private int lectura;

    public int getAnio() {
        return anio;
    }

    public int getBimestre() {
        return bimestre;
    }

    public int getLectura() {
        return lectura;
    }
}
