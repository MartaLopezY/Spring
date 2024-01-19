package com.example.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
public class Usuario {
    @Id
    private Long id;
    @NotNull
    private String nombre;

    private LocalDate fechaCreacion;

    public Usuario(Long id,String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.fechaCreacion=LocalDate.now();
    }
}
