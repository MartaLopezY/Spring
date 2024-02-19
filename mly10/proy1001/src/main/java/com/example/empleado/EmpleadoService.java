package com.example.empleado;

import java.util.List;

public interface EmpleadoService {
    Empleado añadir(Empleado empleado);

    List<Empleado> obtenerTodos();

    Empleado obtenerPorId(long id);

    Empleado editar(Empleado empleado);

    boolean borrar(Long id);

    List<Empleado> obtenerPorSalarioMayor(double salario);

    List<Empleado> obtenerEmpleadoSalarioMayorMedia();
}
