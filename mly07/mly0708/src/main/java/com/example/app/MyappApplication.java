package com.example.app;

import com.example.app.entity.Departamento;
import com.example.app.entity.Empleado;
import com.example.app.entity.Genero;
import com.example.app.service.DepartamentoService;
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
/*

@Bean
CommandLineRunner initData(EmpleadoService empleadoService,
						   DepartamentoService departamentoService) {
	return args -> {
		departamentoService.añadir(new Departamento(0L, "Informática"));
		departamentoService.añadir(new Departamento(0L, "RRHH"));
		empleadoService.agregar
				(new Empleado(0L, "pepe", "pepe@gmail.com", 800d, true,
						Genero.MASCULINO,
						departamentoService.obtenerPorNombre("Informática")));

		empleadoService.agregar(
				new Empleado(0L, "ana", "ana@gmail.com", 2000d, true, Genero.FEMENINO,departamentoService.obtenerPorNombre("RRHH")));
		empleadoService.agregar(
				new Empleado(0L, "juan", "juan@gmail.com", 1500d, true, Genero.MASCULINO,departamentoService.obtenerPorNombre("RRHH")));
		empleadoService.agregar(
				new Empleado(0L, "maria", "maria@gmail.com", 2500d, true, Genero.FEMENINO,departamentoService.obtenerPorNombre("Informática")));
		empleadoService.agregar(
				new Empleado(0L, "pedro", "pedro@gmail.com", 900d, true, Genero.MASCULINO,departamentoService.obtenerPorNombre("RRHH")));
		empleadoService.agregar(
				new Empleado(0L, "eva", "eva@gmail.com", 1500d, true, Genero.FEMENINO,departamentoService.obtenerPorNombre("Informática")));
	};
}
	*/
}
