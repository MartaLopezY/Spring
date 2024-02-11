package com.example.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
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
    @GeneratedValue
    private Long id;
    @NotNull
    @Column(unique = true)
    private String nombre;
    private LocalDate fechaCreacion;
    private String password;
    private Rol rol;

    public Usuario(String nombre, String password,Rol rol) {
        this.nombre = nombre;
        this.fechaCreacion=LocalDate.now();
        this.password=password;
        this.rol=rol;
    }
}
