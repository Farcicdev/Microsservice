package dev.java10x.email.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    @RabbitListener
    public void consumeEmail(@Payload String emailMessage){
        System.out.println(emailMessage);
    }

}
