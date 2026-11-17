package com.puj.parqueadero.modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Tiquete implements Serializable {

    private static final long serialVersionUID= 1L;

    private final int numero;
    private final LocalDateTime entrada;
    private LocalDateTime salida;
    private long ValorParqueo;
    private long ValorRecarga;

    private final Vehiculo vehiculo;
    private Convenio convenio;


    public Tiquete(Vehiculo vehiculo, int numero, LocalDateTime entrada) {
        this.vehiculo = vehiculo;
        this.numero = numero;
        this.entrada = entrada;

        this.salida = null;
        this.convenio = null;
        this.ValorParqueo = 0;
        this.ValorRecarga = 0;
    }

    public boolean estaAbierto(){
        return this.salida == null;
    }

    public long getMinutos(){
        if( this.salida == null){
            return 0;
        }
        return ChronoUnit.MINUTES.between(this.entrada,this.salida);
    }

    public void cerrar( LocalDateTime salida,Convenio convenio,boolean mensualidad){
        this.salida= salida;
        this.convenio= convenio;

        long minutos = this.getMinutos();
        long cobrables = Math.max(0, minutos - convenio.getMinutosGratis());

        if(mensualidad){
            this.ValorParqueo = 0;
        } else {
            this.ValorParqueo = this.vehiculo.calcularTarifa(cobrables);
        }

        this.ValorRecarga = this.vehiculo.cargoAdicional(minutos);

    }

    public long getTotal(){
        return this.ValorParqueo + this.ValorRecarga;
    }

    public int getNumero() {
        return numero;
    }

    public LocalDateTime getEntrada() {
        return entrada;
    }

    public LocalDateTime getSalida() {
        return salida;
    }

    public void setSalida(LocalDateTime salida) {
        this.salida = salida;
    }

    public long getValorParqueo() {
        return ValorParqueo;
    }

    public void setValorParqueo(long valorParqueo) {
        ValorParqueo = valorParqueo;
    }

    public long getValorRecarga() {
        return ValorRecarga;
    }

    public void setValorRecarga(long valorRecarga) {
        ValorRecarga = valorRecarga;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public Convenio getConvenio() {
        return convenio;
    }

    public void setConvenio(Convenio convenio) {
        this.convenio = convenio;
    }

    @Override
    public String toString() {

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        String texto = "Tiquete " + this.numero
                + " | " + this.vehiculo.getTipo() + " " + this.vehiculo.getPlaca()
                + " | Entrada: " + this.entrada.format(formato);

        if (this.estaAbierto()) {
            return texto + " | ABIERTO";
        }
        return texto + " | Salida: " + this.salida.format(formato)
                + " | Minutos: " + this.getMinutos()
                + " | Parqueo: " + this.valorParqueo
                + " | Recarga: " + this.valorRecarga
                + " | Total: " + this.getTotal();
    }
}
