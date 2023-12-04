package com.example.app.service;

import com.example.app.entity.Departamento;
import com.example.app.entity.Empleado;

import com.example.app.entity.EmpleadoDTO;
import com.example.app.entity.EmpleadoEmailDto;
import com.example.app.exceptions.NotFoundException;

import java.util.List;

public interface EmpleadoService {

    Empleado agregar (Empleado empleado);
    List<Empleado> obtenerTodos() ;
    Empleado obtenerPorId(long id) throws NotFoundException;
    Empleado editar (Empleado empleado) throws NotFoundException;
    void borrar (Long id) throws NotFoundException;
    EmpleadoEmailDto convertEmpleadoToEmpleadoDto(Empleado empleado);
    void editarEmail(EmpleadoEmailDto empleadoEmailDto) throws NotFoundException;
    String obtenerEmpleadoMax();
    List<Empleado> obtenerEmpleadosSalarioMayor (double salario);
    List<Empleado> obtenerEmpleadoSalarioMayorMedia();
    List<Empleado> obtenerPorDepto(Departamento departamento);
    List<EmpleadoDTO> convertEmpleadoToDto(List<Empleado> listaEmpleados);

}

