package com.example.app.repository;

import com.example.app.entity.Empleado;
import com.example.app.entity.EmpleadoProyecto;
import com.example.app.entity.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface EmpleadoProyectoRepository extends
        JpaRepository<EmpleadoProyecto, Long> {
// métodos derivado de nombre

    List<EmpleadoProyecto> findByEmpleado(Empleado empleado);
    List<EmpleadoProyecto> findByProyecto(Proyecto proyecto);
    EmpleadoProyecto findByEmpleadoAndProyecto(Empleado emp, Proyecto proy);
}
