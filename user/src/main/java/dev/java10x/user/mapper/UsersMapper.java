package dev.java10x.user.mapper;

import dev.java10x.user.controller.dto.UsersRequest;
import dev.java10x.user.controller.dto.UsersResponse;
import dev.java10x.user.domain.Users;
import org.springframework.stereotype.Component;

@Component
public class UsersMapper {

    public Users toModel(UsersRequest request){
        return Users.builder()
                .name(request.name())
                .email(request.email())
                .build();
    }

    public UsersResponse toResponse(Users entity){
        return UsersResponse.builder()
                .id(entity.getUserId())
                .name(entity.getName())
                .email(entity.getEmail())
                .build();

    }

}
