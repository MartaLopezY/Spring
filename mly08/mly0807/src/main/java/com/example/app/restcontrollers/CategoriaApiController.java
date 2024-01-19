package com.example.app.restcontrollers;


import com.example.app.entity.Categoria;
import com.example.app.exceptions.NotFoundException;
import com.example.app.services.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping({"/api/categoria"})
@RestController
public class CategoriaApiController {

    @Autowired
    public CategoriaService categoriaService;



    @GetMapping({ "/", "/list" })
    public List<Categoria> getList() {
        List<Categoria> listaCategorias = categoriaService.obtenerTodos();
        return listaCategorias;
    }
    @PostMapping("/")
    public ResponseEntity<?> newElement(@Valid @RequestBody Categoria nuevaCategoria) {
        Categoria categoriaAgregada = categoriaService.agregar(nuevaCategoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaAgregada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?>  editElement (@PathVariable long id,  @RequestBody Categoria categoria ) throws NotFoundException {
        Categoria categoriaBusca=categoriaService.obtenerPorId(id);
        if(categoriaBusca==null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        Categoria categoriaEditada = categoriaService.editar(categoria);
        return ResponseEntity.status(HttpStatus.OK).body(categoriaEditada);
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<?>  deleteElement(@PathVariable long id) throws NotFoundException {
        Categoria categoriaBusca=categoriaService.obtenerPorId(id);
        if(categoriaBusca==null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        categoriaService.borrar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}


