package com.example.empleado;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

/*	@Bean
	CommandLineRunner initData(EmpleadoService empleadoService) {
		return args -> {
			empleadoService.añadir(new Empleado(0L, "pepe", "pepe@gmail.com", 800d, true,
					Genero.MASCULINO));
			empleadoService.añadir(new Empleado(0L, "ana", "ana@gmail.com", 900d, true,
					Genero.FEMENINO));
			empleadoService.añadir(new Empleado(0L, "luis", "luis@gmail.com", 2000d, true,
					Genero.FEMENINO));
			empleadoService.añadir(new Empleado(0L, "eva", "eva@gmail.com", 4000d, false,
					Genero.FEMENINO));
		};
	}*/

}
