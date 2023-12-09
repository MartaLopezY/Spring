package com.example.app;

import com.example.app.entity.*;
import com.example.app.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;


@SpringBootApplication
public class MyappApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyappApplication.class, args);


}


@Bean
CommandLineRunner initData(EmpleadoService empleadoService,
						   DepartamentoService departamentoService, CategoriaService categoriaService, ProyectoService proyectoService, EmpleadoProyectoService empleadoProyectoService) {
	return args -> {
	proyectoService.agregar(new Proyecto(0L,"Nueva normativa UE"));
    proyectoService.agregar(new Proyecto(1L,"Mejora Web actual"));

	categoriaService.agregar( new Categoria(0L, "Jefe de Equipo", null));
	categoriaService.agregar( new Categoria(0L, "Programador Junior", null));
	categoriaService.agregar( new Categoria(0L, "Administrativo", null));
	departamentoService.agregar(new Departamento(0L, "Informática"));
	departamentoService.agregar(new Departamento(0L, "RRHH"));
	empleadoService.agregar
				(new Empleado(0L, "pepe", "pepe@gmail.com", 800d, true,	Genero.MASCULINO, departamentoService.obtenerPorNombre("Informática"),categoriaService.obtenerPorNombre("Jefe de Equipo")));
	empleadoService.agregar(
				new Empleado(0L, "ana", "ana@gmail.com", 2000d, true, Genero.FEMENINO,departamentoService.obtenerPorNombre("RRHH"),categoriaService.obtenerPorNombre("Jefe de Equipo")));
	empleadoService.agregar(
				new Empleado(0L, "juan", "juan@gmail.com", 1500d, true, Genero.MASCULINO,departamentoService.obtenerPorNombre("RRHH"),categoriaService.obtenerPorNombre("Administrativo")));
	empleadoService.agregar(
				new Empleado(0L, "maria", "maria@gmail.com", 2500d, true, Genero.FEMENINO,departamentoService.obtenerPorNombre("Informática"),  categoriaService.obtenerPorNombre("Programador Junior")));
	empleadoService.agregar(
				new Empleado(0L, "pedro", "pedro@gmail.com", 900d, true, Genero.MASCULINO,departamentoService.obtenerPorNombre("RRHH"),categoriaService.obtenerPorNombre("Administrativo")));
	empleadoService.agregar(
				new Empleado(0L, "eva", "eva@gmail.com", 1500d, true, Genero.FEMENINO,departamentoService.obtenerPorNombre("Informática"), categoriaService.obtenerPorNombre("Programador Junior")));
};
}

}
