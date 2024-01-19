package com.example.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyappApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyappApplication.class, args);
	}
/*
	@Bean
	CommandLineRunner initData(ProductoService productoService, CategoriaService categoriaService, UsuarioService usuarioService, ValoracionService valoracionService) {
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
					new Producto(4L, "jarón", true, NORMAL, 5d,categoriaService.obtenerPorId(2L)));
			usuarioService.agregar(new Usuario(0L,"pepe"));
			usuarioService.agregar(new Usuario(1L,"maria",null));
			valoracionService.agregar(new Valoracion(0L,6,"Se estropea rapido"));
			valoracionService.agregar(new Valoracion(1L,8,"funciona bien"));
		};
	}
*/

}