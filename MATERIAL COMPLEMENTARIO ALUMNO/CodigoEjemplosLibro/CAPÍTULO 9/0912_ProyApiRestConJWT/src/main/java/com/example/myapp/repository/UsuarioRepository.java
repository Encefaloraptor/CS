package com.example.myapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.myapp.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
  Usuario findByNombre(String nombre);

  Boolean existsByNombre(String nombre);

  Boolean existsByEmail(String email);
}
