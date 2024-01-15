package com.example.app.utilities;

import com.example.app.dto.MovimientoNuevoDto;
import com.example.app.entity.Movimiento;
import com.example.app.services.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MovimientoDtoConverter {
    @Autowired
    CuentaService cuentaService;
    public Movimiento convertDtoToMovimiento(MovimientoNuevoDto movimientoNuevoDto) {
        return new Movimiento(null,
                movimientoNuevoDto.getIBAN(),
                movimientoNuevoDto.getImporte(),
                LocalDateTime.now(),
                cuentaService.obtenerPorIBAN(movimientoNuevoDto.getIBAN()));
    }

}
