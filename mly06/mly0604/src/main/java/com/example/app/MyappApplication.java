package com.example.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyappApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyappApplication.class, args);
	}
@Bean
	CommandLineRunner initData(ProductoService productoService) {
		return args -> {

			productoService.agregar(
					new Producto(1L, "mesa", true, NORMAL, 100d));
			productoService.agregar(
					new Producto(2L, "silla", false, NORMAL, 50d));
			productoService.agregar(
					new Producto(3L, "estanteria", true, REDUCIDO, 70d));
		};
	}
}
