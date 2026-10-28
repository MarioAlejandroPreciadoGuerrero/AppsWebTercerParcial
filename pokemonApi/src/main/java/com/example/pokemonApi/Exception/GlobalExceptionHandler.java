package com.example.pokemonApi.Exception;

import com.example.pokemonApi.DTO.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorDTO> manejarErrorDeValidacion (MethodArgumentNotValidException ex){

        List<String> detalles = new ArrayList<>();
        for (FieldError error: ex.getBindingResult().getFieldErrors()){
            detalles.add(error.getDefaultMessage());
        }

        ErrorDTO errorDTO = new ErrorDTO(
                "Error en la validacion de datos enviados",
                detalles,
                LocalDateTime.now()
        );

        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }
}
