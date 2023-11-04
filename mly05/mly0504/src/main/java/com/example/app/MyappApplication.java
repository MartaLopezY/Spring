package com.example.app;

import com.example.app.services.JuegoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MyappApplication implements CommandLineRunner {


		JuegoService juegoService;
	public MyappApplication(JuegoService juegoService) {
		this.juegoService = juegoService;
	}

		public static void main (String[]args){
			SpringApplication.run(MyappApplication.class,args);

		}
		@Override
		public void run(String... args) throws Exception{
			juegoService.cargarPaisesDesdeFichero();
		}

}
