package com.example.app.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity

public class Categoria {
        @Id
        @GeneratedValue
        private Long id;
        @NotEmpty
        private String nombre;
        @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, mappedBy="categoria")
        private List<Empleado> empleados = new ArrayList<>();
}
