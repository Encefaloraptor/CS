package mycopy.databaseproyect0501;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import mycopy.databaseproyect0501.domain.Empleado;
import mycopy.databaseproyect0501.domain.Genero;
import mycopy.databaseproyect0501.services.EmpleadoService;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	@Bean
	CommandLineRunner initData(EmpleadoService empleadoService) {
		return args -> {
			empleadoService.añadir(
					new Empleado(1L, "López Pérez, José", "jlp@gmail.com", 25000d, true, Genero.MASCULINO));
			empleadoService.añadir(new Empleado(2L, "García Martínez, Ana", "ana_garcia@gmail.com", 20000d, false,
					Genero.FEMENINO));
			empleadoService.añadir(new Empleado(3L, "Martínez Ruiz, Juan", "juanmr@gmail.com", 25000d, true,
					Genero.MASCULINO));
			empleadoService.añadir(
					new Empleado(4L, "Pérez Gómez, María", "mariapg@gmail.com", 18000d, true, Genero.FEMENINO));
			empleadoService.añadir(new Empleado(5L, "Gómez Sánchez, Pedro", "pedro_sanchez@gmail.com", 22000d, false,
					Genero.MASCULINO));
			empleadoService.añadir(new Empleado(6L, "Sánchez López, Laura", "laurasl@gmail.com", 27000d, true,
					Genero.FEMENINO));
			empleadoService.añadir(
					new Empleado(7L, "Ruiz García, David", "davidruiz@gmail.com", 19000d, false, Genero.OTROS));
			empleadoService.añadir(new Empleado(8L, "Pérez Martínez, Carmen", "carmenpm@gmail.com", 29000d, true,
					Genero.OTROS));
			empleadoService.añadir(new Empleado(9L, "Martínez Gómez, Sergio", "sergiomg@gmail.com", 27000d, false,
					Genero.MASCULINO));
			empleadoService.añadir(new Empleado(10L, "López Sánchez, Isabel", "isalopez@gmail.com", 24000d, true,
					Genero.FEMENINO));

		};
	}

}
