package com.example.demo.execption;

public class InvalidInputException extends RuntimeException {
    String errorCode;
    String[] placeHolder;

    public InvalidInputException(String message) {
        super(message);
    }

    public InvalidInputException(Throwable cause) {
        super(cause);
    }

    public InvalidInputException(String errorCode, String... placeHolder) {
        this.errorCode = errorCode;
        this.placeHolder = placeHolder;
    }
}
