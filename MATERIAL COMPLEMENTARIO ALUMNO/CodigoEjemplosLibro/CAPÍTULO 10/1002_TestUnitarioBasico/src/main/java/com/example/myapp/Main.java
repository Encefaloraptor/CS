package com.example.myapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	@Bean
	CommandLineRunner initData(MainService mainService) {
		return args -> {
			System.out.println("Suma:" + mainService.sumar(2, 3));
			System.out.println("División:" + mainService.dividir(10, 2));
		};
	}

}
