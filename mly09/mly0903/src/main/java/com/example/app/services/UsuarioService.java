package com.example.app.services;


import com.example.app.entity.Usuario;
import com.example.app.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface UsuarioService {


    Usuario agregar(Usuario usuario);
    List<Usuario> obtenerTodos();
    Usuario obtenerPorNombre(String nombre) throws NotFoundException;
    public Usuario obtenerPorId(Long id);
    Usuario editar (Usuario usuario);
    void borrar (Long id);

}
