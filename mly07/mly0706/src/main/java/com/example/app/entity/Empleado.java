package com.example.app.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.ArrayList;
import java.util.List;

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
        @ManyToOne
        @OnDelete(action= OnDeleteAction.CASCADE)
        @JoinColumn(name = "DEPTO_ID", foreignKey = @ForeignKey(name="DEPTO_ID_FK"))
        private Departamento departamento;
        @ToString.Exclude
        @ManyToOne
        @JoinColumn (name="CATEGORIA_ID") //opcional
        private Categoria categoria;


}
