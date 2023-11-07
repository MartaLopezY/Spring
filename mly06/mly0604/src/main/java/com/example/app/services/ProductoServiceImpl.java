package com.example.app.services;


import com.example.app.entity.Producto;
import com.example.app.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ProductoServiceImpl implements ProductoService {
    private List<Producto> repositorio = new ArrayList<>();

    public Producto agregar(Producto producto) {
        repositorio.add(producto);
        return producto;
    }

    public List<Producto> obtenerTodos() {
        return repositorio;
    }

    public Producto obtenerPorId(long id) throws NotFoundException {
        for (Producto producto : repositorio)
            if (producto.getId() == id)
                return producto;
        throw new NotFoundException("Producto no encontrado");
    }

    public Producto editar(Producto producto) throws NotFoundException {
        int pos = repositorio.indexOf(producto);
        if (pos == -1)
            throw new NotFoundException("Producto no encontrado");
        repositorio.set(pos, producto);
        return producto;
    }

    public void borrar(Long id) throws NotFoundException {
        Producto producto = this.obtenerPorId(id);
        if (producto != null) {
            repositorio.remove(producto);
        }
    }
}
