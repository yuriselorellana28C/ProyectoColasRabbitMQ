package com.bank.consumer;

public class App {

    public static void main(String[] args) {

        Estudiante est = new Estudiante(
                "Dayly Yurisel Orellana Orellana",
                "0905-2422-303",
                "dorellanao4@miumg.edu.gt"
        );

        System.out.println("Nombre: " + est.getNombre());
        System.out.println("Carne: " + est.getCarne());
        System.out.println("Correo: " + est.getCorreo());

    }
}
