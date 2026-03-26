package dev.java10x.user.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ConfigExeption {

    @ExceptionHandler(NotFoundExeption.class)
    public ResponseEntity<String> notFoundExeptionHandler(NotFoundExeption exeption){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(exeption.getMessage());
    }

}
