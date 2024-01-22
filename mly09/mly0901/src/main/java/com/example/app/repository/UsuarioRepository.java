package com.example.app.repository;

import com.example.app.entity.Empleado;
import com.example.app.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsuarioRepository  extends JpaRepository<Usuario, Long> {
   Usuario findByNombre(String nombre);

}
