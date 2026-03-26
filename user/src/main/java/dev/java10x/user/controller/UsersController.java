package dev.java10x.user.controller;

import dev.java10x.user.controller.dto.UsersRequest;
import dev.java10x.user.controller.dto.UsersResponse;
import dev.java10x.user.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsersController {

    private final UsersService service;

    @PostMapping
    public ResponseEntity<UsersResponse> save(@RequestBody UsersRequest request) {
        return ResponseEntity.ok(service.save(request));
    }
}
