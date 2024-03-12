package com.example.java.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RegisterUserDTO {

    @Schema(description = "User name", example = "Juan Rodriguez")
    private String name;
    @Schema(description = "User email", example = "juan@rodriguez.org")
    private String email;
    @Schema(description = "User password", example = "hunter2")
    private String password;
    @Schema(description = "User phones")
    private List<PhoneDTO> phones;
}
