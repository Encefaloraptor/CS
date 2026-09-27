package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.model.Producto;
import com.example.repository.ProductoRepository;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	@Bean
	CommandLineRunner initData(ProductoRepository productoRepository) {
		return args -> {
			productoRepository.añadir(new Producto(null, "Impresora HP500", 120.50D));
			productoRepository.añadir(new Producto(null, "Portatil HP Pavillion", 850D));
		};
	}
}
