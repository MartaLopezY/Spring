package com.example.app.restcontrollers;


import com.example.app.entity.Producto;
import com.example.app.exceptions.NotFoundException;
import com.example.app.services.ProductoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping({"/api/producto"})
@RestController
public class ProductoApiController {

    @Autowired
    public ProductoService productoService;


    @GetMapping({ "/", "/list" })
    public List<Producto> getList() {
        List<Producto> listaProductos = productoService.obtenerTodos();
        return listaProductos;
    }
    @PostMapping("/")
    public ResponseEntity<?> newElement(@Valid @RequestBody Producto nuevoProducto) {
        Producto productoAgregado = productoService.agregar(nuevoProducto);
        return ResponseEntity.status(HttpStatus.CREATED).body(productoAgregado);
    }


    @PutMapping("/{id}")
    public ResponseEntity<?>  editElement (@PathVariable long id,  @RequestBody Producto producto ) throws NotFoundException {
        Producto productoBusca=productoService.obtenerPorId(id);
        if(productoBusca==null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        Producto productoEditado=productoService.editar(producto);
        return ResponseEntity.status(HttpStatus.OK).body(productoEditado);
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<?>  deleteElement(@PathVariable long id) throws NotFoundException {
        Producto productoBusca=productoService.obtenerPorId(id);
        if(productoBusca==null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        productoService.borrar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }




}


