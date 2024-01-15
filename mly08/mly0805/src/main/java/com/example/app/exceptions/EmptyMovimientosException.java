package com.example.app.exceptions;

public class EmptyMovimientosException extends RuntimeException {
    public EmptyMovimientosException() {
        super("No hay movimientos en el sistema");
    }
}