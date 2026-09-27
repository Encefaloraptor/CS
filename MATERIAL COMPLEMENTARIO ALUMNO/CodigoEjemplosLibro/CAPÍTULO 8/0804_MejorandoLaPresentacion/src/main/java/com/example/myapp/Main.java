package com.example.myapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.myapp.domain.Rol;
import com.example.myapp.domain.Usuario;
import com.example.myapp.services.UsuarioService;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	@Bean
	CommandLineRunner initData(UsuarioService usuarioService) {
		return args -> {

			usuarioService.añadir(new Usuario(null, "admin", "1234", Rol.ADMIN));
		};
	}

}
