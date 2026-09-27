package com.example.myapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.myapp.model.Rol;
import com.example.myapp.model.Usuario;
import com.example.myapp.repository.UsuarioRepository;

@SpringBootApplication
public class Main {

	@Autowired
    PasswordEncoder encoder;

	public static void main(String[] args) {
    SpringApplication.run(Main.class, args);
	}

	@Bean
	CommandLineRunner initData(UsuarioRepository usuarioRepository) {
		return args -> {
			usuarioRepository.save(new Usuario(null, "admin", "admin@mail.com", encoder.encode("1234"), Rol.ADMIN));
			};
	}
}
