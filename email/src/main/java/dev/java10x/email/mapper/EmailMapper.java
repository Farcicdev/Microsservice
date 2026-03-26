package dev.java10x.email.mapper;

import dev.java10x.email.domain.Email;
import dev.java10x.email.dto.EmailRequest;
import dev.java10x.email.dto.EmailResponse;
import org.springframework.stereotype.Component;

@Component
public class EmailMapper {

    public Email toModel(EmailRequest request){
        return Email.builder()
                .userId(request.userId())
                .emailTo(request.emailTo())
                .emailSubject(request.emailSubject())
                .Body(request.body())
                .build();
    }


    public EmailResponse toResponse(Email entity){
        return EmailResponse.builder()
                .userId(entity.getUserId())
                .emailTo(entity.getEmailTo())
                .emailSubject(entity.getEmailSubject())
                .body(entity.getBody())
                .build();
    }

}
