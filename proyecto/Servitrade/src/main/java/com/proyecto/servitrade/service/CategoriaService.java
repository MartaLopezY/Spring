package com.proyecto.servitrade.service;


import com.proyecto.servitrade.entity.Categoria;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;


@Service
public interface CategoriaService {


    Categoria agregar(Categoria categoria);
    List<Categoria> obtenerTodos();
    Categoria obtenerPorId(long id) throws NotFoundException;
    Categoria editar (Categoria categoria) throws NotFoundException;
    void borrar (Long id) throws NotFoundException;
}
