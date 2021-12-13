package com.company;

public class InvalidClientTypeException extends RuntimeException {

    private String message;
    public InvalidClientTypeException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
