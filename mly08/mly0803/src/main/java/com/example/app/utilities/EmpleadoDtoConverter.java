package com.example.app.utilities;

import com.example.app.dto.EmpleadoNuevoDto;
import com.example.app.entity.Empleado;
import com.example.app.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmpleadoDtoConverter {
    @Autowired
    DepartamentoService departamentoService;
    public Empleado convertDtoToEmpleado(EmpleadoNuevoDto empleadoNuevoDto) {
        return new Empleado(null,
                empleadoNuevoDto.getNombre(),
                empleadoNuevoDto.getEmail(),
                empleadoNuevoDto.getSalario(),
                empleadoNuevoDto.isEnActivo(),
                empleadoNuevoDto.getGenero(),
                departamentoService.obtenerPorId(empleadoNuevoDto.getDepartamentoId()));
    }
    public Empleado convertDtoToEmpleado(EmpleadoNuevoDto empleadoEditDto, Long id) {
        Empleado empleado = convertDtoToEmpleado(empleadoEditDto);
        empleado.setId(id);
        return empleado;
    }
}
