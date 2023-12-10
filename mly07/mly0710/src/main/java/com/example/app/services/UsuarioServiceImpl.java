package com.example.app.services;


import com.example.app.entity.Usuario;
import com.example.app.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UsuarioServiceImpl implements UsuarioService{
    @Autowired
    UsuarioRepository usuarioRepository;

    public Usuario agregar(Usuario usuario){  return  usuarioRepository.save(usuario); }

    public List<Usuario> obtenerTodos() {
        return usuarioRepository.findAll();
    }

    public Usuario obtenerPorId(Long id){return usuarioRepository.findById(id).orElse(null); }

    public Usuario editar (Usuario usuario) { return  usuarioRepository.save(usuario);  }

    public  void borrar (Long id) { usuarioRepository.deleteById(id);}

}
