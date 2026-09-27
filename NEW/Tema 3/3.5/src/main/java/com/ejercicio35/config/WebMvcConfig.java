package com.ejercicio35.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration 
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(@NonNull ViewControllerRegistry registry) {
        registry.addViewController("/funnycats").setViewName("funnycatsView");
        registry.addViewController("/galeria").setViewName("galeriaView");
        registry.addViewController("/enlaces").setViewName("enlacesView");
    }
    
}
