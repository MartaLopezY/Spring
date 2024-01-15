package com.example.app.exceptions;

public class CuentaConSaldo extends RuntimeException {
    public CuentaConSaldo(String IBAN) {
        super("La cuenta a borrar no tiene saldo cero," + IBAN);
    }
}