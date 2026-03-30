package dev.java10x.email.dto;

import lombok.Builder;

@Builder
public record EmailRequest (
        String emailTo,
        String emailFrom,
        String emailSubject,
        String body
){
}
