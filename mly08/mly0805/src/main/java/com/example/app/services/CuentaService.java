package com.example.app.services;


import com.example.app.entity.Cuenta;
import com.example.app.entity.Movimiento;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface CuentaService {


    Cuenta agregar(Cuenta cuenta);
    List<Cuenta> obtenerTodos();
    Cuenta obtenerPorIBAN(String IBAN);
    Cuenta editar (Cuenta cuenta);
    void borrar (String IBAN);
    void modificarSaldo(Movimiento movimiento);
    List<Cuenta> findByMovimiento(long idMov);
}
