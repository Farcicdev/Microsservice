package dev.java10x.user.producer;

import dev.java10x.user.event.EmailDtoEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsersProducer {

    private final RabbitTemplate template;
    private final String routingKey = "email-queue";

    public void criarUsuarioEvent(EmailDtoEvent emailDto) {

        template.convertAndSend(
                "",
                routingKey,
                emailDto
        );

    }

}
