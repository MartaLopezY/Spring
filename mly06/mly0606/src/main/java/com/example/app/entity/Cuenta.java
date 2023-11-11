package com.example.app.entity;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "IBAN")
public class Cuenta {

    @NotNull
    private String IBAN;
    private String alias;
    private Double saldo;
    private List<Movimiento> movimientos;



}
