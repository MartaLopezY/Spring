package com.example.app.service;

import com.example.app.entity.Empleado;

import com.example.app.entity.EmpleadoDto;
import com.example.app.exceptions.NotFoundException;

import java.util.List;

public interface EmpleadoService {

    Empleado agregar (Empleado empleado);
    List<Empleado> obtenerTodos() ;
    Empleado obtenerPorId(long id) throws NotFoundException;
    Empleado editar (Empleado empleado) throws NotFoundException;
    void borrar (Long id) throws NotFoundException;
    EmpleadoDto convertEmpleadoToEmpleadoDto(Empleado empleado);
    void editarEmail(EmpleadoDto empleadoDto) throws NotFoundException;
    String obtenerEmpleadoMax();
    List<Empleado> obtenerEmpleadosSalarioMayor (double salario);
    List<Empleado> obtenerEmpleadoSalarioMayorMedia();

}

