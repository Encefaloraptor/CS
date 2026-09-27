package com.example.myapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller                     // anotación controlador
public class HomeController {
    @GetMapping("/")            // ruta a la que responde por GET
    public String showHome() {
        return "indexView";     // vista que devuelve
    }
         @GetMapping("/photogallery")
    public String getImage() {
    
        return "photogalleryViex";
    }
       @GetMapping("/nuevoSilksong")
    public String newView() {

        
        return "silksongView";
    }
       @GetMapping("/links")
    public String getLinks() {
 
        return "linksView";
    }
}
