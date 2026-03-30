package dev.java10x.email.mapper;

import dev.java10x.email.domain.Email;
import dev.java10x.email.dto.EmailDtoConsumer;
import org.springframework.stereotype.Component;

@Component
public class EmailMapperConsumer {

        public Email toModel(EmailDtoConsumer consumer){
                return Email.builder()
                        .userId(consumer.userId())
                        .emailTo(consumer.emailTo())
                        .emailSubject(consumer.emailSubject())
                        .Body(consumer.body())
                        .build();
        }
}
