package com.example.myapp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Getter;
import lombok.Setter;

@Configuration
@Getter
@Setter
@PropertySource("classpath:/config/parametros.properties")
public class Parametros {
    @Value("${porcentajeImpuesto}")
    private Double porcentajeImpuesto;
    @Value("${bonus}")
    private Integer bonus;
}
