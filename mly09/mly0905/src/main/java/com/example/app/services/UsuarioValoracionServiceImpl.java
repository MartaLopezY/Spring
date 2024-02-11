package com.example.app.services;


import com.example.app.entity.Usuario;
import com.example.app.entity.UsuarioValoracion;
import com.example.app.entity.Valoracion;
import com.example.app.repositories.UsuarioValoracionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioValoracionServiceImpl implements UsuarioValoracionService {
    @Autowired
    UsuarioValoracionRepository usuarioValoracionRepository;

    public UsuarioValoracion obtenerPorId(Long id) {
        return usuarioValoracionRepository.findById(id).orElse(null);
    }
    public UsuarioValoracion añadir(UsuarioValoracion usuarioValoracion) {
        return usuarioValoracionRepository.save(usuarioValoracion);
    }
    public void borrar(UsuarioValoracion usuarioValoracion) {
        usuarioValoracionRepository.delete(usuarioValoracion);
    }
    public List<UsuarioValoracion> obtenerPorUsuario(Usuario usuario) {
        return usuarioValoracionRepository.findByUsuario(usuario);
    }
    public List<UsuarioValoracion> obtenerPorValoracion(Valoracion valoracion) {
        return usuarioValoracionRepository.findByValoracion(valoracion);
    }
    public UsuarioValoracion obtenerPorUsuarioValoracion(Usuario u, Valoracion v) {
        return usuarioValoracionRepository.findByUsuarioAndValoracion(u, v);
    }
}
