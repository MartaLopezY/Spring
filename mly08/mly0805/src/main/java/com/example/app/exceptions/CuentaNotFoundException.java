package com.example.app.exceptions;

public class CuentaNotFoundException extends RuntimeException {
    public CuentaNotFoundException(String IBAN) {
        super("No se puede encontrar cuenta con IBAN: " + IBAN);
    }
}