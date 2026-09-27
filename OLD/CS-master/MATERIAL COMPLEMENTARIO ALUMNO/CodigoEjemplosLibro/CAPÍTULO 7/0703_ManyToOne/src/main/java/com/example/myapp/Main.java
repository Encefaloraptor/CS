package com.example.myapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.myapp.domain.Departamento;
import com.example.myapp.domain.Empleado;
import com.example.myapp.domain.Genero;
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
			Departamento depInf = departamentoService.añadir(new Departamento(null, "Informática"));
			Departamento depRRHH = departamentoService.añadir(new Departamento(null, "RRHH"));

			empleadoService.añadir(new Empleado(null, "José López", "jlp@mail.com", 18000d, true, Genero.MASCULINO,depInf));
			empleadoService.añadir(new Empleado(null, "Ana García", "anag@mail.com", 20000d, false,	Genero.FEMENINO,depRRHH));
		};
	}

}
