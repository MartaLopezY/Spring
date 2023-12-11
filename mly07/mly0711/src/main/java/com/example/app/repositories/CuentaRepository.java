package com.example.app.repositories;

import com.example.app.entity.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface CuentaRepository extends JpaRepository<Cuenta, String> {
    @Query
    ("SELECT c FROM Cuenta c JOIN FETCH c.movimientos WHERE c.IBAN = :IBAN")
    Cuenta findByIBANWithMovimientos(String IBAN);
}
