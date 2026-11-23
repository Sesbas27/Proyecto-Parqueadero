package com.puj.parqueadero.modelo;

public class Carro extends Vehiculo{

    private static final long TARIFA_MINUTO = 120;

    public Carro(String placa) {
        super(placa);
    }

    @Override
    public String getTipo() {
        return "Carro";
    }

    @Override
    public boolean placaValida() {
        return false;
    }

    @Override
    public long calcularTarifa(long minutos) {
        return minutos * TARIFA_MINUTO;
    }
}
