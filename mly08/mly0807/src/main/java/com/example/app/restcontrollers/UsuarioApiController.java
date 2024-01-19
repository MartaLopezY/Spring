package com.example.app.restcontrollers;


import com.example.app.entity.Usuario;
import com.example.app.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
    public class UsuarioApiController {

    @Autowired
    public UsuarioService usuarioService;

    @GetMapping({ "/", "/list" })
    public List<Usuario> getList() {
        List<Usuario> listaUsuarios = usuarioService.obtenerTodos();
        return listaUsuarios;
    }
    @PostMapping("/")
    public ResponseEntity<?> newElement(@Valid @RequestBody Usuario nuevoUsuario) {
        Usuario usuarioAgregado = usuarioService.agregar(nuevoUsuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioAgregado);
    }


    @PutMapping("/{id}")
    public ResponseEntity<?>  editElement (@PathVariable long id,  @RequestBody Usuario usuario ) {
        Usuario usuarioBusca=usuarioService.obtenerPorId(id);
        if(usuarioBusca==null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        Usuario usuarioEditado=usuarioService.editar(usuario);
        return ResponseEntity.status(HttpStatus.OK).body(usuarioEditado);
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<?>  deleteElement(@PathVariable long id){
        Usuario usuarioBusca=usuarioService.obtenerPorId(id);
        if(usuarioBusca==null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        usuarioService.borrar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}



