package com.proyecto.servitrade.repository;

import com.proyecto.servitrade.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository  extends JpaRepository<Categoria, Long> {
}
