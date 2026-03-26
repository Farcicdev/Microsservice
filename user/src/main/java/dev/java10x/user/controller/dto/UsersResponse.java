package dev.java10x.user.controller.dto;

import lombok.Builder;

import java.util.UUID;
@Builder
public record UsersResponse (
        UUID id,
        String name,
        String email
){
}
