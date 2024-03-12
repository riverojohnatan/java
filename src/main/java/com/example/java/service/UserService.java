package com.example.java.service;

import com.example.java.dto.RegisterUserDTO;
import com.example.java.dto.UserDTO;

public interface UserService {

    UserDTO registerUser(RegisterUserDTO registerUserDTO);
}
