package com.example.paises;

import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.util.ResourceUtils;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    @Qualifier("PaisesService")
    CommandLineRunner loadPaises(IPaisesService ps) {
        return args -> {
            List<Pais> paises = new ArrayList<Pais>();
            List<String> nombrePaises = new ArrayList<String>();

            for(String line : PaisesService.cargarPaisesDesdeFichero()){
                String[] fields = line.split(";");
                nombrePaises.add(fields[0]);
                paises.add(new Pais(fields[0], fields[1], Integer.valueOf(fields[2])));
            }

            ps.setPaises(paises);
            ps.setNombrePaises(nombrePaises);
        };
    }

    @Bean
    CommandLineRunner init() {
        return args -> {
            String TERM_YELLOW = "\033[1;33m";
            String TERM_RESET  = "\033[0m";

            String port = "8080";
            List<String> lines = Files.readAllLines(ResourceUtils.getFile("classpath:application.properties").toPath());

            Pattern pattern = Pattern.compile("^server\\.port=\\d+$", 0);
            for(String line : lines){
                if(pattern.matcher(line).find()){
                    port = line.split("=")[1];
                    break;
                }
            }

            System.out.println("\nServer running at " + TERM_YELLOW + "http://localhost:" + port + "/" + TERM_RESET + "\n");
        };
    }
}
