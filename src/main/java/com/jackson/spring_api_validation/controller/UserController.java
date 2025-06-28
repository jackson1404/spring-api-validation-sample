package com.jackson.spring_api_validation.controller;

import com.jackson.spring_api_validation.dto.UserRequestDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @PostMapping("/signUp")
    public ResponseEntity<?> signUpUser(@Valid @RequestBody UserRequestDto userRequestDto){

        return new ResponseEntity<>("User sign up successfully" , HttpStatus.OK);

    }

}
