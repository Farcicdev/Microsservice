package dev.java10x.user.controller.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UsersRequest (
        String name,
        @NotBlank
        @Email
        String email
){
}
