package com.example.app.service;

import com.example.app.entity.Empleado;
import com.example.app.entity.EmpleadoDto;
import com.example.app.exceptions.EmpleadoNotFoundException;
import com.example.app.exceptions.EmptyEmpleadosException;
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
        List<Empleado> lista = repositorio.findAll();
        if (lista.isEmpty()) throw new EmptyEmpleadosException();
        return lista; }
    public Empleado obtenerPorId (long id) {
        return repositorio.findById(id).orElseThrow(() -> new EmpleadoNotFoundException(id));
    }
    public Empleado editar (Empleado empleado){
        return repositorio.save(empleado);
    }
    public void borrar (Long id){
            repositorio.deleteById(id);
    }
    public EmpleadoDto convertEmpleadoToEmpleadoDto(Empleado empleado) {
        EmpleadoDto empleadoDto = new EmpleadoDto();
        empleadoDto.setId(empleado.getId());
        empleadoDto.setEmail(empleado.getEmail());
        return empleadoDto;
    }

    public void editarEmail(EmpleadoDto empleadoDto){
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

