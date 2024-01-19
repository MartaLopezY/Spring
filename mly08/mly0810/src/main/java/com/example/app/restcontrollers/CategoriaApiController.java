package com.example.app.restcontrollers;


import com.example.app.entity.Categoria;
import com.example.app.exceptions.NotFoundException;
import com.example.app.services.CategoriaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name = "Categoria", description = "Agrupa a todos los productos con una caracteristica común")
@RequestMapping({"/api/categoria"})
@RestController
public class CategoriaApiController {

    @Autowired
    public CategoriaService categoriaService;

    @Operation(summary = "Lista categorias",
            description = "Devuelve una lista con todas las categorias.",
            tags = {"get"})

    @ApiResponses({
            @ApiResponse(responseCode = "200",
                    content = {@Content(schema = @Schema(implementation = Categoria.class),
                            mediaType = "application/json") }),
            @ApiResponse(responseCode = "404",
                    content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500",
                    content = { @Content(schema = @Schema()) })
    })

    @GetMapping({ "/", "/list" })
    public List<Categoria> getList() {
        List<Categoria> listaCategorias = categoriaService.obtenerTodos();
        return listaCategorias;
    }

    @Operation(summary = "Nueva categoria",
            description = "Crear una nueva categoria.",
            tags = {"post"})


    @ApiResponses({
            @ApiResponse(responseCode = "201",
                    content = {@Content(schema = @Schema(implementation = Categoria.class),
                            mediaType = "application/json") }),
            @ApiResponse(responseCode = "404",
                    content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500",
                    content = { @Content(schema = @Schema()) })
    })

    @PostMapping("/")
    public ResponseEntity<?> newElement(@Valid @RequestBody Categoria nuevaCategoria) {
        Categoria categoriaAgregada = categoriaService.agregar(nuevaCategoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaAgregada);
    }
    @Operation(summary = "Editar una categoria",
            description = "Editar una categoria por su ID.",
            tags = {"put"})


    @ApiResponses({
            @ApiResponse(responseCode = "200",
                    content = {@Content(schema = @Schema(implementation = Categoria.class),
                            mediaType = "application/json") }),
            @ApiResponse(responseCode = "404",
                    content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500",
                    content = { @Content(schema = @Schema()) })
    })
    @PutMapping("/{id}")
    public ResponseEntity<?>  editElement (@PathVariable long id,  @RequestBody Categoria categoria ) throws NotFoundException {
        Categoria categoriaBusca=categoriaService.obtenerPorId(id);
        if(categoriaBusca==null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        Categoria categoriaEditada = categoriaService.editar(categoria);
        return ResponseEntity.status(HttpStatus.OK).body(categoriaEditada);
    }
    @Operation(summary = "Borrar una categoria",
            description = "Borrar una categoria por su ID.",
            tags = {"delete"})


    @ApiResponses({
            @ApiResponse(responseCode = "204",
                    content = {@Content(schema = @Schema(implementation = Categoria.class),
                            mediaType = "application/json") }),
            @ApiResponse(responseCode = "404",
                    content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500",
                    content = { @Content(schema = @Schema()) })
    })

    @DeleteMapping("/{id}")
    public  ResponseEntity<?>  deleteElement(@PathVariable long id) throws NotFoundException {
        Categoria categoriaBusca=categoriaService.obtenerPorId(id);
        if(categoriaBusca==null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        categoriaService.borrar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}


