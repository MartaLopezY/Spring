package com.example.app.service;

import com.example.app.entity.Departamento;

import java.util.List;

public interface DepartamentoService {

    Departamento añadir(Departamento departamento);
    List<Departamento> obtenerTodos();
    Departamento obtenerPorId(long id);
    Departamento editar(Departamento departamento);
    void borrar(Departamento departamento);
    Departamento obtenerPorNombre(String nombre);

}

