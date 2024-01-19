package com.example.app.restcontrollers;


import com.example.app.entity.Producto;
import com.example.app.exceptions.NotFoundException;
import com.example.app.services.ProductoService;
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
@Tag(name = "Producto", description = "Elemento que se vende")
@RequestMapping({"/api/producto"})
@RestController
public class ProductoApiController {

    @Autowired
    public ProductoService productoService;


    @Operation(summary = "Lista productos",
            description = "Devuelve una lista con todos los productos.",
            tags = {"get"})
    @ApiResponses({
            @ApiResponse(responseCode = "200",
                    content = {@Content(schema = @Schema(implementation = Producto.class),
                            mediaType = "application/json") }),
            @ApiResponse(responseCode = "404",
                    content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500",
                    content = { @Content(schema = @Schema()) })
    })

    @GetMapping({ "/", "/list" })
    public List<Producto> getList() {
        List<Producto> listaProductos = productoService.obtenerTodos();
        return listaProductos;
    }
    @Operation(summary = "Nuevo producto",
            description = "Crear un producto nuevo.",
            tags = {"post"})

    @ApiResponses({
            @ApiResponse(responseCode = "201",
                    content = {@Content(schema = @Schema(implementation = Producto.class),
                            mediaType = "application/json") }),
            @ApiResponse(responseCode = "404",
                    content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500",
                    content = { @Content(schema = @Schema()) })
    })

    @PostMapping("/")
    public ResponseEntity<?> newElement(@Valid @RequestBody Producto nuevoProducto) {
        Producto productoAgregado = productoService.agregar(nuevoProducto);
        return ResponseEntity.status(HttpStatus.CREATED).body(productoAgregado);
    }

    @Operation(summary = "Editar por ID",
            description = "Editar un producto por su ID.",
            tags = {"get"})

    @ApiResponses({
            @ApiResponse(responseCode = "200",
                    content = {@Content(schema = @Schema(implementation = Producto.class),
                            mediaType = "application/json") }),
            @ApiResponse(responseCode = "404",
                    content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500",
                    content = { @Content(schema = @Schema()) })
    })

    @PutMapping("/{id}")
    public ResponseEntity<?>  editElement (@PathVariable long id,  @RequestBody Producto producto ) throws NotFoundException {
        Producto productoBusca=productoService.obtenerPorId(id);
        if(productoBusca==null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        Producto productoEditado=productoService.editar(producto);
        return ResponseEntity.status(HttpStatus.OK).body(productoEditado);
    }
    @Operation(summary = "Borrar producto",
            description = "Borrar un producto por su ID.",
            tags = {"delete"})

    @ApiResponses({
            @ApiResponse(responseCode = "204",
                    content = {@Content(schema = @Schema(implementation = Producto.class),
                            mediaType = "application/json") }),
            @ApiResponse(responseCode = "404",
                    content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500",
                    content = { @Content(schema = @Schema()) })
    })

    @DeleteMapping("/{id}")
    public  ResponseEntity<?>  deleteElement(@PathVariable long id) throws NotFoundException {
        Producto productoBusca=productoService.obtenerPorId(id);
        if(productoBusca==null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        productoService.borrar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }




}


