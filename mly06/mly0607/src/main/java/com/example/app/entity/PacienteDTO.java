package com.example.app.entity;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class PacienteDTO {
    @Size(min=5,max=11)
    private String dni;
    @Size(min=2,max=255)
    private String nombre;
    @Past
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaNacimiento;
    @Min(1)
    @Max(3)
    private Integer tipoPaciente;
    private String motivoConsulta;
    private String listaMedicamentos;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaUltimaRevision;

}
