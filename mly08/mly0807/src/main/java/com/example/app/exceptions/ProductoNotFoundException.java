package com.example.app.exceptions;

public class ProductoNotFoundException extends RuntimeException{
    public ProductoNotFoundException(Long id) {
        super("No se puede encontrar producto con ID: " + id);
    }

}
