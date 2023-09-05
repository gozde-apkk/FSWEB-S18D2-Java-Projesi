package com.workintech.restapi.FruitsVegetablesApplication.exceptions;


import jakarta.persistence.Column;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class FruitExceptionHandler {


    @ExceptionHandler
    public ResponseEntity<FruitErrorResponse> handleException(FruitException fruitException){

        FruitErrorResponse response = new FruitErrorResponse(fruitException.getHttpStatus().value(),
                fruitException.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<>(response, fruitException.getHttpStatus());
    }


    //GLOBAL ERROR HANDLE
    @ExceptionHandler
    public ResponseEntity<FruitErrorResponse> handleException(Exception exception){

        FruitErrorResponse response = new FruitErrorResponse(HttpStatus.BAD_REQUEST.value(),
                exception.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity handleBindErrors(MethodArgumentNotValidException exception){
        List errorList = exception.getBindingResult().getFieldErrors().stream().
                map(fieldError -> {
                    Map<String, String > errors = new HashMap<>();
                    errors.put(fieldError.getField(),fieldError.getDefaultMessage());
                    return errors;
                }).collect(Collectors.toList());
        return ResponseEntity.badRequest().body(errorList);
    }
}
