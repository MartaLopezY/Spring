package com.example.app.repositories;

import com.example.app.entity.Usuario;
import com.example.app.entity.UsuarioValoracion;
import com.example.app.entity.Valoracion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UsuarioValoracionRepository extends
        JpaRepository<UsuarioValoracion, Long> {
// métodos derivado de nombre

    List<UsuarioValoracion> findByUsuario(Usuario usuario);
    List<UsuarioValoracion> findByValoracion(Valoracion valoracion);
    UsuarioValoracion findByUsuarioAndValoracion(Usuario usu, Valoracion val);
}
