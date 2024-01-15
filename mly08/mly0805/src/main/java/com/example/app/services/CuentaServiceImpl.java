package com.example.app.services;


import com.example.app.entity.Cuenta;
import com.example.app.entity.Movimiento;
import com.example.app.exceptions.CuentaConSaldo;
import com.example.app.exceptions.CuentaNotFoundException;
import com.example.app.exceptions.EmptyCuentasException;
import com.example.app.exceptions.MovimientoImporteIncorrecto;
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
        List<Cuenta> lista=cuentaRepository.findAll();
        if(lista.isEmpty()) throw new EmptyCuentasException();
        return lista;
    }

    public Cuenta obtenerPorIBAN(String IBAN){
        Cuenta cuenta= cuentaRepository.findByIBANWithMovimientos(IBAN);
        if(cuenta==null) throw new CuentaNotFoundException(IBAN);
        return cuenta;
    }
    public Cuenta editar(Cuenta cuenta) { return cuentaRepository.save(cuenta);}
    public void borrar(String IBAN)  {
        if(cuentaRepository.findByIBANWithMovimientos(IBAN).getSaldo()!=0) throw new CuentaConSaldo(IBAN);
        cuentaRepository.deleteById(IBAN);
    }
    public void modificarSaldo(Movimiento movimiento){
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
            throw new MovimientoImporteIncorrecto();
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
