package com.example.app.service;

import com.example.app.entity.Empleado;

import com.example.app.entity.EmpleadoDto;

import java.util.List;

public interface EmpleadoService {

    Empleado agregar (Empleado empleado);
    List<Empleado> obtenerTodos() ;
    Empleado obtenerPorId(long id);
    Empleado editar (Empleado empleado);
    void borrar (Long id);
    EmpleadoDto convertEmpleadoToEmpleadoDto(Empleado empleado);
    void editarEmail(EmpleadoDto empleadoDto);
    String obtenerEmpleadoMax();
    List<Empleado> obtenerEmpleadosSalarioMayor (double salario);
    List<Empleado> obtenerEmpleadoSalarioMayorMedia();

}

