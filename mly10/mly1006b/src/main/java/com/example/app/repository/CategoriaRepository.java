package com.example.app.repository;

import com.example.app.entity.Categoria;
import com.example.app.entity.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    Categoria findByNombre(String nombre);

}
