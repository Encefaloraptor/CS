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
			empleadoService.añadir(	new Empleado(1L, "José López", "jlp@mail.com", 25000d, true, Genero.MASCULINO));
			empleadoService.añadir(new Empleado(2L, "Ana García", "anag@mail.com", 20000d, false,Genero.FEMENINO));
		};
	}
}
