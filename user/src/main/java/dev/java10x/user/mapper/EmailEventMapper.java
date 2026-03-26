package dev.java10x.user.mapper;

import dev.java10x.user.event.EmailDtoEvent;
import dev.java10x.user.domain.Users;
import org.springframework.stereotype.Component;

@Component
public class EmailEventMapper {

    public EmailDtoEvent toEmailDto(Users users,String subject,String body){
        return EmailDtoEvent.builder()
                .userId(users.getId())
                .emailTo(users.getEmail())
                .emailSubject(subject)
                .body(body)
                .build();
    }

}
