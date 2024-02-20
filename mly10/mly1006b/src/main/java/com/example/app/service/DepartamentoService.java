package com.example.app.service;

import com.example.app.entity.Departamento;

import java.util.List;

public interface DepartamentoService {

    Departamento agregar(Departamento departamento);
    List<Departamento> obtenerTodos();
    Departamento obtenerPorId(Long id);
    Departamento editar(Departamento departamento);
    void borrar(Departamento departamento);
    Departamento obtenerPorNombre(String nombre);

}

