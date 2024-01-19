package com.example.app.restcontrollers;


import com.example.app.entity.Valoracion;
import com.example.app.services.ValoracionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/valoracion")
    public class ValoracionApiController {

    @Autowired
    public ValoracionService valoracionService;

    @GetMapping({ "/", "/list" })
    public List<Valoracion>getList() {
        List<Valoracion> listaValoraciones = valoracionService.obtenerTodos();
        return listaValoraciones;
    }
    @PostMapping("/")
    public ResponseEntity<?> newElement(@Valid @RequestBody Valoracion nuevaValoracion) {
        Valoracion valoracionAgregada=valoracionService.agregar(nuevaValoracion);
        return ResponseEntity.status(HttpStatus.CREATED).body(valoracionAgregada);
    }


    @PutMapping("/{id}")
    public ResponseEntity<?>  editElement (@PathVariable long id,  @RequestBody Valoracion valoracion ) {
        Valoracion valoracionBusca=valoracionService.obtenerPorId(id);
        if(valoracionBusca==null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        Valoracion valoracionEditado=valoracionService.editar(valoracion);
        return ResponseEntity.status(HttpStatus.OK).body(valoracionEditado);
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<?>  deleteElement(@PathVariable long id){
        Valoracion valoracionBusca=valoracionService.obtenerPorId(id);
        if(valoracionBusca==null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        valoracionService.borrar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}



