package dev.java10x.email.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

import java.util.UUID;

@Builder
public record EmailDtoConsumer(
        UUID userId,
        @NotBlank
        @Email
        String emailTo,
        String emailSubject,
        String body
) {

}
