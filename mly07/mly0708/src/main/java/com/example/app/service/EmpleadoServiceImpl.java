package com.example.app.service;

import com.example.app.entity.Departamento;
import com.example.app.entity.Empleado;
import com.example.app.entity.EmpleadoDTO;
import com.example.app.entity.EmpleadoEmailDto;
import com.example.app.exceptions.NotFoundException;
import com.example.app.repository.EmpleadoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {
    @Autowired
    EmpleadoRepository empleadoRepositorio;
    @Autowired
    public ModelMapper modelMapper;

    public Empleado agregar (Empleado empleado) {
        return empleadoRepositorio.save(empleado);
    }
    public List<Empleado> obtenerTodos() {
        return empleadoRepositorio.findAll();
    }
    public Empleado obtenerPorId(long id) throws NotFoundException {
        return empleadoRepositorio.findById (id).orElse(null);
    }
    public Empleado editar (Empleado empleado) throws NotFoundException {
        return empleadoRepositorio.save(empleado);
    }
    public void borrar (Long id) throws NotFoundException{
            empleadoRepositorio.deleteById(id);
    }
    public EmpleadoEmailDto convertEmpleadoToEmpleadoDto(Empleado empleado) {
        EmpleadoEmailDto empleadoEmailDto = new EmpleadoEmailDto();
        empleadoEmailDto.setId(empleado.getId());
        empleadoEmailDto.setEmail(empleado.getEmail());
        return empleadoEmailDto;
    }

    public void editarEmail(EmpleadoEmailDto empleadoEmailDto) throws NotFoundException {
        Empleado empleado = this.obtenerPorId(empleadoEmailDto.getId());
        empleado.setEmail(empleadoEmailDto.getEmail());
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


    public List<EmpleadoDTO> convertEmpleadoToDto(List<Empleado> listaEmpleados) {

        List<EmpleadoDTO> listaEmpleadoDTO = new ArrayList<>();
        for (Empleado empleado : listaEmpleados)
            listaEmpleadoDTO.add(modelMapper.map(empleado, EmpleadoDTO.class));
        return listaEmpleadoDTO;
    }
}

