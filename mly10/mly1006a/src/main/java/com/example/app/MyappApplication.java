package com.example.app;

import com.example.app.entity.Empleado;
import com.example.app.entity.Genero;
import com.example.app.service.EmpleadoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;



@SpringBootApplication
public class MyappApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyappApplication.class, args);


}
		@Bean
		CommandLineRunner initData(EmpleadoService empleadoService) {
			return args -> {
				empleadoService.agregar(
						new Empleado(1L, "pepe", "pepe@gmail.com", 1000d, true, Genero.MASCULINO));
				empleadoService.agregar(
						new Empleado(2L, "ana", "ana@gmail.com", 2000d, true, Genero.FEMENINO));
			};
		}

}
