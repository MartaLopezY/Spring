package com.example.app.entity;

import com.example.app.config.Tarifas;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@EqualsAndHashCode(of="dni")
public abstract class Paciente {
    private String dni;
    private String nombre;
    private LocalDate fechaNacimiento;
    public abstract Double facturar(Tarifas tarifas);
}
