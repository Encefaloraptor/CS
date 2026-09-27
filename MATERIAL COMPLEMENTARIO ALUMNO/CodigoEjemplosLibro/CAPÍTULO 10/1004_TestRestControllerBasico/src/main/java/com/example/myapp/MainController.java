package com.example.myapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @Autowired
    private MainService mainService;

    @GetMapping("/suma/{id1}/{id2}")
    public ResponseEntity<?> getSuma(@PathVariable Integer id1,
            @PathVariable Integer id2) {
        Integer suma = mainService.sumar(id1, id2);
        return ResponseEntity.ok(new Respuesta(id1, id2, suma));
    }
}
