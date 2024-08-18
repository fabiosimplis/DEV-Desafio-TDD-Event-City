package com.devsuperior.demo.controller.handlers;

import com.devsuperior.demo.services.exception.DatabaseException;
import com.devsuperior.demo.services.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler extends  RuntimeException{

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> resourceNotFound(ResourceNotFoundException e){
        HttpStatus status = HttpStatus.NOT_FOUND;
        return ResponseEntity.status(status).body(e.getMessage());
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<String> database(DatabaseException e){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        System.out.println("HELP data base - " + e);
        return ResponseEntity.status(status).body(e.getMessage());
    }
}
