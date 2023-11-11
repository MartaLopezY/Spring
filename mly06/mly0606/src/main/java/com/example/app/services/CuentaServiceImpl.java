package com.example.app.services;


import com.example.app.entity.Cuenta;
import com.example.app.entity.Movimiento;
import com.example.app.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;


@Service
public class CuentaServiceImpl implements CuentaService {
    private List<Cuenta> repositorio = new ArrayList<>();
    public Cuenta agregar(Cuenta cuenta) {
        if(cuenta.getSaldo() ==null) cuenta.setSaldo(0d);
        repositorio.add(cuenta);
        return cuenta;
    }

    public List<Cuenta> obtenerTodos() {
        return repositorio;
    }

    public Cuenta obtenerPorIBAN(String IBAN) throws NotFoundException {
        for (Cuenta cuenta : repositorio)
            if (Objects.equals(cuenta.getIBAN(), IBAN))
                return cuenta;
        throw new NotFoundException("Cuenta no encontrada");
    }

    public Cuenta editar(Cuenta cuenta) throws NotFoundException {
        int pos = repositorio.indexOf(cuenta);
        if (pos == -1)
            throw new NotFoundException("Cuenta no encontrada");
        repositorio.set(pos, cuenta);
        return cuenta;
    }

    public void borrar(String IBAN) throws NotFoundException {
        Cuenta cuenta = this.obtenerPorIBAN(IBAN);

        if (cuenta != null && cuenta.getSaldo()==0) {
            Iterator<Movimiento> iterator = cuenta.getMovimientos().iterator();
            while (iterator.hasNext()) {
                Movimiento movimiento = iterator.next();
                if (movimiento.getIBAN().equals(IBAN))
                    iterator.remove();
            }
            repositorio.remove(cuenta);
        }else{
            throw new NotFoundException("No se puede borrar la cuenta porque el saldo n es cero");
        }
    }
    public void modificarSaldo(Movimiento movimiento) throws NotFoundException {
        Cuenta cuenta = this.obtenerPorIBAN(movimiento.getIBAN());
        if (movimiento.getImporte() > 0 || Math.abs(movimiento.getImporte()) < cuenta.getSaldo()){
            cuenta.setSaldo(cuenta.getSaldo() + movimiento.getImporte());
            if (movimiento.getFecha() == null) movimiento.setFecha(LocalDateTime.now());
            List<Movimiento> nuevoMov = new ArrayList<>();
            if (cuenta.getMovimientos() == null) nuevoMov.add(movimiento);
            else {
                nuevoMov=cuenta.getMovimientos();
                nuevoMov.add(movimiento);
            }
            cuenta.setMovimientos(nuevoMov);
        }else{
            throw new NotFoundException("No se puede añadir el movimiento porque el saldo no es suficiente");
        }
    }
    public List<Cuenta> findByMovimiento(long idMov) {
        List<Cuenta> cuentas = new ArrayList<>();
        for (Cuenta cuenta : repositorio) {
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
