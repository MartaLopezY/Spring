package com.example.app.restcontrollers;


import com.example.app.entity.Valoracion;
import com.example.app.services.ValoracionService;
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

@Tag(name = "Valoración", description = "Opinión que se realiza por parte de un usuario a un producto")
@RestController
@RequestMapping("/api/valoracion")
    public class ValoracionApiController {

    @Autowired
    public ValoracionService valoracionService;
    @Operation(summary = "Valoraciones de productos",
            description = "Devuelve una lista con las valoraciones de un producto .",
            tags = {"get"})

    @ApiResponses({
            @ApiResponse(responseCode = "200",
                    content = {@Content(schema = @Schema(implementation = Valoracion.class),
                            mediaType = "application/json") }),
            @ApiResponse(responseCode = "404",
                    content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500",
                    content = { @Content(schema = @Schema()) })
    })

    @GetMapping({ "/", "/list" })
    public List<Valoracion>getList() {
        List<Valoracion> listaValoraciones = valoracionService.obtenerTodos();
        return listaValoraciones;
    }

    @Operation(summary = "Nueva valoracion",
            description = "Crear una nueva valoracion.",
            tags = {"post"})

    @ApiResponses({
            @ApiResponse(responseCode = "201",
                    content = {@Content(schema = @Schema(implementation = Valoracion.class),
                            mediaType = "application/json") }),
            @ApiResponse(responseCode = "404",
                    content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500",
                    content = { @Content(schema = @Schema()) })
    })
    @PostMapping("/")
    public ResponseEntity<?> newElement(@Valid @RequestBody Valoracion nuevaValoracion) {
        Valoracion valoracionAgregada=valoracionService.agregar(nuevaValoracion);
        return ResponseEntity.status(HttpStatus.CREATED).body(valoracionAgregada);
    }

    @Operation(summary = "Editar valoracion",
            description = "Editar una valoracion por su ID.",
            tags = {"put"})

    @ApiResponses({
            @ApiResponse(responseCode = "200",
                    content = {@Content(schema = @Schema(implementation = Valoracion.class),
                            mediaType = "application/json") }),
            @ApiResponse(responseCode = "404",
                    content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500",
                    content = { @Content(schema = @Schema()) })
    })

    @PutMapping("/{id}")
    public ResponseEntity<?>  editElement (@PathVariable long id,  @RequestBody Valoracion valoracion ) {
        Valoracion valoracionBusca=valoracionService.obtenerPorId(id);
        if(valoracionBusca==null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        Valoracion valoracionEditado=valoracionService.editar(valoracion);
        return ResponseEntity.status(HttpStatus.OK).body(valoracionEditado);
    }
    @Operation(summary = "Borrar valoracion",
            description = "Borrar una valoracion por su ID.",
            tags = {"delete"})

    @ApiResponses({
            @ApiResponse(responseCode = "204",
                    content = {@Content(schema = @Schema(implementation = Valoracion.class),
                            mediaType = "application/json") }),
            @ApiResponse(responseCode = "404",
                    content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500",
                    content = { @Content(schema = @Schema()) })
    })
    @DeleteMapping("/{id}")
    public  ResponseEntity<?>  deleteElement(@PathVariable long id){
        Valoracion valoracionBusca=valoracionService.obtenerPorId(id);
        if(valoracionBusca==null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        valoracionService.borrar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}



