package com.example.app.restcontrollers;


import com.example.app.entity.Usuario;
import com.example.app.services.UsuarioService;
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

@Tag(name = "Usuario", description = "Persona que utiliza la web")
@RestController
@RequestMapping("/api/usuario")
    public class UsuarioApiController {

    @Autowired
    public UsuarioService usuarioService;

    @Operation(summary = "Lista usuarios",
            description = "Devuelve una lista con todos los usuarios.",
            tags = {"get"})

    @ApiResponses({
            @ApiResponse(responseCode = "200",
                    content = {@Content(schema = @Schema(implementation = Usuario.class),
                            mediaType = "application/json") }),
            @ApiResponse(responseCode = "404",
                    content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500",
                    content = { @Content(schema = @Schema()) })
    })

    @GetMapping({ "/", "/list" })
    public List<Usuario> getList() {
        List<Usuario> listaUsuarios = usuarioService.obtenerTodos();
        return listaUsuarios;
    }



    @Operation(summary = "Nuevo usuario",
            description = "Crear un muevo usuario.",
            tags = {"post"})

    @ApiResponses({
            @ApiResponse(responseCode = "201",
                    content = {@Content(schema = @Schema(implementation =Usuario.class),
                            mediaType = "application/json") }),
            @ApiResponse(responseCode = "404",
                    content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500",
                    content = { @Content(schema = @Schema()) })
    })
    @PostMapping("/")
    public ResponseEntity<?> newElement(@Valid @RequestBody Usuario nuevoUsuario) {
        Usuario usuarioAgregado = usuarioService.agregar(nuevoUsuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioAgregado);
    }

    @Operation(summary = "Editar usuario",
            description = "Editar un muevo usuario por su ID.",
            tags = {"put"})

    @ApiResponses({
            @ApiResponse(responseCode = "200",
                    content = {@Content(schema = @Schema(implementation =Usuario.class),
                            mediaType = "application/json") }),
            @ApiResponse(responseCode = "404",
                    content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500",
                    content = { @Content(schema = @Schema()) })
    })
    @PutMapping("/{id}")
    public ResponseEntity<?>  editElement (@PathVariable long id,  @RequestBody Usuario usuario ) {
        Usuario usuarioBusca=usuarioService.obtenerPorId(id);
        if(usuarioBusca==null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        Usuario usuarioEditado=usuarioService.editar(usuario);
        return ResponseEntity.status(HttpStatus.OK).body(usuarioEditado);
    }

    @Operation(summary = "Borrar usuario",
            description = "Borrar un usuario por su ID.",
            tags = {"delete"})

    @ApiResponses({
            @ApiResponse(responseCode = "204",
                    content = {@Content(schema = @Schema(implementation =Usuario.class),
                            mediaType = "application/json") }),
            @ApiResponse(responseCode = "404",
                    content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500",
                    content = { @Content(schema = @Schema()) })
    })

    @DeleteMapping("/{id}")
    public  ResponseEntity<?>  deleteElement(@PathVariable long id){
        Usuario usuarioBusca=usuarioService.obtenerPorId(id);
        if(usuarioBusca==null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        usuarioService.borrar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}



