package com.example.app.entity;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Producto {


    @id
    private Long id;
    @NotNull
    private String nombre;
    private Boolean enOferta;
    private TipoIva tipoIva;
    private Double precio;
}
