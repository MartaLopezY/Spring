package com.example.app.repository;

import com.example.app.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
  Usuario findByNombre(String nombre);

    Boolean existsByNombre(String nombre);

    Boolean existsByEmail(String email);
}

