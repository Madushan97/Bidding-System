package com.nipuna.bidding.system.controller;

import com.nipuna.bidding.system.exception.ProductNameExistException;
import com.nipuna.bidding.system.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductNameExistException.class)
    public ResponseEntity<StandardResponse<String>> handleUserTypeExistException(ProductNameExistException ex, WebRequest request) {
        StandardResponse<String> response = new StandardResponse<>(
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage(),
                null
        );
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
