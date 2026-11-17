package com.puj.parqueadero.modelo;

public abstract class Vehiculo {

    private String placa;

    public String getPlaca() {
        return placa;
    }

    public Vehiculo(String placa){
        this.placa = placa;
    }

    public abstract String getTipo();

    public abstract boolean placaValida();

    public abstract long calcularTarifa(long minutos);

    public long cargoAdicional(long minutos){
        return 0;
    }


}
