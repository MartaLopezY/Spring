package com.example.app.service;

import com.example.app.entity.Paciente;
import com.example.app.entity.PacienteDTO;

import java.util.List;

public interface PacienteService {
    void add(Paciente paciente);
    void deleteFirst();
    Paciente getFirst();
    List<Paciente> findAll();
    Paciente buildPacientefromDTO(PacienteDTO newPacienteDTO);
    Double facturar (Paciente paciente);
}
