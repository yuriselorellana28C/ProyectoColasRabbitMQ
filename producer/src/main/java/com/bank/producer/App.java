package com.bank.producer;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class App {

    private final static String[] BANCOS = {"BAC", "BANRURAL", "BI", "GYT"};

    public static void main(String[] args) {

        try {
        	
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("localhost");

            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();

            String mensaje = "Nueva transaccion enviada desde Producer";

            for (String banco : BANCOS) {

                // Crear la cola para cada banco
                channel.queueDeclare(banco, false, false, false, null);

                // Enviar mensaje a esa cola
                channel.basicPublish("", banco, null, mensaje.getBytes());

                System.out.println("Mensaje enviado al banco: " + banco);
            }

            channel.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}