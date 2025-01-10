package com.smahungu.kata.sg.exception;

public class NoPositiveAmountException extends RuntimeException {

    private final String message;

    public NoPositiveAmountException(String message) {
        this.message = message;
    }
}
