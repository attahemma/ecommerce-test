package com.capitalshop.ecommerce.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.NoSuchElementException;

@RestControllerAdvice(basePackages = "com.capitalshop.ecommerce")
public class GlobalExceptionHandler {
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<Object> handleNullPointerException(NullPointerException ex) {
        return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Null value encountered", null);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Object> handleNoSuchElementException(NoSuchElementException ex) {
        return ResponseHandler.generateResponse(HttpStatus.NOT_FOUND, "Resource not found", null);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGenericException(Exception ex) {
        return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), null);
    }
}
