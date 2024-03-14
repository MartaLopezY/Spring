package com.proyecto.servitrade.repository;

import com.proyecto.servitrade.entity.Categoria;
import com.proyecto.servitrade.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

    List<Producto> findByCategoria(Categoria categoria);
}
