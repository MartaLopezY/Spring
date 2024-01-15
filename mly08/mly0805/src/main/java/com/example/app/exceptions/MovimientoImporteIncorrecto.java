package com.example.app.exceptions;

public class MovimientoImporteIncorrecto extends RuntimeException {
    public MovimientoImporteIncorrecto() {
        super("El importe a introducir es incorrecto");
    }
}