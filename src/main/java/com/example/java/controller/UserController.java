package com.example.java.controller;

import com.example.java.dto.RegisterUserDTO;
import com.example.java.dto.UserDTO;
import com.example.java.service.UserService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("userController")
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @PostMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UserDTO> registerUser(@RequestBody @Valid RegisterUserDTO registerUserDTO) {
        LOGGER.info("Register user init: {}", registerUserDTO.toString());
        return new ResponseEntity<>(this.userService.registerUser(registerUserDTO), HttpStatusCode.valueOf(201));
    }

}
