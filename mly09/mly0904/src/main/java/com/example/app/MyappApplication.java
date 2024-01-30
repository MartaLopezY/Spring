package com.example.app;

import com.example.app.entity.*;
import com.example.app.repositories.UsuarioRepository;
import com.example.app.services.CategoriaService;
import com.example.app.services.ProductoService;
import com.example.app.services.ValoracionService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;

import static com.example.app.entity.TipoIva.*;

@SpringBootApplication
public class MyappApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyappApplication.class, args);
	}

	@Bean
	CommandLineRunner initData(ProductoService productoService, CategoriaService categoriaService, UsuarioRepository usuarioRepository, ValoracionService valoracionService, PasswordEncoder passwordEncoder) {
		return args -> {
			categoriaService.agregar(
					new Categoria(1L, "muebles"));
			categoriaService.agregar(
					new Categoria(2L, "accesorios"));
			productoService.agregar(
					new Producto(1L, "mesa", true, NORMAL, 100d,categoriaService.obtenerPorId(1L)));
			productoService.agregar(
					new Producto(2L, "silla", false, NORMAL, 50d,categoriaService.obtenerPorId(1L)));
			productoService.agregar(
					new Producto(3L, "estanteria", true, REDUCIDO, 70d,categoriaService.obtenerPorId(1L)));
			productoService.agregar(
					new Producto(4L, "cojin", true, NORMAL, 20d,categoriaService.obtenerPorId(2L)));
			productoService.agregar(
					new Producto(4L, "jarrón", true, NORMAL, 5d,categoriaService.obtenerPorId(2L)));
			usuarioRepository.save(new Usuario(0L,"admin1", LocalDate.of(2023, 12, 5),passwordEncoder.encode("1234"), Rol.ADMIN));
			usuarioRepository.save(new Usuario(0L,"user1", LocalDate.of(2024, 1, 5),passwordEncoder.encode("1234"), Rol.USER));
			usuarioRepository.save(new Usuario(0L,"manager1", LocalDate.of(2024, 1, 5),passwordEncoder.encode("1234"), Rol.MANAGER));

			valoracionService.agregar(new Valoracion(0L,6,"Se estropea rapido"));
			valoracionService.agregar(new Valoracion(1L,8,"Funciona bien"));
		};
	}


}