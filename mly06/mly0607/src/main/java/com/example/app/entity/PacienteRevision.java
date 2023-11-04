package com.example.app.entity;

import com.example.app.config.Tarifas;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PacienteRevision extends Paciente{

    private LocalDate fechaUltimaRevision;
    @Override
    public  Double facturar(Tarifas tarifas){
        long edad= ChronoUnit.YEARS.between(this.getFechaNacimiento(),LocalDate.now());
        if (edad<= 65 ) return tarifas.getTarifaRevisionAdulto();
        else  return tarifas.getTarifaRevisionJubilado();
    }
}
