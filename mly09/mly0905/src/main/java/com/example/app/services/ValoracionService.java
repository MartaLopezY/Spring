package com.example.app.services;


import com.example.app.entity.Valoracion;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface ValoracionService {


    Valoracion agregar(Valoracion valoracion);
    List<Valoracion> obtenerTodos();
    Valoracion obtenerPorId(Long id);
    Valoracion editar (Valoracion valoracion);
    void borrar (Long id);
}
