package com.example.app.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Service
public class FechasServiceImpl implements FechasService{
    public Long daysForYear(LocalDate fecha){
        int year=fecha.getYear();
        return(ChronoUnit.DAYS.between(LocalDate.of(year,1,1),fecha));
    }
    public Long diasFechas(LocalDate fechaIni,LocalDate fechaFin){

        return(ChronoUnit.DAYS.between(fechaIni,fechaFin));
    }

    public Boolean esBisiesto(LocalDate fecha){

      return fecha.isLeapYear();

    }

    public Integer numerosBisiestos(LocalDate fechaIni,LocalDate fechaFin){
       int bisiestos=0;
        int inicio=fechaIni.getYear();
        int fin=fechaFin.getYear();
        for(int i=inicio;i<=fin;i++){
            if(LocalDate.of(i,1,1).isLeapYear()) bisiestos++;
        }

        return bisiestos;
    }
}
