package com.example.java.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
@Builder
public class UserDTO {

    @Schema(description = "User Id")
    private UUID id;
    @Schema(description = "Creation date")
    private Date created;
    @Schema(description = "Modification date")
    private Date modified;
    @Schema(description = "Last login date")
    @JsonAlias("last_login")
    private Date lastLogin;
    @Schema(description = "Token")
    private String token;
    @Schema(description = "If user is active")
    @JsonAlias("isactive")
    private Boolean active;
}
