package com.example.iud_digital2.services;

import com.example.iud_digital2.models.Usuario;

import java.util.List;

public interface UsuarioService {
    void agregarUsuario(Usuario usuario);

    void actualizarUsuario(Usuario usuario);

    void eliminarUsuario(int id);

    List<Usuario> obtenerUsuarios();

    Usuario obtenerUsuarioPorId(int id);
}
