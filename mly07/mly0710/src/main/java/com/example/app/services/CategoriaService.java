package com.example.app.services;


import com.example.app.entity.Categoria;
import com.example.app.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface CategoriaService {


    Categoria agregar(Categoria categoria);
    List<Categoria> obtenerTodos();
    Categoria obtenerPorId(long id) throws NotFoundException;
    Categoria editar (Categoria categoria) throws NotFoundException;
    void borrar (Long id) throws NotFoundException;
}
