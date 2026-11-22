package com.puj.parqueadero.excepciones;

public class VehiculoYaAdentoException extends ParqueaderoException{

    private static final long serialVersionUID = 1L;

    public VehiculoYaAdentoException(String mensaje){
        super(mensaje);
    }
}
