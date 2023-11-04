package com.example.app.entity;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Min;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Empleado {


        @NotNull
        @Min(1)
        private Long id;
        @NotEmpty
        private String nombre;
        @Email(message = "Debe tener formato email valido")
        private String email;
        private Double salario;
        private boolean enActivo;
        private Genero genero;

}
