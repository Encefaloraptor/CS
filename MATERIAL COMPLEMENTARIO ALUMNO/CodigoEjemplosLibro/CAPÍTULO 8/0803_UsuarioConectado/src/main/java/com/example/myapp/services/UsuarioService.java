package com.example.myapp.services;

import java.util.List;

import com.example.myapp.domain.Usuario;

public interface UsuarioService {
    Usuario añadir(Usuario usuario);

    List<Usuario> obtenerTodos();

    Usuario obtenerPorId(long id);

    Usuario editar(Usuario usuario);

    void borrar(Long id);

    Usuario obtenerUsuarioConectado();
}
