package com.company;

public class NotEnoughMoneyException extends Exception {

    private final String massage;
    public NotEnoughMoneyException(String message) {

        this.massage = message;
    }

    public String getMassage() {
        return massage;
    }
}
