package com.example.myapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.myapp.domain.Departamento;
import com.example.myapp.domain.Empleado;
import com.example.myapp.services.DepartamentoService;
import com.example.myapp.services.EmpleadoService;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	@Bean
	CommandLineRunner initData(EmpleadoService empleadoService, DepartamentoService departamentoService) {
		return args -> {
			Departamento d1 = departamentoService.añadir(new Departamento(null, "Informática"));

			empleadoService.añadir(new Empleado(null, "José López", "jl@mail.com", 38000d, d1));
			empleadoService.añadir(new Empleado(null, "Ana García", "ana_garcia@mail.com", 20000d, d1));
		};
	}
}
