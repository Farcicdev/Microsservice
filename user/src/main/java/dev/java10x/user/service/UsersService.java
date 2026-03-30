package dev.java10x.user.service;

import dev.java10x.user.controller.dto.UsersRequest;
import dev.java10x.user.controller.dto.UsersResponse;
import dev.java10x.user.domain.Users;
import dev.java10x.user.event.EmailDtoEvent;
import dev.java10x.user.exeption.NotFoundExeption;
import dev.java10x.user.mapper.EmailEventMapper;
import dev.java10x.user.mapper.UsersMapper;
import dev.java10x.user.producer.UsersProducer;
import dev.java10x.user.repository.UsersRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UsersService {

    private final UsersRepository repository;
    private final UsersMapper mapper;
    private final UsersProducer producer;
    private final EmailEventMapper mapperEvent;

    @Transactional
    public UsersResponse save(UsersRequest request) {
        Users save = mapper.toModel(request);
        Users saved = repository.save(save);

        EmailDtoEvent emailDto = mapperEvent.toEmailDto(
                saved,
                "oii " + saved.getName() + ", seja bem vindo ao nosso sistema",
                "ta funcionandoo"
        );

        producer.criarUsuarioEvent(emailDto);

        return mapper.toResponse(saved);
    }

    public List<Users> findAll(){
        return repository.findAll();
    }

    public void delete(UUID uuid) {
        Optional<Users> byId = repository.findById(uuid);
        if (byId.isPresent()) {
            repository.deleteById(uuid);
        }
        byId.orElseThrow(
                () -> new NotFoundExeption("User not found")
        );
    }

    public Users findById(UUID uuid){
        return repository.findById(uuid).orElseThrow(
                () -> new NotFoundExeption("User not found")
        );
    }




}
