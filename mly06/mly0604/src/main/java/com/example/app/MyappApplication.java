package com.example.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyappApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyappApplication.class, args);
	}
@Bean
	CommandLineRunner initData(ProductoService productoService, CategoriaService categoriaService) {
		return args -> {

			productoService.agregar(
					new Producto(1L, "mesa", true, NORMAL, 100d,1L));
			productoService.agregar(
					new Producto(2L, "silla", false, NORMAL, 50d,1L));
			productoService.agregar(
					new Producto(3L, "estanteria", true, REDUCIDO, 70d,1L));
			categoriaService.agregar(
					new Categoria(1L, "muebles"));
			categoriaService.agregar(
					new Categoria(2L, "alfombras"));
			categoriaService.agregar(
					new Categoria(3L, "accesorios"));
		};
}
