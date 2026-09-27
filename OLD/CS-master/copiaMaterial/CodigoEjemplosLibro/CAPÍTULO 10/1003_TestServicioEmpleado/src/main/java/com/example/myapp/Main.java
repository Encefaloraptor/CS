package com.example.myapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.myapp.domain.Empleado;
import com.example.myapp.domain.Genero;
import com.example.myapp.services.EmpleadoService;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	@Bean
	CommandLineRunner initData(EmpleadoService empleadoService) {
		return args -> {
			empleadoService.añadir(new Empleado(null, "pepe", "pepe@gmail.com", 18000d, true,
					Genero.MASCULINO));
			empleadoService.añadir(new Empleado(null, "ana", "ana@gmail.com", 19000d, true,
					Genero.FEMENINO));
			empleadoService.añadir(new Empleado(null, "luis", "luis@gmail.com", 20000d, true,
					Genero.FEMENINO));
			empleadoService.añadir(new Empleado(null, "eva", "eva@gmail.com", 40000d, false,
					Genero.FEMENINO));
		};
	}

}
