package com.proyecto.servitrade.service;

import com.proyecto.servitrade.entity.Usuario;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

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
