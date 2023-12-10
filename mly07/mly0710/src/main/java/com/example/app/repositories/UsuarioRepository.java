package com.example.app.repositories;

import com.example.app.entity.Usuario;
import com.example.app.entity.Valoracion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    List<Usuario> findByValoracion(Valoracion valoracion);
}
