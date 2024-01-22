package com.example.app;

import com.example.app.entity.Empleado;
import com.example.app.entity.Genero;
import com.example.app.entity.Rol;
import com.example.app.entity.Usuario;
import com.example.app.repository.UsuarioRepository;
import com.example.app.service.EmpleadoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;


@SpringBootApplication
public class MyappApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyappApplication.class, args);


}
	@Bean
	CommandLineRunner initData(EmpleadoService empleadoService, UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {

			return args -> {
				empleadoService.agregar(
						new Empleado(0L, "pepe", "pepe@gmail.com", 1000d, true, Genero.MASCULINO));
				empleadoService.agregar(
						new Empleado(0L, "ana", "ana@gmail.com", 2000d, true, Genero.FEMENINO));
				empleadoService.agregar(
						new Empleado(0L, "juan", "juan@gmail.com", 1500d, true, Genero.MASCULINO));
				empleadoService.agregar(
						new Empleado(0L, "maria", "maria@gmail.com", 2500d, true, Genero.FEMENINO));
				empleadoService.agregar(
						new Empleado(0L, "pedro", "pedro@gmail.com", 900d, true, Genero.MASCULINO));
				empleadoService.agregar(
						new Empleado(0L, "eva", "eva@gmail.com", 1500d, true, Genero.FEMENINO));

			usuarioRepository.save(new Usuario(0L,"admin1",passwordEncoder.encode("1234"), Rol.ADMIN));
				usuarioRepository.save(new Usuario(0L,"user1",passwordEncoder.encode("1234"), Rol.USER));
			};
		}

}
