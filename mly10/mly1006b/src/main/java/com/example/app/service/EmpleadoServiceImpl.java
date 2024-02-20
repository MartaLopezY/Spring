package com.example.app.service;

import com.example.app.entity.Departamento;
import com.example.app.entity.Empleado;
import com.example.app.entity.EmpleadoDto;
import com.example.app.exceptions.NotFoundException;
import com.example.app.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmpleadoServiceImpl  implements EmpleadoService {
    @Autowired
    EmpleadoRepository empleadoRepositorio;


    public Empleado agregar (Empleado empleado) {
        return empleadoRepositorio.save(empleado);
    }
    public List<Empleado> obtenerTodos() {
        return empleadoRepositorio.findAll();
    }
    public Empleado obtenerPorId(Long id)  {
        return empleadoRepositorio.findById (id).orElse(null);
    }
    public Empleado editar (Empleado empleado)  {
        return empleadoRepositorio.save(empleado);
    }


    public void borrar(Empleado empleado) {
        empleadoRepositorio.delete(empleado);
    }

    public void borrar (Long id) throws NotFoundException{
            empleadoRepositorio.deleteById(id);
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
        return empleadoRepositorio.obtenerMaxIdEmpleado().getNombre();
    }
    public List<Empleado> obtenerEmpleadosSalarioMayor (double salario){
        return empleadoRepositorio.findBySalarioGreaterThanEqualOrderBySalario(salario);
    }
    public List<Empleado> obtenerEmpleadoSalarioMayorMedia() {
        return empleadoRepositorio.obtenerEmpleadoSalarioMayorMedia();
    }
    public List<Empleado> obtenerPorDepto(Departamento departamento){
     return empleadoRepositorio.findByDepartamento(departamento);
    }
}

