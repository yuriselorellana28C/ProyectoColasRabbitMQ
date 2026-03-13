package com.bank.producer.model;

public class Detalle {

    private String descripcion;
    private String bancoDestino;

    public Detalle() {
    }

    public Detalle(String descripcion, String bancoDestino) {
        this.descripcion = descripcion;
        this.bancoDestino = bancoDestino;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getBancoDestino() {
        return bancoDestino;
    }

    public void setBancoDestino(String bancoDestino) {
        this.bancoDestino = bancoDestino;
    }
}