package com.example.myapp.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
  @GetMapping("/all")
  public String showContentForAll() {
    return "{\"contenido\":\"Contenido público\"}";    //formato JSON
  }

  @GetMapping("/user")
  public String showContentForUsers() {
    return "{\"contenido\":\"Contenido para usuarios\"}";  //formato JSON
  }

  @GetMapping("/manager")
  public String showContentForManager() {
    return "{\"contenido\":\"Contenido para managers\"}";  //formato JSON
  }

  @GetMapping("/admin")
  public String showContentForAdmins() {
    return "{\"contenido\":\"Contenido para administradores\"}";  //formato JSON
  }
}
