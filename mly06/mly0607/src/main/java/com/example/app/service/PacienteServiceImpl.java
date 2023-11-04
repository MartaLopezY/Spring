package com.example.app.service;

import com.example.app.config.Tarifas;
import com.example.app.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class PacienteServiceImpl implements PacienteService{
    List <Paciente> repositorio=new ArrayList<>();
    @Autowired
    Tarifas tarifas;
    public void add(Paciente paciente){
        repositorio.add(paciente);

    }
    public void deleteFirst(){
        if(repositorio.size()>0)
            repositorio.remove(0);
    }

    public Paciente getFirst(){
        if(repositorio.size()>0)
            return repositorio.get(0);
        return null;

    }
    public List<Paciente> findAll(){
            return repositorio;
    }
    public Paciente buildPacientefromDTO(PacienteDTO pacienteDTO){

    Paciente paciente;
    switch (pacienteDTO.getTipoPaciente()){
        case 1 ->{ paciente=new PacienteConsulta();
                   ((PacienteConsulta)paciente).setMotivoConsulta(pacienteDTO.getMotivoConsulta());
        }
        case 2 -> {paciente=new PacienteRecetas();
            String[] med=pacienteDTO.getListaMedicamentos().split(",");
            ((PacienteRecetas)paciente).setListaMedicamentos(Arrays.asList(med));
        }
        case 3 -> {paciente = new PacienteRevision();

            ((PacienteRevision)paciente).setFechaUltimaRevision(pacienteDTO.getFechaUltimaRevision());
        }
        default -> {return null;}
    }
    paciente.setDni(pacienteDTO.getDni());
    paciente.setFechaNacimiento(pacienteDTO.getFechaNacimiento());
    paciente.setNombre(pacienteDTO.getNombre());
    return paciente;
    }
    public  Double facturar (Paciente paciente){
        if(paciente != null)
            return paciente.facturar(tarifas);
        else
            return  0d;

    }
}
