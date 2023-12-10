package com.example.app.services;


import com.example.app.entity.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface UsuarioService {


    Usuario agregar(Usuario usuario);
    List<Usuario> obtenerTodos();
    Usuario obtenerPorId(Long id);
    Usuario editar (Usuario usuario);
    void borrar (Long id);

}
