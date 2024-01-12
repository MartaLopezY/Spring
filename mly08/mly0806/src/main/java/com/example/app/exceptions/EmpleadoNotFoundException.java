package com.example.app.exceptions;

public class EmpleadoNotFoundException extends RuntimeException {
    public EmpleadoNotFoundException(Long id) {
        super("No se puede encontrar empleado con ID: " + id);
    }
}