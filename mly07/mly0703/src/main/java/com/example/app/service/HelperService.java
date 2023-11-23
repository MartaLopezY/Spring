package com.example.app.service;
import java.util.List;

public interface HelperService <E>{
    List<E> obtenerTodos ();
    E agregar (E entity);
    E obtenerPorId (Long id);
    E editar (E entity);
    void borrar (E entity);
}




