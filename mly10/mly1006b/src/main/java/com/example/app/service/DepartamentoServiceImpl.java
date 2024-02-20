package com.example.app.service;

import com.example.app.entity.Departamento;
import com.example.app.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class DepartamentoServiceImpl implements DepartamentoService {
    @Autowired
    DepartamentoRepository departamentoRepositorio;

    public Departamento agregar(Departamento departamento) {
        return departamentoRepositorio.save(departamento);
    }

    public List<Departamento> obtenerTodos() {
        return departamentoRepositorio.findAll();
    }

    public Departamento obtenerPorId(Long id) {
        return departamentoRepositorio.findById(id).orElse(null);
    }

    public Departamento editar(Departamento departamento) {
        return departamentoRepositorio.save(departamento);
    }

    public void borrar(Departamento departamento) {
        departamentoRepositorio.delete(departamento);
    }

    public Departamento obtenerPorNombre(String nombre) {
        return departamentoRepositorio.findByNombre(nombre);
    }
}


