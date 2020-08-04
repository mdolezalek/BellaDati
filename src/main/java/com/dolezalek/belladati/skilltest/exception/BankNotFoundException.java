package com.dolezalek.belladati.skilltest.exception;

public class BankNotFoundException extends RuntimeException {

    public BankNotFoundException(Long id) {
        super("Could not find employee " + id);
    }
}
