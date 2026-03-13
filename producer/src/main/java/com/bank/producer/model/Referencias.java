package com.bank.producer.model;

import java.util.List;

public class LoteTransacciones {

    private List<Transaccion> transacciones;

    public LoteTransacciones() {
    }

    public LoteTransacciones(List<Transaccion> transacciones) {
        this.transacciones = transacciones;
    }

    public List<Transaccion> getTransacciones() {
        return transacciones;
    }

    public void setTransacciones(List<Transaccion> transacciones) {
        this.transacciones = transacciones;
    }
}