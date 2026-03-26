package dev.java10x.email.dto;

import java.util.UUID;

public record EmailRequest (
        UUID userId,
        String emailTo,
        String emailSubject,
        String body
){
}
