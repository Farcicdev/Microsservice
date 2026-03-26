package dev.java10x.user.service;

import dev.java10x.user.controller.dto.UsersRequest;
import dev.java10x.user.controller.dto.UsersResponse;
import dev.java10x.user.domain.Users;
import dev.java10x.user.event.EmailDtoEvent;
import dev.java10x.user.mapper.EmailEventMapper;
import dev.java10x.user.mapper.UsersMapper;
import dev.java10x.user.producer.UsersProducer;
import dev.java10x.user.repository.UsersRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsersService {

    private final UsersRepository repository;
    private final UsersMapper mapper;
    private final UsersProducer producer;
    private final EmailEventMapper mapperEvent;

    @Transactional
    public UsersResponse save(UsersRequest request){
         Users save = mapper.toModel(request);
         Users saved = repository.save(save);

        EmailDtoEvent emailDto = mapperEvent.toEmailDto(
                saved,
                "Hello " + saved.getName() + "teste",
                "teste"
        );

        producer.criarUsuarioEvent(emailDto);
         
         return mapper.toResponse(saved);
    }


}
