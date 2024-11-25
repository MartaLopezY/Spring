package com.example.app;

import com.example.app.entity.Cuenta;
import com.example.app.entity.Movimiento;
import com.example.app.entity.Rol;
import com.example.app.entity.Usuario;
import com.example.app.repositories.UsuarioRepository;
import com.example.app.services.CuentaService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class MyappApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyappApplication.class, args);
	}

	@Bean
	CommandLineRunner initData(CuentaService cuentaService, UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
		return args -> {

			List<Movimiento> movimiento1=new ArrayList<>();
			List<Movimiento> movimiento2=new ArrayList<>();

			cuentaService.agregar(
					new Cuenta("ES9121000418450200051332", "cuentaPepe", 1000d,movimiento1));
			cuentaService.agregar(
					new Cuenta("ES4875051428450854700340", "cuentaAna", 1800d,movimiento2 ));
			movimiento1.add(new Movimiento(1L, "ES9121000418450200051332",660d, LocalDateTime.of(2022, 12, 5, 12, 12),cuentaService.obtenerPorIBAN("ES9121000418450200051332")));
			movimiento1.add(new Movimiento(2L, "ES9121000418450200051332",540d, LocalDateTime.of(2022, 12, 8, 12, 12),cuentaService.obtenerPorIBAN("ES9121000418450200051332")));
			movimiento1.add(new Movimiento(3L, "ES9121000418450200051332",-100d, LocalDateTime.of(2022, 12, 10, 12, 12),cuentaService.obtenerPorIBAN("ES9121000418450200051332")));
			movimiento2.add(new Movimiento(1L, "ES4875051428450854700340",1000d,LocalDateTime.of(2022, 12, 6, 12, 12),cuentaService.obtenerPorIBAN("ES4875051428450854700340")));
			movimiento2.add(new Movimiento(2L, "ES4875051428450854700340",-200d,LocalDateTime.of(2022, 12, 15, 12, 12),cuentaService.obtenerPorIBAN("ES4875051428450854700340")));
			movimiento2.add(new Movimiento(3L, "ES4875051428450854700340",800d,LocalDateTime.of(2022, 12, 16, 12, 12),cuentaService.obtenerPorIBAN("ES4875051428450854700340")));

			usuarioRepository.save(new Usuario(0L,"admin1",passwordEncoder.encode("1234"), Rol.ADMIN));
			usuarioRepository.save(new Usuario(0L,"user1",passwordEncoder.encode("1234"), Rol.USER));
			usuarioRepository.save(new Usuario(0L,"titular1",passwordEncoder.encode("1234"), Rol.TITULAR));
		};
	}


}

