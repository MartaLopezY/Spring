package com.example.app.services;


import com.example.app.entity.Categoria;
import com.example.app.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CategoriaServiceImpl implements CategoriaService {
    private List<Categoria> repositorio = new ArrayList<>();

    public Categoria agregar(Categoria categoria) {
        repositorio.add(categoria);
        return categoria;
    }

    public List<Categoria> obtenerTodos() {
        return repositorio;
    }

    public Categoria obtenerPorId(long id) throws NotFoundException {
        for (Categoria categoria : repositorio)
            if (categoria.getId() == id)
                return categoria;
        throw new NotFoundException("Categoria no encontrado");
    }

    public Categoria editar(Categoria categoria) throws NotFoundException {
        int pos = repositorio.indexOf(categoria);
        if (pos == -1)
            throw new NotFoundException("Categoria no encontrado");
        repositorio.set(pos, categoria);
        return categoria;
    }

    public void borrar(Long id) throws NotFoundException {
        Categoria categoria = this.obtenerPorId(id);
        if (categoria != null) {
            repositorio.remove(categoria);
        }
    }
}
