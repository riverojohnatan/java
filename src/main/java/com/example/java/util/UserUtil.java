package com.example.java.util;

import com.example.java.config.RegexProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class UserUtil {

    @Autowired
    private RegexProperties regexProperties;

    public boolean validateMail(String email) {
        return Pattern.compile(regexProperties.getEmail())
                .matcher(email)
                .matches();
    }

    public boolean validatePassword(String password) {
        return Pattern.compile(regexProperties.getPassword())
                .matcher(password)
                .matches();
    }
}
