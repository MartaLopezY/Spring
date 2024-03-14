package com.proyecto.servitrade.service;




import com.proyecto.servitrade.entity.Categoria;
import com.proyecto.servitrade.entity.Producto;
import com.proyecto.servitrade.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;


@Service
public class ProductoServiceImpl implements ProductoService {
    @Autowired
    ProductoRepository productoRepository;
    @Autowired
    MonedaService monedaService;
    public Producto agregar(Producto producto) {  return  productoRepository.save(producto); }

    public List<Producto> obtenerTodos() {
        return productoRepository.findAll();
    }

    public Producto obtenerPorId(long id) throws NotFoundException {return productoRepository.findById(id).orElse(null); }

    public Producto editar(Producto producto) throws NotFoundException { return  productoRepository.save(producto);  }

    public void borrar(Long id) throws NotFoundException { productoRepository.deleteById(id);}
    public Long calcularValorServ(Long idServicio) {
        Producto producto = productoRepository.findById(idServicio).orElseThrow(() -> new RuntimeException("Servicio no encontrado"));
        Long valorServicio = monedaService.obtenerValorServicio();
        return valorServicio;
    }
    public List<Producto> obtenerPorCategoria(Categoria categoria) { return productoRepository.findByCategoria(categoria);  }
}
