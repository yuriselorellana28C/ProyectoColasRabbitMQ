/*
Proyecto: RabbitMQ Consumer
Nombre: Dayly Yurisel Orellana Orellana
Carnet: 0905-2422-303
Correo: dorellanao4@miumg.edu.gt
*/

import com.rabbitmq.client.*;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;

public class Consumer {

    private static final String COLA_TRANSACCIONES = "transacciones";
    private static final String COLA_DUPLICADOS = "duplicados";

    // Aquí guardamos los IDs ya procesados
    private static final Set<String> transaccionesProcesadas = new HashSet<>();

    public static void main(String[] args) throws Exception {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        // Declarar colas
        channel.queueDeclare(COLA_TRANSACCIONES, false, false, false, null);
        channel.queueDeclare(COLA_DUPLICADOS, false, false, false, null);

        System.out.println("Esperando transacciones...");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {

            String mensaje = new String(delivery.getBody(), StandardCharsets.UTF_8);

            // Aquí asumimos que el mensaje ES el id de la transacción
            String idTransaccion = mensaje;

            if (transaccionesProcesadas.contains(idTransaccion)) {
                // Si ya existe, es duplicada
                channel.basicPublish("", COLA_DUPLICADOS, null, mensaje.getBytes(StandardCharsets.UTF_8));

                System.out.println("ID Transaccion: " + idTransaccion);
                System.out.println("Estado: DUPLICADA");
                System.out.println("Cola destino: " + COLA_DUPLICADOS);
                System.out.println("---------------------------");

            } else {
                // Si no existe, se procesa normal
                transaccionesProcesadas.add(idTransaccion);

                // Aquí iría el POST si ya lo tienes implementado
                // enviarPOST(idTransaccion);

                System.out.println("ID Transaccion: " + idTransaccion);
                System.out.println("Estado: PROCESADA");
                System.out.println("Cola destino: " + COLA_TRANSACCIONES);
                System.out.println("---------------------------");
            }
        };

        channel.basicConsume(COLA_TRANSACCIONES, true, deliverCallback, consumerTag -> { });
    }
}