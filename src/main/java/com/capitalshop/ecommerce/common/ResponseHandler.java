package com.capitalshop.ecommerce.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {
    public static <T> ResponseEntity<Object> generateResponse(HttpStatus status, String message, T data) {
        Map<String, Object> map = new HashMap<>();
        map.put("status", status.value());
        map.put("message", message);
        map.put("data", data);
        return new ResponseEntity<>(map, status);
    }
}
