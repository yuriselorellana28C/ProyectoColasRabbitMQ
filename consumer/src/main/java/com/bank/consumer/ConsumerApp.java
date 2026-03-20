/*
Proyecto: RabbitMQ Consumer
Nombre: Dayly Yurisel Orellana Orellana
Carnet: 0905-2422-303
Correo: dorellanao4@miumg.edu.gt
*/

package com.bank.consumer;

import com.rabbitmq.client.*;

public class ConsumerApp {

    private final static String[] BANCOS = {"BAC", "BANRURAL", "BI", "GYT"};

    public static void main(String[] args) throws Exception {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setUsername("guest");
        factory.setPassword("guest");

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        for (String banco : BANCOS) {

            channel.queueDeclare(banco, false, false, false, null);

            System.out.println("Esperando mensajes del banco: " + banco);

            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String mensaje = new String(delivery.getBody(), "UTF-8");
                System.out.println("Mensaje recibido de " + banco + ": " + mensaje);
            };

            channel.basicConsume(banco, true, deliverCallback, consumerTag -> { });
        }
    }
}