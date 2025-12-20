package com.example.demo.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException() {
        super("Not Found");
    }

    public ResourceNotFoundException(String message) {
        super(message != null ? message : "Not Found");
    }
}
