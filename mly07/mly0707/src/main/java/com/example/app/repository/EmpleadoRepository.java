package com.example.app.repository;

import com.example.app.entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmpleadoRepository  extends JpaRepository<Empleado, Long> {

}
