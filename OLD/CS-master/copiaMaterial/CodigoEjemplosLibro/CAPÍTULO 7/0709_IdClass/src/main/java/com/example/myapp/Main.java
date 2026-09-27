package com.example.myapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.myapp.domain.Empleado;
import com.example.myapp.domain.Proyecto;
import com.example.myapp.services.EmpleadoService;
import com.example.myapp.services.ProyectoService;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	@Bean
	CommandLineRunner initData(EmpleadoService empleadoService, ProyectoService proyectoService) {
		return args -> {

			proyectoService.añadir(new Proyecto(null, "Nueva normativa UE"));
			proyectoService.añadir(new Proyecto(null, "Captación nuevos clientes"));

			empleadoService.añadir(
					new Empleado(null, "José López", "jl@mail.com", 18000d));
			empleadoService.añadir(new Empleado(null, "Ana García", "anag@mail.com", 20000d));

		};
	}

}
