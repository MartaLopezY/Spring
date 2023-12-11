package com.example.app.services;


import com.example.app.entity.Cuenta;
import com.example.app.entity.Movimiento;
import com.example.app.exceptions.NotFoundException;
import com.example.app.repositories.CuentaRepository;
import com.example.app.repositories.MovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Service
public class CuentaServiceImpl implements CuentaService {
    @Autowired
    CuentaRepository cuentaRepository;
    MovimientoRepository movimientoRepository;

    public Cuenta agregar(Cuenta cuenta) { return cuentaRepository.save(cuenta);}
    public List<Cuenta> obtenerTodos() {
        return cuentaRepository.findAll();
    }

    public Cuenta obtenerPorIBAN(String IBAN) throws NotFoundException {
        return cuentaRepository.findByIBANWithMovimientos(IBAN);
    }
    public Cuenta editar(Cuenta cuenta) { return cuentaRepository.save(cuenta);}
    public void borrar(String IBAN)  { cuentaRepository.deleteById(IBAN); }
    public void modificarSaldo(Movimiento movimiento) throws NotFoundException {
        Cuenta cuenta = this.obtenerPorIBAN(movimiento.getIBAN());
        if (movimiento.getImporte() > 0 || Math.abs(movimiento.getImporte()) < cuenta.getSaldo()){
            cuenta.setSaldo(cuenta.getSaldo() + movimiento.getImporte());
            if (movimiento.getFecha() == null) movimiento.setFecha(LocalDateTime.now());
            List<Movimiento> nuevoMov = new ArrayList<>();
            if ( movimientoRepository.findByCuenta(cuenta) == null) movimientoRepository.save(movimiento);
            else {
                nuevoMov=movimientoRepository.findByCuenta(cuenta);
                nuevoMov.add(movimiento);
            }
            cuenta.setMovimientos(nuevoMov);
        }else{
            throw new NotFoundException("No se puede añadir el movimiento porque el saldo no es suficiente");
        }
    }
    public List<Cuenta> findByMovimiento(long idMov) {
        List<Cuenta> cuentas = new ArrayList<>();
        for (Cuenta cuenta : cuentas) {
            for (Movimiento movimiento : cuenta.getMovimientos()) {
                if (movimiento.getId().equals(idMov)) {
                    cuentas.add(cuenta);
                    break;
                }
            }
        }
        return cuentas;
    }

}
