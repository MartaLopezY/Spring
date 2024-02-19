package com.example.empleado;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoServiceImplBD implements EmpleadoService {
    @Autowired
    private EmpleadoRepository repositorio;

    public Empleado añadir(Empleado empleado) {
        if (empleado.getSalario() >= 1000 && empleado.getSalario() < 5000)
            return repositorio.save(empleado);
        return null;
    }

    public List<Empleado> obtenerTodos() {
        List <Empleado> empleadosRepo = repositorio.findAll();
        List <Empleado> empleadosActivos = new ArrayList<>();
        
        for (Empleado empleado : empleadosRepo)
            if (empleado.isEnActivo()) empleadosActivos.add(empleado);
        return empleadosActivos;
    }

    public Empleado obtenerPorId(long id) {
        return repositorio.findById(id).orElse(null);
    }

    public Empleado editar(Empleado empleado) {
        if (empleado.getSalario() >= 0 && empleado.getSalario() < 100000)
            return repositorio.save(empleado);
        else
            return null;
    }

    public boolean borrar(Long id) {
        Empleado empleado = repositorio.findById(id).orElse(null);
        if (empleado == null)
            return false;
        repositorio.delete(empleado);
        return true;
    }

    public List<Empleado> obtenerPorSalarioMayor(double salario) {
        return repositorio.findBySalarioGreaterThanEqualOrderBySalario(salario);
    }

    public List<Empleado> obtenerEmpleadoSalarioMayorMedia() {
        return repositorio.findBySalarioOverAverage();

    }
}
