package com.example.app.exceptions;

public class EmptyCuentasException extends RuntimeException {
    public EmptyCuentasException() {
        super("No hay cuentas en el sistema");
    }
}