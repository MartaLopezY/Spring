package com.example.app.service;

import com.example.app.entity.Departamento;
import com.example.app.repository.DepartamentoRepository;
import com.example.app.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartamentoServiceImpl implements DepartamentoService {
    @Autowired
    DepartamentoRepository departamentoRepositorio;

    public Departamento añadir(Departamento departamento) {
        return departamentoRepositorio.save(departamento);
    }
    public List<Departamento> obtenerTodos() {
        return departamentoRepositorio.findAll();
    }
    public Departamento obtenerPorId(long id) {
        return departamentoRepositorio.findById(id).orElse(null);
    }
    public Departamento editar(Departamento departamento) {
        return departamentoRepositorio.save(departamento);
    }
    public void borrar(Departamento departamento) {departamentoRepositorio.delete(departamento);}
    public Departamento obtenerPorNombre(String nombre) {
        return departamentoRepositorio.findByNombre(nombre);
    }
}

