package com.example.app.entity;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Producto {


    @NotNull
    @Min(1)
    private Long id;
    @NotNull
    private String nombre;
    private Boolean enOferta;
    private TipoIva tipoIva;
    private Double precio;
}
