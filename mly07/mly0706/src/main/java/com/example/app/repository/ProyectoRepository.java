package com.example.app.repository;

import com.example.app.entity.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {

    Proyecto findByNombre(String nombre);

}
