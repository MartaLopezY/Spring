package com.example.app.entity;

import com.example.app.config.Tarifas;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PacienteRecetas extends Paciente{
    private List<String> listaMedicamentos;
    @Override
    public  Double facturar(Tarifas tarifas){
        return tarifas.getTarifaReceta() * listaMedicamentos.size();
    }
}
