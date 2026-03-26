package dev.java10x.user.controller;

import dev.java10x.user.controller.dto.UsersRequest;
import dev.java10x.user.controller.dto.UsersResponse;
import dev.java10x.user.domain.Users;
import dev.java10x.user.mapper.UsersMapper;
import dev.java10x.user.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsersController {

    private final UsersService service;
    private final UsersMapper mapper;

    @PostMapping
    public ResponseEntity<UsersResponse> save(@RequestBody UsersRequest request) {
        return ResponseEntity.ok(service.save(request));
    }

    @GetMapping
    public ResponseEntity<List<UsersResponse>> findAll(){
        List<Users> listAll = service.findAll();
        return ResponseEntity.ok(listAll
                        .stream()
                        .map(users -> mapper.toResponse(users)).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsersResponse> findById(@PathVariable("id") UUID uuid){
        Users byId = service.findById(uuid);
        return ResponseEntity.ok(mapper.toResponse(byId));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id){
        service.delete(id);
    }
}
