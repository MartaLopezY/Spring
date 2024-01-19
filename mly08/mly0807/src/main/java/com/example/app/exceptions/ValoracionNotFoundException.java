package com.example.app.exceptions;

public class ValoracionNotFoundException extends RuntimeException{
    public ValoracionNotFoundException(Long id) {
        super("No se puede encontrar valoración con ID: " + id);
    }

}
