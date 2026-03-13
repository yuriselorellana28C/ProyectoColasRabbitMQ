package com.bank.consumer;

public class Estudiante {

    private String nombre;
    private String carne;
    private String correo;

    public Estudiante(String nombre, String carne, String correo) {
        this.nombre = nombre;
        this.carne = carne;
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCarne() {
        return carne;
    }

    public String getCorreo() {
        return correo;
    }
}
