package com.example.app.services;


import com.example.app.entity.Categoria;
import com.example.app.entity.Producto;
import com.example.app.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface ProductoService {


    Producto agregar(Producto producto);
    List<Producto> obtenerTodos();
    Producto obtenerPorId(long id) throws NotFoundException;
    Producto editar (Producto producto) throws NotFoundException;
    void borrar (Long id) throws NotFoundException;
    List<Producto> obtenerPorCategoria(Categoria categoria);
}
