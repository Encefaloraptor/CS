package com.example.myApp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Getter;
import lombok.Setter;

@Configuration
@Getter
@Setter
@PropertySource("classpath:/config/tarifas.properties")
public class Tarifas {
    @Value("${tarifaC}")
    private Double tarifaConsulta;

    @Value("${tarifaReceta}")
    private Double tarifaReceta;

    @Value("${tarifaRevisionAdulto}")
    private Double tarifaRevisionAdulto;

    @Value("${tarifaRevisionJubilado}")
    private Double tarifaRevisionJubilado;
}
