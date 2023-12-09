package com.example.app.service;

import com.example.app.entity.Empleado;
import com.example.app.entity.EmpleadoProyecto;
import com.example.app.entity.Proyecto;

import java.util.List;

public interface EmpleadoProyectoService {

    EmpleadoProyecto obtenerPorId(Long id);

    EmpleadoProyecto añadir(EmpleadoProyecto empleadoProyecto);

    void borrar(EmpleadoProyecto empleadoProyecto);

    List<EmpleadoProyecto> obtenerPorEmpleado(Empleado empleado);

    List<EmpleadoProyecto> obtenerPorProyecto(Proyecto proyecto);

    EmpleadoProyecto obtenerPorEmpleadoProyecto(Empleado e, Proyecto p);
}