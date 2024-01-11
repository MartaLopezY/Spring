package com.example.app.dto;

import com.example.app.entity.Genero;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmpleadoNuevoDto {
    private String nombre;
    private String email;
    private Double salario;
    private boolean enActivo;
    private Genero genero;
    private Long departamentoId;
}