package com.example.app.services;


import com.example.app.entity.Cuenta;
import com.example.app.entity.Movimiento;
import com.example.app.exceptions.EmptyMovimientosException;
import com.example.app.repositories.MovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MovimientoServiceImpl implements MovimientoService {

    @Autowired
    MovimientoRepository movimientoRepository;


    public List<Movimiento> obtenerTodos() {
        List<Movimiento> lista= movimientoRepository.findAll();
        if(lista.isEmpty()) throw new EmptyMovimientosException();
        return lista;
    }

    public Movimiento obtenerPorId(Long id){

                return movimientoRepository.findById(id).orElse(null);
    }

    public Movimiento agregar(Movimiento movimiento) {

        return movimientoRepository.save(movimiento);
    }
    public List<Movimiento> obtenerPorCuenta(Cuenta cuenta){return movimientoRepository.findByCuenta(cuenta);} ;
}
