package com.principleglobal.vendingmachine.exception;

public class NotSufficientCoinageException extends RuntimeException {

    public NotSufficientCoinageException(String message) {
        super(message);
    }
}
