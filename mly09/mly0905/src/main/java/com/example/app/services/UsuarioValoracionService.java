package com.example.app.services;

import com.example.app.entity.Usuario;
import com.example.app.entity.UsuarioValoracion;
import com.example.app.entity.Valoracion;

import java.util.List;

public interface UsuarioValoracionService {

    UsuarioValoracion obtenerPorId(Long id);

    UsuarioValoracion añadir(UsuarioValoracion usuarioValoracion);

    void borrar(UsuarioValoracion usuarioValoracion);

    List<UsuarioValoracion> obtenerPorUsuario(Usuario usuario);

    List<UsuarioValoracion> obtenerPorValoracion(Valoracion valoracion);

    UsuarioValoracion obtenerPorUsuarioValoracion(Usuario u, Valoracion v);
}