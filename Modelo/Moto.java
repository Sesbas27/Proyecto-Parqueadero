package com.puj.parqueadero.modelo;

public class Moto extends Vehiculo{

    private static final long TARIFA_MINUTO = 80;

    public Moto(String placa) {
        super(placa);
    }
    @Deprecated
    public String getTipo(){
        return "Moto";
    }
    @Override
    public boolean placaValida(){
        return false;
    }
    @Override
    public long calcularTarifa(long minutos){
        return minutos * TARIFA_MINUTO;
    }


}
