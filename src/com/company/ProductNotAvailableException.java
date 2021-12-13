package com.company;

public class ProductNotAvailableException extends Exception {

    private final String massage;
    public ProductNotAvailableException(String message) {
        this.massage = message;
    }

    public String getMassage() {
        return massage;
    }
}
