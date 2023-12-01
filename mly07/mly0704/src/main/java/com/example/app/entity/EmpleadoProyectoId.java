package com.example.app.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@EqualsAndHashCode
public class EmpleadoProyectoId implements Serializable {
    private Long empleado;
    private Long proyecto;
}
