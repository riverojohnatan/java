package com.example.java.controller.advice;

import com.example.java.dto.error.ErrorResponseDTO;
import com.example.java.exception.DuplicateUserException;
import com.example.java.exception.WrongDataException;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestAdviceController {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ApiResponse(responseCode = "500", content = {
            @Content(mediaType = "application/json",
            schema = @Schema(implementation = ErrorResponseDTO.class))
    })
    public ResponseEntity<ErrorResponseDTO> handleUncaughtException(
            Exception ex, HttpServletRequest request) {
        return new ErrorResponseDTO(ex.getMessage())
                .toResponseEntity(ex, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(DuplicateUserException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ApiResponse(responseCode = "400", description = "User email is already created", content = {
            @Content(mediaType = "application/json",
                    schema = @Schema(implementation = ErrorResponseDTO.class))
    })
    public ResponseEntity<ErrorResponseDTO> handleDuplicateUserException(
            DuplicateUserException ex, HttpServletRequest request) {
        return new ErrorResponseDTO(ex.getMessage())
                .toResponseEntity(ex, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(WrongDataException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ApiResponse(responseCode = "400", description = "A property is wrong", content = {
            @Content(mediaType = "application/json",
                    schema = @Schema(implementation = ErrorResponseDTO.class))
    })
    public ResponseEntity<ErrorResponseDTO> handleWrongDataException(
            WrongDataException ex, HttpServletRequest request) {
        return new ErrorResponseDTO(ex.getMessage())
                .toResponseEntity(ex, HttpStatus.BAD_REQUEST);
    }

}
