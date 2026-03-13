Este proyecto implementa un sistema de mensajería utilizando RabbitMQ en Java.

El sistema está compuesto por dos aplicaciones:

Producer: encargado de enviar mensajes.
Consumer: encargado de recibir mensajes.

Se simula el envío de transacciones a diferentes bancos utilizando colas.

## Bancos simulados

BAC  
BANRURAL  
BI  
GYT  

Cada banco tiene su propia cola en RabbitMQ.

 Funcionamiento

1. El Producer envía mensajes a RabbitMQ.
2. Se crean colas para cada banco.
3. El Consumer escucha las colas.
4. Cuando llega un mensaje, se muestra en la consola.

Clase adicional

Se creó la clase *Estudiante* que contiene:

Nombre  
Carné  
Correo  

Estos datos se muestran en consola al ejecutar el programa.

Tecnologías utilizadas

Java  
RabbitMQ  
RabbitMQ Java Client (amqp-client)  
Maven  
Eclipse IDE