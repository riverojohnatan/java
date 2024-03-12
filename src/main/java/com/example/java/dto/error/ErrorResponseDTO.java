package com.example.java.dto.error;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@Data
@AllArgsConstructor
@Schema(name = "ErrorResponse", description = "An error response representation")
public class ErrorResponseDTO {

    private static final Logger LOGGER = LoggerFactory.getLogger(ErrorResponseDTO.class);

    @Schema(description = "The error custom message")
    private String message;

    public ResponseEntity<ErrorResponseDTO> toResponseEntity(Exception ex, HttpStatus status) {
        LOGGER.error("Exception captured", ex);
        return ResponseEntity.status(status)
                .contentType(MediaType.APPLICATION_PROBLEM_JSON)
                .body(this);
    }
}
