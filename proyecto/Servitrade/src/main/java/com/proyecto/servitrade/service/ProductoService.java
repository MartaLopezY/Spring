package com.proyecto.servitrade.service;

import com.proyecto.servitrade.entity.Categoria;
import com.proyecto.servitrade.entity.Producto;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;
import java.util.List;


@Service
public interface ProductoService {


    Producto agregar(Producto producto);
    List<Producto> obtenerTodos();
    Producto obtenerPorId(long id) throws ChangeSetPersister.NotFoundException;
    Producto editar (Producto producto) throws NotFoundException;
    void borrar (Long id) throws NotFoundException;
    List<Producto> obtenerPorCategoria(Categoria categoria);
    Long calcularValorServ(Long idServicio);
}
