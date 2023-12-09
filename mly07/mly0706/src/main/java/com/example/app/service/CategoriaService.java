package com.example.app.service;

import com.example.app.entity.Categoria;


import java.util.List;

public interface CategoriaService {

  Categoria agregar(Categoria categoria);
  List<Categoria> obtenerTodos();
  Categoria obtenerPorId(Long id) ;
  Categoria editar(Categoria categoria);
  void borrar(Categoria categoria);
  Categoria obtenerPorNombre(String nombre);

}

