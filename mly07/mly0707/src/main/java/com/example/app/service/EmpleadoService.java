package com.example.app.service;

import com.example.app.entity.Empleado;

import java.util.List;

public interface EmpleadoService {


    public List<Empleado> getEmpleadosPaginados(Integer pageNum);
    public int getTotalPaginas();

}

