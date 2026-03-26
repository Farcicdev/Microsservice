package dev.java10x.email.consumer;

import dev.java10x.email.domain.Email;
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

    @RabbitListener(queues = "email-queue")
    public void consumeEmail(@Payload EmailDtoConsumer consumer) {
        Email model = mapper.toModel2(consumer);
        System.out.println(model.getEmailTo());
    }
}
