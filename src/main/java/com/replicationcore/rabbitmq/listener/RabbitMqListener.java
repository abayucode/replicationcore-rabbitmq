package com.replicationcore.rabbitmq.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMqListener {

    @RabbitListener(queues = "apaaja")
    public void listen(String message) {
        System.out.println("Received: " + message);
    } 
}
