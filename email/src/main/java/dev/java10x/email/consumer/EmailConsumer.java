package dev.java10x.email.consumer;

import dev.java10x.email.domain.Email;
import dev.java10x.email.dto.EmailRequest;
import dev.java10x.email.mapper.EmailMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailConsumer {


    private final EmailMapper mapper;

    @RabbitListener(queues = "email-queue")
    public void consumeEmail(@Payload EmailRequest request) {
        Email model = mapper.toModel(request);
        System.out.println(mapper.toResponse(model));
    }
}
