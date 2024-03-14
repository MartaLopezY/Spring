package com.proyecto.servitrade.repository;

import com.proyecto.servitrade.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository  extends JpaRepository<Usuario, Long> {
    Usuario findByUsername(String username);

}
