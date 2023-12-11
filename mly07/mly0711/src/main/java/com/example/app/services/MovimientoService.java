package com.example.app.services;


import com.example.app.entity.Cuenta;
import com.example.app.entity.Movimiento;
import com.example.app.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface MovimientoService {


    List<Movimiento> obtenerTodos();
    Movimiento obtenerPorId(Long id) throws NotFoundException;
    Movimiento agregar(Movimiento movimiento);
    List<Movimiento> obtenerPorCuenta(Cuenta cuenta);
}
