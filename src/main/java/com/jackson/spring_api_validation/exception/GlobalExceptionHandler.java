package com.jackson.spring_api_validation.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleApiRequestValidation(MethodArgumentNotValidException exception, HttpServletRequest request){

        List<String> errors = exception.getAllErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .toList();

        Map<String, Object> response = new HashMap<>();
        response.put("timestamp" , LocalDate.now());
        response.put("status" , HttpStatus.BAD_REQUEST.value());
        response.put("path" , request.getRequestURI());
        response.put("errors" , errors);

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);


    }


}
