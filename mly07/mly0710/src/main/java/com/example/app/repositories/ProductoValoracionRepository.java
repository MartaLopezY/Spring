package com.example.app.repositories;

import com.example.app.entity.Producto;
import com.example.app.entity.ProductoValoracion;
import com.example.app.entity.Valoracion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProductoValoracionRepository extends
        JpaRepository<ProductoValoracion, Long> {
// métodos derivado de nombre

    List<ProductoValoracion> findByProducto(Producto producto);
    List<ProductoValoracion> findByValoracion(Valoracion valoracion);
    ProductoValoracion findByProductoAndValoracion(Producto producto, Valoracion val);
}
