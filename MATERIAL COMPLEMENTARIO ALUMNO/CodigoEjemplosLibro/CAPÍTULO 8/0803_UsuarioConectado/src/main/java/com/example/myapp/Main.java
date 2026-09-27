package com.example.myapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.myapp.domain.Empleado;
import com.example.myapp.domain.Rol;
import com.example.myapp.domain.Usuario;
import com.example.myapp.services.EmpleadoService;
import com.example.myapp.services.UsuarioService;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	@Bean
	CommandLineRunner initData(EmpleadoService empleadoService, UsuarioService usuarioService) {
		return args -> {
			empleadoService.añadir(	new Empleado(null, "José Pérez", "jp@mail.com", 18000d));
			empleadoService.añadir(new Empleado(null, "Ana García", "ana_garcia@mail.com", 30000d));
			usuarioService.añadir(new Usuario(null, "admin", "1234", Rol.ADMIN));
		};
	}

}
