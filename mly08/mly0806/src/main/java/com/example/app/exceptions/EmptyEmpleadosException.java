package com.example.app.exceptions;

public class EmptyEmpleadosException extends RuntimeException {
    public EmptyEmpleadosException() {
        super("No hay empleados en el sistema");
    }
}