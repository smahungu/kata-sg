package com.smahungu.kata.sg.exception;

public class BadWithdrawalAmountException extends RuntimeException {

    private final String message;

    public BadWithdrawalAmountException(String message) {
        this.message = message;
    }
}
