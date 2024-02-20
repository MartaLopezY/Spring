package com.example.app.service;


import com.example.app.entity.Proyecto;

import com.example.app.repository.ProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProyectoServiceImpl implements ProyectoService {
    @Autowired
    ProyectoRepository proyectoRepositorio;

    public Proyecto agregar(Proyecto proyecto) {
        return proyectoRepositorio.save(proyecto);
    }

    public List<Proyecto> obtenerTodos() {
        return proyectoRepositorio.findAll();
    }

    public Proyecto obtenerPorId(Long id) {
        return proyectoRepositorio.findById(id).orElse(null);
    }

    public Proyecto editar(Proyecto proyecto) {
        return proyectoRepositorio.save(proyecto);
    }

    public void borrar(Proyecto proyecto) {
        proyectoRepositorio.delete(proyecto);
    }
    public Proyecto obtenerPorNombre(String nombre) {
        return proyectoRepositorio.findByNombre(nombre);
    }
}


