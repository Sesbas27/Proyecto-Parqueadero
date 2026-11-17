package com.puj.parqueadero.modelo;

public class CarroElectrico extends Carro implements Recargable{

    public CarroElectrico(String placa) {
        super(placa);
    }

    @Override
    public String getTipo() {
        return "Carro_Electrico";
    }

    @Override
    public long calcularTarifa(long minutos) {
        return minutos * 120 * 90 / 100;
    }

    @Override
    public long cargoAdicional(long minutos) {
        return costoRecarga(minutos);
    }


    public long costoRecarga(long minutos){
        return minutos * COSTO_MINUTO;
    }


}
