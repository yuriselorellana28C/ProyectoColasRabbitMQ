package com.bank.producer;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class App {

    private final static String[] BANCOS = {"BAC", "BANRURAL", "BI", "GYT"};

    public static void main(String[] args) {
        try {
            System.out.println("INICIO PRODUCER");

            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("localhost");
            factory.setUsername("guest");
            factory.setPassword("guest");

            System.out.println("ANTES DE CONECTAR");

            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();

            System.out.println("CONECTADO");

            String mensaje = "Nueva transaccion enviada desde Producer";

            for (String banco : BANCOS) {
                System.out.println("Procesando banco: " + banco);

                channel.queueDeclare(banco, false, false, false, null);
                channel.basicPublish("", banco, null, mensaje.getBytes());

                System.out.println("Mensaje enviado al banco: " + banco);
            }

            System.out.println("FIN PRODUCER");
            System.out.println("ESPERA 10 SEGUNDOS PARA TOMAR CAPTURA...");

            Thread.sleep(10000);

            channel.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}