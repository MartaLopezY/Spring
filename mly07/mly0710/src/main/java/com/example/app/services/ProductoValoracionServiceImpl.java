package com.example.app.services;

import com.example.app.entity.Producto;
import com.example.app.entity.ProductoValoracion;
import com.example.app.entity.Valoracion;
import com.example.app.repositories.ProductoValoracionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoValoracionServiceImpl implements ProductoValoracionService {
    @Autowired
    ProductoValoracionRepository productoValoracionRepository;

    public ProductoValoracion obtenerPorId(Long id) {
        return productoValoracionRepository.findById(id).orElse(null);
    }
    public ProductoValoracion añadir(ProductoValoracion productoValoracion) {
        return productoValoracionRepository.save(productoValoracion);
    }
    public void borrar(ProductoValoracion productoValoracion) {
        productoValoracionRepository.delete(productoValoracion);
    }
    public List<ProductoValoracion> obtenerPorProducto(Producto producto) {
        return productoValoracionRepository.findByProducto(producto);
    }
    public List<ProductoValoracion> obtenerPorValoracion(Valoracion valoracion) {
        return productoValoracionRepository.findByValoracion(valoracion);
    }
    public ProductoValoracion obtenerPorProductoValoracion(Producto p, Valoracion v) {
        return productoValoracionRepository.findByProductoAndValoracion(p, v);
    }
}
