package com.example.app.entity;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    @NotNull
    private String nombre;
    @Email
    private String email;

    private String comentarios;
    @AssertTrue
    private Boolean aceptaCondiciones;

    private String tipo;


}
