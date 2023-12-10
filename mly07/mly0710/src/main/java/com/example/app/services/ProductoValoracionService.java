package com.example.app.services;

import com.example.app.entity.Producto;
import com.example.app.entity.ProductoValoracion;
import com.example.app.entity.Valoracion;

import java.util.List;

public interface ProductoValoracionService {

    ProductoValoracion obtenerPorId(Long id);

    ProductoValoracion añadir(ProductoValoracion empleadoProyecto);

    void borrar(ProductoValoracion empleadoProyecto);

    List<ProductoValoracion> obtenerPorProducto(Producto producto);

    List<ProductoValoracion> obtenerPorValoracion(Valoracion valoracion);

    ProductoValoracion obtenerPorProductoValoracion(Producto p, Valoracion v);
}