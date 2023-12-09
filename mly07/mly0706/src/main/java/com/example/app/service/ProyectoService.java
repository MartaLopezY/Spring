package com.example.app.service;


import com.example.app.entity.Proyecto;

import java.util.List;

public interface ProyectoService {

    Proyecto agregar(Proyecto proyecto);
    List<Proyecto> obtenerTodos();
    Proyecto obtenerPorId(Long id);
    Proyecto editar(Proyecto proyecto);
    void borrar(Proyecto proyecto);
    Proyecto obtenerPorNombre(String nombre);

}

