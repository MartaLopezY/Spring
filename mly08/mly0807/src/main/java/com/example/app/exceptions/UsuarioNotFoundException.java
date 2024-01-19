package com.example.app.exceptions;

public class UsuarioNotFoundException extends RuntimeException{
    public UsuarioNotFoundException(Long id) {
        super("No se puede encontrar usuario con ID: " + id);
    }

}
