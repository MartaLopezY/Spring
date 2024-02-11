package com.example.app.repositories;


import com.example.app.entity.Categoria;
import com.example.app.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProductoRepository extends JpaRepository<Producto, Long> {

List<Producto> findByCategoria(Categoria categoria);
}
