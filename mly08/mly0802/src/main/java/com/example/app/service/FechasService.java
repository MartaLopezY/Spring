package com.example.app.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

public interface FechasService {

    public Long daysForYear(LocalDate fecha);

    public Long diasFechas(LocalDate fechaIni,LocalDate fechaFin);

    public Boolean esBisiesto(LocalDate fecha);

    public Integer numerosBisiestos(LocalDate fechaIni, LocalDate fechaFin);
}
