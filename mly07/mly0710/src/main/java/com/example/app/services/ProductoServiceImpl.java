package com.example.app.services;


import com.example.app.entity.Categoria;
import com.example.app.entity.Producto;
import com.example.app.exceptions.NotFoundException;
import com.example.app.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductoServiceImpl implements ProductoService {
    @Autowired
    ProductoRepository productoRepository;

    public Producto agregar(Producto producto) {  return  productoRepository.save(producto); }

    public List<Producto> obtenerTodos() {
        return productoRepository.findAll();
    }

    public Producto obtenerPorId(long id) throws NotFoundException {return productoRepository.findById(id).orElse(null); }

    public Producto editar(Producto producto) throws NotFoundException { return  productoRepository.save(producto);  }

    public void borrar(Long id) throws NotFoundException { productoRepository.deleteById(id);}
    public List<Producto> obtenerPorCategoria(Categoria categoria) { return productoRepository.findByCategoria(categoria);  }
}
