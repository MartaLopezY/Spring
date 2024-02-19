package com.example.app.service;

import com.example.app.entity.Empleado;

import com.example.app.entity.EmpleadoDto;
import com.example.app.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    private List<Empleado> repositorio = new ArrayList<>();
    public Empleado agregar (Empleado empleado) {
        repositorio.add(empleado);
        return empleado; //podría no devolver nada, o boolean, etc.
    }
    public List<Empleado> obtenerTodos() {
        return repositorio;
    }
    public Empleado obtenerPorId(long id) throws NotFoundException {
        for (Empleado empleado : repositorio)
            if (empleado.getId() == id)
                return empleado;
        throw new NotFoundException("Empleado no encontrado");
    }
    public Empleado editar (Empleado empleado) throws NotFoundException {
        int pos = repositorio.indexOf(empleado);
        if (pos == -1)
            throw new NotFoundException("Empleado no encontrado");
        repositorio.set(pos, empleado); //si lo encuentra, lo sustituye
        return empleado;
    }
    public void borrar (Long id) throws NotFoundException{
        Empleado empleado = this.obtenerPorId(id);
        if (empleado != null) {
            repositorio.remove(empleado);
        }
    }
    public EmpleadoDto convertEmpleadoToEmpleadoDto(Empleado empleado) {
        EmpleadoDto empleadoDto = new EmpleadoDto();
        empleadoDto.setId(empleado.getId());
        empleadoDto.setEmail(empleado.getEmail());
        return empleadoDto;
    }

    public void editarEmail(EmpleadoDto empleadoDto) throws NotFoundException {
        Empleado empleado = this.obtenerPorId(empleadoDto.getId());
        empleado.setEmail(empleadoDto.getEmail());
        this.editar(empleado);
    }
}

