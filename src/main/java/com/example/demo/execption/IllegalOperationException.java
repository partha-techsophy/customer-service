package com.example.demo.execption;

public class IllegalOperationException extends RuntimeException {

    String errorCode;
    String[] placeHolder;

    public IllegalOperationException(String message) {
        super(message);
    }

    public IllegalOperationException(Throwable cause) {
        super(cause);
    }

    public IllegalOperationException(String errorCode, String... placeHolder) {
        this.errorCode = errorCode;
        this.placeHolder = placeHolder;
    }
}
