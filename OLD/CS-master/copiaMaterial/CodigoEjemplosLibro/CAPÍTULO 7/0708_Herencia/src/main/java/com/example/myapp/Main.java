package com.example.myapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.myapp.model.Coche;
import com.example.myapp.model.Moto;
import com.example.myapp.services.VehiculoService;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	@Bean
	CommandLineRunner initData(VehiculoService vehiculoService) {
		return args -> {
			vehiculoService.añadir(new Coche(null, "Opel Astra GT", 35000d, 2000));
			vehiculoService.añadir(new Coche(null, "Renault Megane", 33000d, 1550));
			vehiculoService.añadir(new Moto(null, "Yamaha MT-07", 5000d, 100));

		};
	}

}
