package com.example.app.service;

import com.example.app.entity.Categoria;
import com.example.app.entity.Departamento;
import com.example.app.repository.CategoriaRepository;
import com.example.app.repository.DepartamentoRepository;
import com.example.app.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImpl implements HelperService<Categoria>  {
    @Autowired
    CategoriaRepository categoriaRepositorio;

    public Categoria agregar(Categoria categoria) {
        return categoriaRepositorio.save(categoria);
    }
    public List<Categoria> obtenerTodos() {
        return categoriaRepositorio.findAll();
    }
    public Categoria obtenerPorId(Long id) {
        return categoriaRepositorio.findById(id).orElse(null);
    }
    public Categoria editar(Categoria categoria) {
        return categoriaRepositorio.save(categoria);
    }
    public void borrar(Categoria categoria) {categoriaRepositorio.delete(categoria);}
    public Categoria obtenerPorNombre(String nombre) {
        return categoriaRepositorio.findByNombre(nombre);
    }
}

