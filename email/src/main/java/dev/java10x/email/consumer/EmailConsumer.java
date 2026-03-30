package dev.java10x.email.consumer;

import dev.java10x.email.Service.EmailService;
import dev.java10x.email.dto.EmailDtoConsumer;
import dev.java10x.email.mapper.EmailMapperConsumer;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailConsumer {


    private final EmailMapperConsumer mapper;

    private final EmailService service;

    @RabbitListener(queues = "email-queue")
    public void consumeEmail(@Payload EmailDtoConsumer consumer) {
        try{
        System.out.println("Mensagem recebida da fila: " + consumer);
        service.sendEmail(mapper.toModel(consumer));
    }catch (Exception e){
            System.out.println("Erro ao processar a mensagem: " + e.getMessage());
        }
    }
}
