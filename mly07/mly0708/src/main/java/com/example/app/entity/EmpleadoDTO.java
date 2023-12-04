package com.example.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor


public class EmpleadoDTO {
        private Long id;
        private String nombre;
        private String departamentoNombre;
}

