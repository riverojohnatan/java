package com.example.java.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "application.regex")
@Component
@Data
public class RegexProperties {
    private String email;
    private String password;
}
