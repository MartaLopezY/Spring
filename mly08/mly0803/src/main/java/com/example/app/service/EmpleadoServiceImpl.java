package com.example.app.service;

import com.example.app.entity.Empleado;
import com.example.app.entity.EmpleadoDto;
import com.example.app.exceptions.NotFoundException;
import com.example.app.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {
    @Autowired
    EmpleadoRepository repositorio;


    public Empleado agregar (Empleado empleado) {
        return repositorio.save(empleado);
    }
    public List<Empleado> obtenerTodos() {
        return repositorio.findAll();
    }
    public Empleado obtenerPorId(long id) throws NotFoundException {
        return repositorio.findById (id).orElse(null);
    }
    public Empleado editar (Empleado empleado) throws NotFoundException {
        return repositorio.save(empleado);
    }
    public void borrar (Long id) throws NotFoundException{
            repositorio.deleteById(id);
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
    public String obtenerEmpleadoMax(){
        return repositorio.obtenerMaxIdEmpleado().getNombre();
    }
    public List<Empleado> obtenerEmpleadosSalarioMayor (double salario){
        return repositorio.findBySalarioGreaterThanEqualOrderBySalario(salario);
    }
    public List<Empleado> obtenerEmpleadoSalarioMayorMedia() {
        return repositorio.obtenerEmpleadoSalarioMayorMedia();
    }
}

