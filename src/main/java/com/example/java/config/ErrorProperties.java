package com.example.java.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "application.error")
@Component
@Data
public class ErrorProperties {
    private String emailFormat;
    private String emailDuplicate;
    private String passwordFormat;
}
