package com.example.app.utilities;

import com.example.app.dto.CuentaNuevaDto;
import com.example.app.entity.Cuenta;
import org.springframework.stereotype.Component;

@Component
public class CuentaDtoConverter {
    public Cuenta convertDtoToCuenta(CuentaNuevaDto cuentaNuevaDto) {
        return new Cuenta(cuentaNuevaDto.getIBAN(),
                   cuentaNuevaDto.getAlias(),
                0D,
                null);
    }

}
