package com.example.app.services;


import com.example.app.entity.Movimiento;
import com.example.app.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class MovimientoServiceImpl implements MovimientoService {
    private List<Movimiento> repositorio = new ArrayList<>();



    public List<Movimiento> obtenerTodos() {
        return repositorio;
    }

    public Movimiento obtenerPorId(long id) throws NotFoundException {
        for (Movimiento movimiento : repositorio)
            if (movimiento.getId() == id)
                return movimiento;
        throw new NotFoundException("Movimiento no encontrado");
    }

    public Movimiento agregar(Movimiento movimiento) {
        repositorio.add(movimiento);
        return movimiento;
    }
    
}
