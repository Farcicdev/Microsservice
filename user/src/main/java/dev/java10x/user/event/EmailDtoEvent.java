package dev.java10x.user.event;

import lombok.Builder;

import java.util.UUID;

@Builder
public record EmailDtoEvent(
        UUID userId,
        String emailTo,
        String emailSubject,
        String body
){
}
