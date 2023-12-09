package com.example.app.repository;

import com.example.app.entity.Departamento;

import org.springframework.data.jpa.repository.JpaRepository;



public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {

    Departamento findByNombre(String nombre);

}
