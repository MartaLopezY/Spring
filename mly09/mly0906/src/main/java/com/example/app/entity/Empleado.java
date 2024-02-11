package com.example.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
public class Empleado {

        @Id
        @GeneratedValue
        private Long id;
        @NotEmpty
        private String nombre;
        @Email(message = "Debe tener formato email valido")
        private String email;
        private Double salario;
        private boolean enActivo;

        private Genero genero;


}
