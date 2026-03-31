package dev.java10x.email.consumer;

import dev.java10x.email.Service.EmailService;
import dev.java10x.email.dto.EmailDtoConsumer;
import dev.java10x.email.mapper.EmailMapperConsumer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class EmailConsumer {


    private final EmailMapperConsumer mapper;

    private final EmailService service;

    @RabbitListener(queues = "email-queue")
    public void consumeEmail(@Payload EmailDtoConsumer consumer) {
        log.info("Mensagem recebida da fila: {}", consumer);
        service.sendEmail(mapper.toModel(consumer));
    }

}
