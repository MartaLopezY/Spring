package com.example.app.entity;

import com.example.app.config.Tarifas;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PacienteConsulta extends Paciente{
    private String motivoConsulta;
    @Override
    public  Double facturar(Tarifas tarifas){
        return tarifas.getTarifaConsulta();
    }
}
