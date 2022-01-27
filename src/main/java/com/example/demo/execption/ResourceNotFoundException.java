package com.example.demo.execption;

public class ResourceNotFoundException extends RuntimeException {

    String errorCode;
    String[] placeHolder;

    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(Throwable cause) {
        super(cause);
    }

    public ResourceNotFoundException(String errorCode, String... placeHolder) {
        this.errorCode = errorCode;
        this.placeHolder = placeHolder;
    }
}
