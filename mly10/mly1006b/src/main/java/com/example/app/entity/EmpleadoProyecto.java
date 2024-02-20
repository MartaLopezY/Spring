package com.example.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
public class EmpleadoProyecto {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "empleado_id")
    @OnDelete(action= OnDeleteAction.CASCADE)
    private Empleado empleado;
    @ManyToOne
    @JoinColumn(name = "proyecto_id")
    @OnDelete(action=OnDeleteAction.CASCADE)
    private Proyecto proyecto;
    private String puesto;
}
