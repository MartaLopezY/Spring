package com.example.app.repositories;

import com.example.app.entity.Cuenta;
import com.example.app.entity.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface MovimientoRepository extends JpaRepository<Movimiento, Long> {
    List<Movimiento> findByCuenta(Cuenta cuenta);
}
