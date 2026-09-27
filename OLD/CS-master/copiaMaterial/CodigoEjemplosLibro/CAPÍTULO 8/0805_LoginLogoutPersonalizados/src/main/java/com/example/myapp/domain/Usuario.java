package com.example.myapp.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

@Entity
public class Usuario {
   @Id
   @GeneratedValue (strategy=GenerationType.IDENTITY) 
   private Long id;

   @Column(unique = true)   //evita duplicados a nivel base de datos
   private String nombre;
   private String password;
   private Rol rol;
}
