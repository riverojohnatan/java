package com.example.java.service.impl;

import com.example.java.config.ErrorProperties;
import com.example.java.config.RegexProperties;
import com.example.java.dto.RegisterUserDTO;
import com.example.java.dto.UserDTO;
import com.example.java.exception.DuplicateUserException;
import com.example.java.exception.WrongDataException;
import com.example.java.model.User;
import com.example.java.repository.UserRepository;
import com.example.java.service.UserService;
import com.example.java.util.UserUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired private UserRepository userRepository;
    @Autowired private UserUtil userUtil;
    @Autowired private ErrorProperties errorProperties;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public UserDTO registerUser(RegisterUserDTO registerUserDTO) {
        LOGGER.info("Register user in User Service");

        validate(registerUserDTO);

        User save = this.userRepository.save(new User(registerUserDTO));
        return translateUserModelToDTO(save);
    }

    private void validate(RegisterUserDTO registerUserDTO) {
        if(!userUtil.validateMail(registerUserDTO.getEmail())) throw new WrongDataException(errorProperties.getEmailFormat());
        if(!userUtil.validatePassword(registerUserDTO.getPassword())) throw new WrongDataException(errorProperties.getPasswordFormat());

        if(this.userRepository.findByEmail(registerUserDTO.getEmail()).isEmpty()) throw new DuplicateUserException(errorProperties.getEmailDuplicate());
    }

    private UserDTO translateUserModelToDTO(User user) {
        LOGGER.info("Translate user: {}", user.toString());
        return UserDTO.builder()
                .id(user.getId())
                .active(user.getActive())
                .created(user.getCreated())
                .lastLogin(user.getLastLogin())
                .modified(user.getModified())
                .token(user.getToken())
                .build();
    }
}
